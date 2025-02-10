public class Main {
    public static void main(String[] args) {
        CustomStack<Integer> customStackOfIntegers = new CustomStack<>();

        customStackOfIntegers.push(1);
        customStackOfIntegers.push(2);
        customStackOfIntegers.push(3);

        System.out.println("Peek: " + customStackOfIntegers.peek());
        System.out.println("Removed: " + customStackOfIntegers.pop());
        System.out.println("Peek: " + customStackOfIntegers.peek());

        for (Integer integer : customStackOfIntegers) {
            System.out.println(integer);
        }

        System.out.println("Peek: " + customStackOfIntegers.peek());

        customStackOfIntegers.forEach(x -> System.out.println(x + " -> " + x * 2));

        CustomStack<String> customStackOfStrings = new CustomStack<>();
        customStackOfStrings.push("!");
        customStackOfStrings.push("thank you for checking out my custom stack");
        customStackOfStrings.push("Hello World");

        customStackOfStrings.pop();
        customStackOfStrings.push("Hello user,");

        customStackOfStrings.forEach(x -> System.out.print(x + " "));
    }
}
