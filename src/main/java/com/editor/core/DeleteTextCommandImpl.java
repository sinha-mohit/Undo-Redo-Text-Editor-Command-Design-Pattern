package com.editor.core;

// Concrete Command: Delete Text
public class DeleteTextCommandImpl implements Command {
    private final TextEditor editor;
    private String deletedText = "";

    public DeleteTextCommandImpl(TextEditor editor, int length) {
        this.editor = editor;
        if (editor.getText().length() >= length) {
            deletedText = editor.getText().substring(editor.getText().length() - length);
        } else {
            deletedText = editor.getText();
        }
    }

    @Override
    public void execute() {
        editor.deleteText(deletedText.length());
    }

    @Override
    public void undo() {
        editor.addText(deletedText);
    }
}
