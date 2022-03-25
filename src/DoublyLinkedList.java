public class DoublyLinkedList<NameData> {
    private Node<NameData> header;             // header sentinel
    private Node<NameData> trailer;            // trailer sentinel
    private int size;               // number of elements in the list

    public DoublyLinkedList( ) {
        header = new Node<NameData>(null, null, null);        // create header
        trailer = new Node<NameData>(null, header, null);        // trailer is preceded by header
        header.setNext(trailer);                                // header is followed by trailer
        size = 0;
    }

    // access methods
    public int size( ) { return size; }

    public boolean isEmpty( ) { return size == 0; }

    public NameData first( ) {
        if (isEmpty( ))
            return null;
        return header.getNext( ).getElement( );  // first element is beyond header
    }

    public NameData last( ) {
        if (isEmpty( ))
            return null;
        return trailer.getPrev( ).getElement( );  // last element is before trailer
    }

    // private update methods
    private void addBetween(NameData e, Node<NameData> predecessor, Node<NameData> successor) { // create and link a new node
        Node<NameData> newest = new Node<NameData>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private NameData remove(Node<NameData> node) {
        Node<NameData> predecessor = node.getPrev( );
        Node<NameData> successor = node.getNext( );
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement( );
    }

    // public update methods
    public void addFirst(NameData e) {
        addBetween(e, header, header.getNext( ));  // place just after the header
    }
    public void addLast(NameData e) {
        addBetween(e, trailer.getPrev( ), trailer); // place just before the trailer
    }
    public NameData removeFirst( ) {
        if (isEmpty( )) return null;    // nothing to remove
        return remove(header.getNext( ));    // first element is beyond header
    }
    public NameData removeLast( ) {
        if (isEmpty( )) return null;                // nothing to remove
        return remove(trailer.getPrev( ));        // last element is before trailer
    }

    public void insertAlpha(NameData inputName){
        addFirst(inputName);

        for (int i = 0; i < size; i++){
            header.getNext();
        }
    }
    /**
     * toString method for the Doubly Linked List class
     * @return a string containing the data in the nodes of the list
     */
    public String toString(){
        if (isEmpty()){
            return "List is Empty";
        }
        Node<NameData> curr = header.getNext();               // Start with the node after the header
        String str = curr.toString();                  // Using toString from the Node Class
        while (curr.getNext() != trailer){             // Keep hoping until the next node is the trailer
            curr = curr.getNext();
            str = str + " -> " + curr.toString();      // Using toString from the Node Class
        }
        return str;
    }
}
