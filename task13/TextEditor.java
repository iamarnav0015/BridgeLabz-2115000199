class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

public class TextEditor {
    private TextState current;
    private int maxHistorySize = 10;
    private int stateCount = 0;

    // Add a new text state to the history
    public void addState(String content) {
        TextState newState = new TextState(content);

        // If there's a current state, adjust the links
        if (current != null) {
            current.next = newState;
            newState.prev = current;
        }

        current = newState;

        // Clear forward history when adding a new state
        clearForwardHistory();

        // Maintain history size limit
        enforceHistoryLimit();

        System.out.println("New state added: \"" + content + "\"");
    }

    // Undo to the previous state
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: Current state is \"" + current.content + "\"");
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo to the next state
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: Current state is \"" + current.content + "\"");
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Display the current state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current state: \"" + current.content + "\"");
        } else {
            System.out.println("No content available.");
        }
    }

    // Enforce the history size limit by trimming the oldest states
    private void enforceHistoryLimit() {
        // Trim from the beginning if the history exceeds the max size
        TextState temp = current;
        stateCount = 1;

        // Traverse backward to count states
        while (temp.prev != null) {
            stateCount++;
            temp = temp.prev;
        }

        if (stateCount > maxHistorySize) {
            System.out.println("Trimming history to maintain max size...");
            // Find the node to remove
            temp = current;
            int stepsToRemove = stateCount - maxHistorySize;

            while (stepsToRemove > 0 && temp.prev != null) {
                temp = temp.prev;
                stepsToRemove--;
            }

            temp.prev = null; // Disconnect the old history
        }
    }

    // Clear forward redo history
    private void clearForwardHistory() {
        if (current != null) {
            current.next = null;
        }
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // Simulate user actions
        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");
        editor.displayCurrentState();

        // Undo actions
        editor.undo();
        editor.undo();
        editor.displayCurrentState();

        // Redo action
        editor.redo();
        editor.displayCurrentState();

        // Adding more states to trigger history limit
        editor.addState("First state");
        editor.addState("Second state");
        editor.addState("Third state");
        editor.addState("Fourth state");
        editor.addState("Fifth state");
        editor.addState("Sixth state");
        editor.addState("Seventh state");
        editor.addState("Eighth state");
        editor.addState("Ninth state");
        editor.addState("Tenth state");
        editor.addState("Eleventh state"); // Should trim history

        editor.displayCurrentState();
    }
}
