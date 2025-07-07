package LinkedList.DoublyLinkedList;

import java.util.Scanner;

class TextState {
    String content;
    TextState prev;
    TextState next;

    TextState(String content) {
        this.content = content;
    }
}

class TextEditor {
    private TextState head = null;
    private TextState tail = null;
    private TextState current = null;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    // Add a new state
    public void type(String newContent) {
        TextState newState = new TextState(newContent);

        // Remove redo history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
        }

        if (tail == null) {
            head = tail = newState;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
        }

        current = tail;
        size++;

        // Limit to 10 states
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("Text added.");
    }

    // Undo
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo done.");
        } else {
            System.out.println("No more undo available.");
        }
    }

    // Redo
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo done.");
        } else {
            System.out.println("No more redo available.");
        }
    }

    // Show current text
    public void showCurrent() {
        if (current != null) {
            System.out.println("Current Text: " + current.content);
        } else {
            System.out.println("No text available.");
        }
    }

    // Show history (optional)
    public void showHistory() {
        System.out.println("Text History:");
        TextState temp = head;
        while (temp != null) {
            System.out.println(temp.content + (temp == current ? " <- current" : ""));
            temp = temp.next;
        }
    }
}
