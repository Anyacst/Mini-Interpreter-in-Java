public class Parser {

  private Lexer lexer;
  private Token currentToken;
  
  Parser(Lexer lexer) {
    this.lexer = lexer;
    this.currentToken = lexer.getNextToken();
  }

  //To check if the currentToken is correct or not
  void eat(TokenType type) {
    if(currentToken.getTokenType() == type) {
      currentToken = lexer.getNextToken();
    } else {
      throw new RuntimeException(
          "Invalid Syntax: found :" + currentToken.getTokenType() + "Expected :" + type
      );
    }
  }

  AST parse() {
    return expr();
  }

  AST expr() {
    AST node = term();
    while(currentToken.getTokenType() == TokenType.MINUS ||
        currentToken.getTokenType() == TokenType.PLUS) {

      Token token = currentToken;
      if(currentToken.getTokenType() == TokenType.MINUS) {
        eat(TokenType.MINUS);
      } else {
        eat(TokenType.PLUS);
      }
      node = new BinOp(node, token, term());
    }

    return node;
  }

  AST term() {
    AST node = power();

    while(currentToken.getTokenType() == TokenType.DIVIDE ||
        currentToken.getTokenType() == TokenType.MULTIPLY) {

      Token token = currentToken;
      if(currentToken.getTokenType() == TokenType.DIVIDE) {
        eat(TokenType.DIVIDE);
      } else {
        eat(TokenType.MULTIPLY);
      }
      node = new BinOp(node, token, factor());
    }

    return node;
  }

  AST power() {

    AST node = factor();

    Token token = currentToken;
    while(currentToken.getTokenType() == TokenType.POWER) {
      eat(TokenType.POWER);
      node = new BinOp(node,token, power());
    }

    return node;
  }

  AST factor() {
    Token token = currentToken;
    
    if(currentToken.getTokenType() == TokenType.MINUS) {
      eat(TokenType.MINUS);
      return new UnaryOp(token, factor());
    }

    if(currentToken.getTokenType() == TokenType.PLUS) {
      eat(TokenType.PLUS);
      return new UnaryOp(token, factor());
    }

    if(currentToken.getTokenType() == TokenType.NUMBER) {
      eat(TokenType.NUMBER);
      return new Num(token);
    }

    if(currentToken.getTokenType() == TokenType.LPAREN) {
      eat(TokenType.LPAREN);
      AST node = expr();
      eat(TokenType.RPAREN);
      return node;
    }

    throw new RuntimeException(
      "Invalid Syntax: " + currentToken.toString() + " found"
    );
  }
}
