//Step 1: Define the Command Interface

package com.editor.core;

// Command Interface
public interface Command {
    void execute();
    void undo();
}
