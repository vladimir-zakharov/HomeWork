package ListClass;

public class Main {

    public static void main(String[] argv) {
        List list = new List();
        list.addToHead(10);
        list.addToEnd(15);
        list.addToHead(5);
        List.ListElement position = list.firstPosition();
        position = list.nextPosition(position);
        list.deleteElement(position);
        position = list.firstPosition();
        list.insert(position, 55);
        System.out.println(list.amountElements());
        list.printList();
        list.deleteElement(list.firstPosition());
        list.deleteElement(list.endPosition());
        list.printList();
    }
}
