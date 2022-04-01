/***
 * The DoublyLinkedList class is the classical data structure used for this lab in which each node or element in the structure
 * can call the element before or after it. This class uses methods from Node.java to execute most of its own methods.
 * There are some special methods for this lab like insertAlpha which inserts nodes in alphabetical order or findPosition
 * which locates the position of a node.
 *
 * @param <E> This parameter is generic.
 */

public class DoublyLinkedList<E extends Comparable<E>>{

    private Node<E> header; // first node in the linked list which should always be null.
    private Node<E> trailer; // last node in the linked list which should also always be null.
    private int size = 0; // the size of the list

    public DoublyLinkedList(){ // constructor for making a new doubly linked list which is empty. Creates a header
        // and trailer.
        header = new Node<>(null, null, null);
        trailer = new Node<>(null,header,null);
        header.setNext(trailer);

    }

    public int getSize() {return size;} // returns the size of the doublylinkedlist
    public boolean isEmpty() {return size == 0;} // if the list is empty

    public E first(){ // returns the NameData of the first element in the doubly linked list.
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public E last() {
        if(isEmpty()) return null;
        return trailer.getPrev().getElement();
    } // returns the NameData of the last element in the doublyLinkedList.

    public void addFirst(E e){ // If we want to add a NameData at the front of the list
        addBetween(e, header, header.getNext());
    }

    public void addLast(E e){ // If we want to add a NameData at the end of the list
        addBetween(e, trailer.getPrev(), trailer);
    }

    public E removeFirst(){
        if (isEmpty()) return null;
        return remove(header.getNext());
    } // If we want to remove the first node in the list

    public E removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    } // If we want to remove the last node in the list.

    private Node<E> addBetween(E e, Node<E> predecessor, Node<E> successor){
        // In order to add between two nodes, we need to be given what nodes to add between and the NameData for the new node
        // create and link a new node
        Node<E> newest = new Node<>(e, predecessor, successor); // we create a new node linking to the NameData
        predecessor.setNext(newest); // the new node becomes the predecessor's new next
        successor.setPrev(newest); // the new node becomes the successor's new previous
        size++; // increase the size of the list
        return newest; // also return the node newest linking to NameData e
    }

    private E remove(Node<E> node){
        Node<E> predecessor = node.getPrev();
        Node<E> successor = node.getNext();
        predecessor.setNext(successor); // we link the node's successor to its old predecessor
        successor.setPrev(predecessor); // we link the node's predecessor to its old successor
        size--; // decrease the size of the list
        return node.getElement();
    }

    // This method inserts the nodes in alphabetical order.
    public void insertAlpha(E inputName){
        try {
            Node<E> curr = header.getNext(); // we create a node that is header.getNext() to traverse the linked list
            while (curr != trailer) {
                if (inputName.compareTo(curr.getElement()) == 0) { // we first check if the node is equal
                    // System.out.println("element is already in list");
                    return;
                } else if (inputName.compareTo(curr.getElement()) < 0) { // if the compareTo
                    // method returns something less than 0, then we can add a new node
                    addBetween(inputName, curr.getPrev(), curr);
                    return;
                }
                else if (inputName.compareTo(curr.getElement()) > 0) { // if it is greater then we continue on the linked
                    // list
                    curr = curr.getNext();
                }
            }
            addLast(inputName); // if we get through the whole linked list, then the node must be added to the end.
        } catch (NullPointerException e){
            System.out.println("Node is null and cannot perform operation.");
        }
    }

    // Retrieves the NameData connected with a name.
    public E fetch(String name){
        Node<E> curr = header.getNext(); // we set curr as a node to travel through the list.
        try {
            while (curr != trailer) {
                if (curr.getElement().toString().equals(name)) { // if the strings are equal, then we can return the
                    // name data.
                    return curr.getElement();
                }
                curr = curr.getNext(); // set current to the next one if it is not found.
            }
        } catch (NullPointerException e) {
            System.out.println(name + " could not be retrieved.");
        }
        return null;
    }

    // Finds the position of a name in the DoublyLinkedList of all the names searched
    public int findPosition(String name){
        if (!isEmpty()){ // if the list is not empty
            Node<E> curr = header.getNext(); // use curr to traverse the list
            int counter = 1; // to return the position of the node
            while (curr != trailer){ // when curr reaches the end, we stop
                if (curr.getElement().toString().equals(name)){
                    return counter;
                }
                counter++; // increase if it is not equal
                curr = curr.getNext(); // make current equal to the next element
            }
        }
        return -1; // if we never return counter, then the only other option is -1
    }

    // Turns the whole doublyLinked-list into a long string connected by arrows.
    @Override
    public String toString(){
        if (isEmpty()){
            return "List is Empty";
        }
        Node<E> curr = header.getNext(); // Start with the node after the header
        StringBuilder str = new StringBuilder(curr.getElement().toString()); // Using toString from the Node Class
        while (curr.getNext() != trailer){ // Keep hopping until the next node is the trailer
            curr = curr.getNext();
            str.append(" -> ").append(curr.getElement().toString()); // Using toString from the Node Class
        }
        return str.toString();
    }
}
