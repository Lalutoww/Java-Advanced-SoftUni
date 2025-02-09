public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();

        for (int i = 0; i < 5; i++) {
            smartArray.add(i);
        }

        System.out.println(smartArray.remove(1));
        System.out.println(smartArray.remove(2));


        System.out.println();
    }
}
