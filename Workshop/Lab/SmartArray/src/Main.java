public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();

        for (int i = 0; i < 4; i++) {
            smartArray.add(i);
        }

        smartArray.add(2, 5);
        System.out.println(smartArray.contains(5));
        System.out.println(smartArray.remove(2));
        System.out.println(smartArray.contains(3));
        System.out.println(smartArray.contains(5));

        System.out.println();
    }
}
