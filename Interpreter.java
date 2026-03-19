public class Interpreter {

  Double visit(AST node) {
    if(node instanceof Num) {
      return visitNum((Num) node);
    } 
    if(node instanceof BinOp) {
      return visitBinOp((BinOp)node);
    }
    if(node instanceof UnaryOp) {
      return visitUnaryOp((UnaryOp) node);
    }

    throw new RuntimeException(
        "Invalid AST tree..."
    );
  }

  Double visitUnaryOp(UnaryOp node) {
    Double value = visit(node.expr);

    if(node.op.getTokenType() == TokenType.PLUS) {
     return +value;
    }
    if(node.op.getTokenType() == TokenType.MINUS) {
      return -value;
    }

    throw new RuntimeException("Invalid Unary Operator...");
  }
  Double visitNum(Num node) {
    return node.value; 
  }

  Double visitBinOp(BinOp node) {
    
    Double left = visit(node.left);
    Double right = visit(node.right);

    if(node.op.getTokenType() == TokenType.PLUS) {
      return left + right;
    }
    if(node.op.getTokenType() == TokenType.MINUS) {
      return left - right;
    }
    if(node.op.getTokenType() == TokenType.MULTIPLY) {
      return left * right;
    }
    if(node.op.getTokenType() == TokenType.DIVIDE) {
      return left / right;
    }
    if(node.op.getTokenType() == TokenType.POWER) {
      return Math.pow(left, right);
    }
    throw new RuntimeException(
        "Invalid Operator..."
    );
  }


}
