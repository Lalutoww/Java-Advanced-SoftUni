package JarOfT;

public class MainClass {
    public static void main(String[] args) {
        Jar<String> jar = new Jar<>();

        jar.add("Hello");
        jar.add("Test");
        jar.add("Test2");
        String removedWord = jar.remove();
    }
}
