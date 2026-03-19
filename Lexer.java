public class Lexer {
  
  private String text;
  private char currentChar;
  private int position;

  Lexer(String text) {
    this.text = text;
    this.position=0;
    this.currentChar = text.charAt(position);
  }

  public void advance() {
    position++;
    if(position >= text.length()) {
      currentChar = '\0';
    } else {
      currentChar = text.charAt(position);
    }
  }

  public void skipWhiteSpaces() {
    while(currentChar != '\0' && Character.isWhitespace(currentChar)) {
      advance();
    }
  }

  public String number() {
    StringBuilder res = new StringBuilder();
    boolean hasDot = false;

    while (currentChar != '\0' &&
          (Character.isDigit(currentChar) || currentChar == '.')) {

        if (currentChar == '.') {
            if (hasDot) break;   // second dot → stop
            hasDot = true;
        }

        res.append(currentChar);
        advance();
    }

    return res.toString();
  }

  public Token getNextToken() {
    while (currentChar != '\0') {
      if (Character.isWhitespace(currentChar)) {
        skipWhiteSpaces();
        continue;
      }

      if (Character.isDigit(currentChar)) {
        return new Token(TokenType.NUMBER,number()); 
      }

      if (currentChar == '+') {
        advance();
        return new Token(TokenType.PLUS, "+");
      }

      if(currentChar == '-') {
        advance();
        return new Token(TokenType.MINUS, "-");
      }

      if (currentChar == '*') {
        advance();
        return new Token(TokenType.MULTIPLY, "*");
      }

      if(currentChar == '/') {
        advance();
        return new Token(TokenType.DIVIDE, "/");
      }

      if(currentChar == '(') {
        advance();
        return new Token(TokenType.DIVIDE, "LPAREN");
      }
      
      if(currentChar == ')') {
        advance();
        return new Token(TokenType.DIVIDE, "RPAREN");
      }
      if(currentChar == '^') {
        advance();
        return new Token(TokenType.POWER, "POWER");
      }

      throw new RuntimeException("Invalid Token...");
    }

    return new Token(TokenType.EOF, "/0");
  }
}
