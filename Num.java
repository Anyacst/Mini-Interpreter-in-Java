public class Num extends AST {
  Token token;
  double value;
  Num(Token token) {
    this.token = token;
    this.value = Double.parseDouble(token.getValue());
  }
}
