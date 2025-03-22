/*

Step 4: Create the CommandManager (Invoker)
This class stores command history and allows undo/redo operations.

 */

package com.editor.manager;

import com.editor.core.Command;

import java.util.Stack;

// Invoker: Command Manager
public class CommandManager {
    private final Stack<Command> CommandHistory = new Stack<>();
    private final Stack<Command> redoStack = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        CommandHistory.push(command);
        redoStack.clear();  // Clear redo stack on new command execution
    }

    public void undo() {
        if (!CommandHistory.isEmpty()) {
            Command Command = CommandHistory.pop();
            System.out.println("Undo operation..");
            Command.undo();
            redoStack.push(Command);
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command Command = redoStack.pop();
            System.out.println("Redo operation..");
            Command.execute();
            CommandHistory.push(Command);
        } else {
            System.out.println("Nothing to redo.");
        }
    }
}