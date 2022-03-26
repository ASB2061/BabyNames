public class DoublyLinkedList<NameData> {

    private Node<NameData> header;
    private Node<NameData> trailer;
    private int size = 0;

    public DoublyLinkedList(){
        header = new Node<>(null, null, null);
        trailer = new Node<>(null,header,null);
        header.setNext(trailer);
    }

    public int getSize() {return size;}
    public boolean isEmpty() {return size == 0;}

    public NameData first(){
        if (isEmpty()) return null;
        return header.getNext().getElement();
    }

    public NameData last() {
        if(isEmpty()) return null;
        return trailer.getPrev().getElement();
    }

    public void addFirst(NameData e){
        addBetween(e, header, header.getNext());
    }

    public void addLast(NameData e){
        addBetween(e, trailer.getPrev(), trailer);
    }

    public NameData removeFirst(){
        if (isEmpty()) return null;
        return remove(header.getNext());
    }

    public NameData removeLast() {
        if (isEmpty()) return null;
        return remove(trailer.getPrev());
    }

    private Node<NameData> addBetween(NameData e, Node<NameData> predecessor, Node<NameData> successor){
        // create and link a new node
        Node<NameData> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
        return newest;
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
        if (isEmpty()) addFirst(inputName);
        Node<NameData> curr = addBetween(inputName, header, header.getNext());
        if(curr.getElement().toString().compareTo(header.getNext().getElement().toString()) > 0){

        }
        while (curr.getNext() != trailer){

            curr = curr.getNext();             // Keep hoping until the next node is the trailer

        }
    }

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
