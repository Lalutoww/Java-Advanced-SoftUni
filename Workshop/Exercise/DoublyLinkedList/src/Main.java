public class Main {
    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();

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
    }
}
