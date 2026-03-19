public class UnaryOp extends AST {
  Token op;
  AST expr;

  UnaryOp(Token op, AST expr) {
    this.op = op;
    this.expr = expr;
  }
}
