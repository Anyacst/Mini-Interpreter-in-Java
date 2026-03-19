import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Mini Interpreter (type 'exit' to quit)");
        System.out.println("--------------------------------------");

        while (true) {
            System.out.print(">>> ");

            String text = scanner.nextLine();

            // exit condition
            if (text == null || text.trim().equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            // skip empty input
            if (text.trim().isEmpty()) {
                continue;
            }

            try {
                // 🔹 Step 1: Lexer
                Lexer lexer = new Lexer(text);

                // 🔹 Step 2: Parser
                Parser parser = new Parser(lexer);
                AST tree = parser.parse();

                // 🔹 Step 3: Print AST 🌳
                System.out.println("\nAST:");
                ASTPrinter.print(tree);

                // 🔹 Step 4: Interpret
                Interpreter interpreter = new Interpreter();
                Double result = interpreter.visit(tree);

                // 🔹 Step 5: Output
                System.out.println("\nResult: " + result);
                System.out.println();

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println();
            }
        }

        scanner.close();
    }
}
