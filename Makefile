# Java compiler
JAVAC = javac
JAVA = java

# Main class
MAIN = Main

# All java files
SRC = $(wildcard *.java)

# Class files
CLS = $(SRC:.java=.class)

# Default target
all: $(CLS)

# Compile rule
%.class: %.java
	$(JAVAC) $<

# Run program
run: all
	$(JAVA) $(MAIN)
	$(MAKE) clean

# Clean class files
clean:
	rm -f *.class
