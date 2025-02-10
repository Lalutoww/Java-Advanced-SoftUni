public class Main {
    public static void main(String[] args) {
        DoublyLinkedList linkedList = new DoublyLinkedList();

        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);

        System.out.println(linkedList.get(2));
        System.out.println(linkedList.get(4));
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
    }
}
