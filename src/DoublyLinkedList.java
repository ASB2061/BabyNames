/***
 * The DoublyLinkedList class is the classical data structure used for this lab in which each node or element in the structure
 * can call the element before or after it. This class uses methods from Node.java to execute most of its own methods.
 *
 *
 * @param <E> This list uses the specific parameter of NameData which holds a babyName and the number of occurences.
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

    public void insertAlpha(E inputName){ // This method inserts name data in alphabetical order

        if (isEmpty()) { // obviously if the list is empty we add it in the front.
            addFirst(inputName);
            return;
        }
        try {
            Node<E> curr = header.getNext(); // we create a node that is header.getNext() to traverse the linked list
            while (curr != trailer) {
                if (inputName.compareTo(curr.getElement()) == 0) { // we first check if the node is equal
                    System.out.println("element is already in list");
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

    public E fetch(String name){ // Retrieves the NameData
        if (size > 0) {
            Node<E> curr = header.getNext(); // we set curr as a node to travel through the list.
            try {
                while (curr != null) {
                    if (curr.getElement().toString().equals(name)) { // if the strings are equal, then we can return the
                        // name data.
                        return curr.getElement();
                    }
                    curr = curr.getNext(); // set current to the next one if it is not found.
                }
            } catch (NullPointerException e) {
                System.out.println("Name could not be retrieved.");
                return null; // had to write this b/c intellij was being fidgety about null
            }
        }
        return null; // if the list is empty, return null.
    }

    public int findPosition(String name){
        if (!isEmpty()) { // if the list is not empty
            int counter = 1; // tracks the position of the node in the list.
            Node<E> curr = header.getNext(); // use curr as the node to traverse the doubly linked list
            if (curr.getElement().toString().equals(name)){ // if the string is equal to the first node, then just return one, otherwise we
                // loop through the rest of the list.
                return 1;
            }
            try { // otherwise we must loop through the rest of the list
                while (curr.getNext() != null) { // when curr.getNext() is null then we have reached the trailer
                    if (name.equals(curr.getNext().getElement().toString())) { // since we are comparing the name to the
                        // node after the current node we will add one to the counter if they are equal.
                        return counter + 1;
                    }
                    curr = curr.getNext(); // set the node equal to the next node if they are not equal
                    counter++; // counter will also increment
                }
            } catch (NullPointerException e) { // This had to be written for intellij to stop being finicky
                return -1;
            }
        }
        else {return -1;}
        return -1;
        // the reason there are so many return -1;s is b/c of intellij's weird code checker.
    }

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
