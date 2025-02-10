import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n=======INTEGER DEMO=======");
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();

        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);

        System.out.println("REMOVE FIRST (expected - 3): " + linkedList.removeFirst());
        System.out.println("REMOVE LAST (expected - 1): " + linkedList.removeLast());
        System.out.println("GET ELEMENT AT INDEX 0 (expected - 2): " + linkedList.get(0));

        linkedList.addLast(4);
        linkedList.addLast(6);
        //Expected result - 2 4 6
        linkedList.forEach(x -> System.out.print(x + " "));

        List<Integer> nodes = linkedList.toList();
        System.out.println("\nNODES IN LIST PRINT:");
        for (int node : nodes) {
            System.out.print(node + " ");
        }

        System.out.println("\n=======STRING DEMO=======");
        DoublyLinkedList<String> linkedListOfStrings = new DoublyLinkedList<>();

        linkedListOfStrings.addFirst("one");
        linkedListOfStrings.addFirst("two");
        linkedListOfStrings.addFirst("three");

        System.out.println("REMOVE FIRST (expected - three): " + linkedListOfStrings.removeFirst());
        System.out.println("REMOVE LAST (expected - one): " + linkedListOfStrings.removeLast());
        System.out.println("GET ELEMENT AT INDEX 0 (expected - two): " + linkedListOfStrings.get(0));

        linkedListOfStrings.addLast("four");
        linkedListOfStrings.addLast("six");
        //Expected result - two four six
        linkedListOfStrings.forEach(x -> System.out.print(x + " "));

        List<String> nodesOfStrings = linkedListOfStrings.toList();
        System.out.println("\nNODES IN LIST PRINT:");
        for (String node : nodesOfStrings) {
            System.out.print(node + " ");
        }
    }
}
