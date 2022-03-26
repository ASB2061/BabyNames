public class Node<NameData> {
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
