public class NodeStack implements Stack {

    private Node top;

    public void add(String obj){
        Node newNode = new Node(obj, top);
        top = newNode;
    }

    public String get(){
        String value = top.value;
        top = top.next;
        return value;
    }

    private static class Node {
        String value;
        Node next;

        public Node(String valuea, Node next) {
            this.value = valuea;
            this.next = next;
        }
    }

}
