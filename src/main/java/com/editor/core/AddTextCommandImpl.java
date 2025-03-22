/*

Step 3: Create Concrete Command Classes
Each command operates on TextEditor but is in the same package,
so it can access TextEditor's package-private methods.

 */

package com.editor.core;

// Concrete Command: Add Text
public class AddTextCommandImpl implements Command {
    private final TextEditor editor;
    private final String textToAdd;

    public AddTextCommandImpl(TextEditor editor, String textToAdd) {
        this.editor = editor;
        this.textToAdd = textToAdd;
    }

    @Override
    public void execute() { // ✅ Accessible within the same package
        editor.addText(textToAdd);
    }

    @Override
    public void undo() {
        editor.deleteText(textToAdd.length());
    }
}


/*
By default, methods in a public class in Java have package-private (default) access, not private.

Access Modifiers in Java:
public → Accessible from anywhere.
private → Accessible only within the same class.
protected → Accessible within the same package and subclasses.
(No modifier) (default or package-private) → Accessible only within the same package.

//Example
public class Example {
    void defaultMethod() {  // No modifier → Package-private
        System.out.println("I am package-private");
    }

    private void privateMethod() {  // Explicitly private
        System.out.println("I am private");
    }
}

class Test {
    public static void main(String[] args) {
        Example obj = new Example();
        obj.defaultMethod();  // ✅ Accessible within the same package
        // obj.privateMethod();  // ❌ Compile-time error: private method not accessible
    }
}


Summary:
Methods inside a public class are not private by default.
If no access modifier is specified, they are package-private (accessible only within the same package).
If explicitly marked private, they are only accessible within the same class.

 */