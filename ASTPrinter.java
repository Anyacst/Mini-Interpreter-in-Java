public class ASTPrinter {

    public static void print(AST node) {
        print(node, "", true);
    }

    private static void print(AST node, String prefix, boolean isLast) {
        if (node == null) return;

        // branch drawing
        System.out.print(prefix);
        System.out.print(isLast ? "└── " : "├── ");

        // print node
        if (node instanceof Num) {
            System.out.println("Num(" + ((Num) node).value + ")");
        }
        else if (node instanceof BinOp) {
            BinOp bin = (BinOp) node;
            System.out.println("BinOp(" + bin.op.getValue() + ")");

            // children
            print(bin.left, prefix + (isLast ? "    " : "│   "), false);
            print(bin.right, prefix + (isLast ? "    " : "│   "), true);
        }
        else if (node instanceof UnaryOp) {
            UnaryOp unary = (UnaryOp) node;
            System.out.println("Unary(" + unary.op.getValue() + ")");

            print(unary.expr, prefix + (isLast ? "    " : "│   "), true);
        }
    }
}
