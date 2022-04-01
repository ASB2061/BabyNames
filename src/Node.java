/***
 * The core structure used for the DoublyLinkedList class. This serves as a reference to name data class.
 * @param <E>
 */

public class Node<E> {
    private E element; // the actual element that the node is referencing
    private Node<E> prev; // the node that is before the current node
    private Node<E> next; // the node that is after the current node
    public Node(E e, Node<E> p, Node<E> n){ // constructor method for node
        element = e; // set the name data
        prev = p; // set the previous node
        next = n; // set the node coming after
    }

    // These are all self-explanatory.
    public E getElement(){return element;}
    public Node<E> getPrev() {return prev;}
    public Node<E> getNext() {return next;}
    public void setPrev(Node<E> p) {prev = p;}
    public void setNext(Node<E> n) {next = n;}
    public String toString(){return element.toString();}
}
