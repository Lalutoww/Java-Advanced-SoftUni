public class Main {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();

        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.push(5);
        customStack.push(6);

        System.out.println("Peek: " + customStack.peek());
        System.out.println("Removed: " + customStack.pop());
        System.out.println("Peek: " + customStack.peek());

        System.out.println("Removed: " + customStack.pop());
        System.out.println("Peek: " + customStack.peek());
        System.out.println("Removed: " + customStack.pop());
        System.out.println("Peek: " + customStack.peek());


        System.out.println();

    }
}
