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
