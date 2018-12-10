public class GenericNodeStack<E> {
    private Node<E> top;

    public void add(E element){
        Node<E> newNode = new Node(element, top);
        top = newNode;
    }

    public E get(){
        E value = top.value;
        top = top.next;
        return value;
    }

    private static class Node<E> {
        E value;
        Node next;

        public Node(E valuea, Node next) {
            this.value = valuea;
            this.next = next;
        }
    }
}
