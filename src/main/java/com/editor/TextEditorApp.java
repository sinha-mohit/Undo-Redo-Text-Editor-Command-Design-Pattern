package com.editor;

/*
Refactored Version for Strict Enforcement:
To ensure the client cannot call TextEditor methods directly:
Make TextEditor methods package-private (default access modifier in Java)
Keep TextEditor inside the same package as Command
Ensure the client does not import TextEditor

This forces the client to only interact through the CommandManager, enforcing the Command Design Pattern properly. 🚀
 */


/*
Refactored Version of the Command Design Pattern (Strict Encapsulation)
This version strictly enforces the Command Design Pattern by preventing the client from directly calling TextEditor methods.

Changes in Refactored Version
- Package-Level Restriction:
TextEditor methods are package-private (no public modifier).
The TextEditor class is in the same package as the commands.
The client (main method) cannot directly access TextEditor APIs.

- Client Interaction Restricted:
The client can only interact with CommandManager to execute commands.
No direct access to TextEditor methods.
 */


import com.editor.core.AddTextCommandImpl;
import com.editor.core.DeleteTextCommandImpl;
import com.editor.core.TextEditor;
import com.editor.manager.CommandManager;

public class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();  // Cannot be accessed outside package, main business logic but do not know any methods directly
        // editor.addText("5678hbvbnm") // cannot be accessed from outside the package as it has  no modifiers -> (No modifier) (default or package-private) → Accessible only within the same package.
        CommandManager commandManager = new CommandManager();

        // Type text
        commandManager.executeCommand(new AddTextCommandImpl(editor, "Hello "));
        commandManager.executeCommand(new AddTextCommandImpl(editor, "World!"));

        // Undo last action
        commandManager.undo();

        // Redo last undone action
        commandManager.redo();

        // Delete last 6 characters
        commandManager.executeCommand(new DeleteTextCommandImpl(editor, 9));

        // Undo delete
        commandManager.undo();

    }
}
