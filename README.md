# 🧮 Mini Interpreter in Java

A simple **expression interpreter (calculator)** built in Java using
**Lexer → Parser → AST → Interpreter** architecture.

---

## 🚀 Features

* ✅ Arithmetic operations: `+ - * /`
* ✅ Power operator: `^` (right associative)
* ✅ Unary operators: `+5`, `-5`, `--5`
* ✅ Operator precedence handling
* ✅ Parentheses support `( )`
* ✅ AST (Abstract Syntax Tree) visualization 🌳
* ✅ Interactive CLI (REPL)
* ✅ Build support using **Makefile**

---

## 🧠 Operator Precedence

From highest to lowest:

1. Parentheses `( )`
2. Power `^`
3. Unary `+ -`
4. Multiplication `* /`
5. Addition `+ -`

---

## ⚙️ Build & Run (Using Makefile)

### ▶️ Compile

```bash
make
```

### ▶️ Run

```bash
make run
```

### 🧹 Clean

```bash
make clean
```

---

## 💬 Example Usage

```
>>> 2 + 3
Result: 5

>>> -2 ^ 3 ^ 2

AST:
└── Unary(-)
    └── BinOp(^)
        ├── Num(2)
        └── BinOp(^)
            ├── Num(3)
            └── Num(2)

Result: -512
```

---

## 🌳 AST Example

Input:

```
-2 ^ 3 ^ 2 + 4
```

Output:

```
└── BinOp(+)
    ├── BinOp(^)
    │   ├── Unary(-)
    │   │   └── Num(2)
    │   └── BinOp(^)
    │       ├── Num(3)
    │       └── Num(2)
    └── Num(4)
```

---

## ⚠️ Notes

* Large exponent values may result in `Infinity` due to Java `double` limits.

Example:

```
>>> -2 ^ 5 ^ 5
Result: -Infinity
```

---

## 📁 Project Structure

```
.
├── Main.java
├── Lexer.java
├── Parser.java
├── Interpreter.java
├── AST.java
├── BinOp.java
├── UnaryOp.java
├── Num.java
├── Token.java
├── ASTPrinter.java
├── Makefile
```

---

## 🎯 Learning Concepts

This project demonstrates:

* Recursive descent parsing
* Abstract Syntax Trees (AST)
* Operator precedence & associativity
* Expression evaluation
* Interpreter design

---

## 🚀 Future Improvements

* Variables (`x = 5`)
* Functions (`sqrt(4)`)
* Better error handling
* Support for BigInteger / BigDecimal

---

## 👨‍💻 Author

Built as a learning project to understand how interpreters work internally.

---

## ⭐ If you like this project

Give it a ⭐ on GitHub!
