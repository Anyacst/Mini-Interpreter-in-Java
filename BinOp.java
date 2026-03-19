public class BinOp extends AST {
  AST left;
  Token op;
  AST right;

  BinOp(AST left, Token op, AST right) {
    this.left = left;
    this.op = op;
    this.right = right;
  }
}
