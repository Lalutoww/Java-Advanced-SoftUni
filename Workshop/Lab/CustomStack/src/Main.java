public class Main {
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack();

        customStack.push(1);
        customStack.push(2);
        customStack.push(3);
        customStack.push(4);
        customStack.push(5);
        customStack.push(6);
        customStack.push(7);

        System.out.println("Peek: " + customStack.peek());
        System.out.println("Removed: " + customStack.pop());
        System.out.println("Peek: " + customStack.peek());

        System.out.println("Removed: " + customStack.pop());
        System.out.println("Peek: " + customStack.peek());
        System.out.println("Removed: " + customStack.pop());
        System.out.println("Peek: " + customStack.peek());

        for (Integer integer : customStack) {
            System.out.println(integer);
        }

        System.out.println("Peek: " + customStack.peek());

        System.out.println("Removed: " + customStack.pop());
        System.out.println();
        System.out.println("Removed: " + customStack.pop());

        for (Integer integer : customStack) {
            System.out.println(integer);
        }
    }
}
