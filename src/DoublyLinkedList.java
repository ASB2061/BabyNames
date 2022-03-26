public class DoublyLinkedList<NameData> {
    private static class Node<NameData>{
        private NameData element;
        private Node<NameData> prev;
        private Node<NameData> next;
        public Node(NameData e, Node<NameData> p, Node<NameData> n){
            element = e;
            prev = p;
            next = n;
        }
        public NameData getElement(){return element;}
        public Node<NameData> getPrev() {return prev;}
        public Node<NameData> getNext() {return next;}
        public void setPrev(Node<NameData> p) {prev = p;}
        public void setNext(Node<NameData> n) {next = n;}
    }

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

    private void addBetween(NameData e, Node<NameData> predecessor, Node<NameData> successor){
        // create and link a new node
        Node<NameData> newest = new Node<>(e, predecessor, successor);
        predecessor.setNext(newest);
        successor.setPrev(newest);
        size++;
    }

    private NameData remove(Node<NameData> node){
        Node<NameData> predecessor = node.getPrev();
        Node<NameData> successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        size--;
        return node.getElement();
    }
}
