public class Node<NameData> {
    private NameData element; // reference to the element stored at this node
    private Node<NameData> prev; // reference to the previous node in the list
    private Node<NameData> next; // reference to the subsequent node in the list

    public Node(NameData e, Node<NameData> p, Node<NameData> n) {
        element = e;
        prev = p;
        next = n;
    }

    public NameData getElement() {
        return element;
    }

    public Node<NameData> getPrev() {
        return prev;
    }

    public Node<NameData> getNext() {
        return next;
    }

    public void setPrev(Node<NameData> p) {
        prev = p;
    }

    public void setNext(Node<NameData> n) {
        next = n;
    }
}