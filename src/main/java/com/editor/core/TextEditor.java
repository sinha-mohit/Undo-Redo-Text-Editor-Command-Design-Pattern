/*

Step 2: Define the TextEditor Class (Receiver)
Methods are package-private (no public keyword)

Client cannot call addText() or deleteText() directly
 */

package com.editor.core;

// Receiver: TextEditor (main business logic present here)
public class TextEditor {  // No public modifier - Restricted to package
    private final StringBuilder text = new StringBuilder();

    void addText(String newText) {  // Package-private
        text.append(newText);
        System.out.println("Current Text: " + text);
    }

    void deleteText(int length) {  // Package-private
        if (text.length() >= length) {
            text.delete(text.length() - length, text.length());
        } else {
            text.setLength(0);
        }
        System.out.println("Current Text: " + text);
    }

    String getText() {  // Package-private
        return text.toString();
    }
}