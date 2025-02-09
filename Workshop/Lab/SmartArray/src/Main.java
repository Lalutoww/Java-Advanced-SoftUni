public class Main {
    public static void main(String[] args) {
        SmartArray<Integer> smartArrayOfIntegers = new SmartArray<>();

        for (int i = 0; i < 4; i++) {
            smartArrayOfIntegers.add(i);
        }

        smartArrayOfIntegers.add(2, 5);
        System.out.println(smartArrayOfIntegers.contains(5));
        System.out.println(smartArrayOfIntegers.remove(2));
        System.out.println(smartArrayOfIntegers.contains(3));
        System.out.println();
        System.out.println("FIRST PRINT:");
        smartArrayOfIntegers.forEach(System.out::println);
        System.out.println();
        System.out.println("ONLY EVEN NUMBERS:");
        smartArrayOfIntegers.forEach(x -> {
            if (x % 2 == 0) {
                System.out.println(x);
            }
        });

        SmartArray<String> smartArrayOfStrings = new SmartArray<>();
        smartArrayOfStrings.add("Hello");
        smartArrayOfStrings.add("World");
        smartArrayOfStrings.add("!");
        smartArrayOfStrings.add(2, "How are you");
        smartArrayOfStrings.remove(3);
        smartArrayOfStrings.add("?");

        System.out.println("\nFINAL MESSAGE:");
        smartArrayOfStrings.forEach(x -> System.out.print(x + " "));

        System.out.println("\n\nMESSAGE TO LOWERCASE:");
        smartArrayOfStrings.forEach(x -> System.out.print(x.toLowerCase() + " "));


    }
}
