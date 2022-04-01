/***
 * The DoublyLinkedList class is the classical data structure used for this lab in which each node or element in the structure
 * can call the element before or after it. This class uses methods from Node.java to execute most of its own methods.
 *
 *
 * @param <NameData> This list uses the specific parameter of NameData which holds a babyName and the number of occurences.
 */

public class DoublyLinkedList<NameData> {

    private Node<NameData> header; // first node in the linked list which should always be null.
    private Node<NameData> trailer; // last node in the linked list which should also always be null.
    private int size = 0;

    public DoublyLinkedList(){ // constructor for making a new doubly linked list which is empty. Creates a header
        // and trailer.
        header = new Node<>(null, null, null);
        trailer = new Node<>(null,header,null);
        header.setNext(trailer);
    }

    public int getSize() {return size;} // returns the size of the doublylinkedlist
    public boolean isEmpty() {return size == 0;} // if the list is empty

    public NameData first(){ // returns the NameData of the first element in the doubly linked list.
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public NameData last() {
        if(isEmpty()) return null;
        return trailer.getPrev().getElement();
    } // returns the NameData of the last element in the doublyLinkedList.

    public void addFirst(NameData e){ // If we want to add a NameData at the front of the list
        addBetween(e, header, header.getNext());
    }

    public void addLast(NameData e){ // If we want to add a NameData at the end of the list
        addBetween(e, trailer.getPrev(), trailer);
    }

    public NameData removeFirst(){
        if (isEmpty()) return null;
        return remove(header.getNext());
    } // If we want to remove the first node in the list

    public NameData removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    } // If we want to remove the last node in the list.

    private Node<NameData> addBetween(NameData e, Node<NameData> predecessor, Node<NameData> successor){
        // In order to add between two nodes, we need to be given what nodes to add between and the NameData for the new node
        // create and link a new node
        Node<NameData> newest = new Node<>(e, predecessor, successor); // we create a new node linking to the NameData
        predecessor.setNext(newest); // the new node becomes the predecessor's new next
        successor.setPrev(newest); // the new node becomes the successor's new previous
        size++; // increase the size of the list
        return newest; // also return the node newest linking to NameData e
    }

    private NameData remove(Node<NameData> node){
        Node<NameData> predecessor = node.getPrev();
        Node<NameData> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }

    public void insertAlpha(NameData inputName){
        if (isEmpty()) {
            addFirst(inputName);
            return;
        }
        try {
            Node<NameData> curr = addBetween(inputName, header, header.getNext());
            //Node<NameData> placeHolder;
            while (curr.getNext() != trailer) {
                if (inputName.toString().compareTo(curr.getNext().getElement().toString()) > 0) {
                    curr = curr.getNext();
                } else if (inputName.toString().compareTo(curr.getNext().getElement().toString()) < 0) {
                    addBetween(inputName, curr, curr.getNext());
                    break;
                }
            }
        } catch (NullPointerException e){
            System.out.println("Node is null and cannot perform operation.");
        }
    }

    public NameData fetch(String name){
        if (size > 0) {
            Node<NameData> curr = header.getNext();
            try {
                while (curr != trailer) {
                    if (curr.getElement().toString().equals(name)) {
                        return curr.getElement();
                    }
                    curr = curr.getNext();
                }
            } catch (NullPointerException e) {
                System.out.println("Name could not be retrieved.");
                return null;
            }
        }
        return null;
    }

    public int findPosition(String name){
        if (!isEmpty()) {
            int counter = 1;
            Node<NameData> curr = header.getNext();
            if (curr.getElement().toString().equals(name)){
                return counter;
            }
            try {
                while (curr.getNext() != null) {
                    if (name.equals(curr.getNext().getElement().toString())) {
                        return counter + 1;
                    }
                    curr = curr.getNext();
                    counter +=1;
                }
            } catch (NullPointerException e) {
                return -1;
            }
        }
        else {return -1;}
        return -1;
    }

    public String toString(){
        if (isEmpty()){
            return "List is Empty";
        }
        Node<NameData> curr = header.getNext();               // Start with the node after the header
        StringBuilder str = new StringBuilder(curr.getElement().toString());                  // Using toString from the Node Class
        while (curr.getNext() != trailer){             // Keep hoping until the next node is the trailer
            curr = curr.getNext();
            str.append(" -> ").append(curr.getElement().toString());      // Using toString from the Node Class
        }
        return str.toString();
    }
}
