package GenericScale;

public class MainClass {
    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("a", "c");
        System.out.println(stringScale.getHeavier());

        Scale<Integer> intScale = new Scale<>(2, 1);
        System.out.println(intScale.getHeavier());
    }

}
