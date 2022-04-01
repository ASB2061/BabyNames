/***
 * The core structure used for the DoublyLinkedList class. This serves as a reference to name data class.
 * @param <NameData>
 */

public class Node<NameData> {
    private NameData element; // the actual element that the node is referencing
    private Node<NameData> prev; // the node that is before the current node
    private Node<NameData> next; // the node that is after the current node
    public Node(NameData e, Node<NameData> p, Node<NameData> n){ // constructor method for node
        element = e; // set the name data
        prev = p; // set the previous node
        next = n; // set the node coming after
    }

    // These are all self-explanatory.
    public NameData getElement(){return element;}
    public Node<NameData> getPrev() {return prev;}
    public Node<NameData> getNext() {return next;}
    public void setPrev(Node<NameData> p) {prev = p;}
    public void setNext(Node<NameData> n) {next = n;}
    public String toString(){return element.toString();}
}
