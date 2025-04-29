// AssemblyLineSimulation.java
// Array-based stack + main driver for the assembly line inspections.
import jeliot.io.*;

class IntStack {
    private int[] elements;
    private int top;

    // Create a stack with given capacity
    public IntStack(int capacity) {
        elements = new int[capacity];
        top = -1;
    }

    // Push a value onto the stack (throws on overflow)
    public void push(int value) {
        if (top + 1 >= elements.length) {
            throw new IllegalStateException("Stack overflow: cannot push " + value);
        }
        elements[++top] = value;
    }

    // Pop the top value (throws on underflow)
    public int pop() {
        if (top < 0) {
            throw new IllegalStateException("Stack underflow: cannot pop");
        }
        return elements[top--];
    }
}

public class AssemblyLineSimulation {
    public static void main(String[] args) {
        // 1. Create stack for 3 inspection states
        IntStack stack = new IntStack(3);

        // 2. Push pre-inspection markers (2,1,0)
        stack.push(2);
        stack.push(1);
        stack.push(0);

        // 3. At each of 3 stations, pop & print
        System.out.println("Station 1 inspection result: " + stack.pop());
        System.out.println("Station 2 inspection result: " + stack.pop());
        System.out.println("Station 3 inspection result: " + stack.pop());
    }
}
