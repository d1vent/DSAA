package list;

public class SingleLinkedList {
    Node head = null;
    public class Node
    {
        String data;
        Node next;

        public Node(String data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
    public void append(String data)
    {
        head = append(data,head);
    }
    private Node append(String data, Node node)
    {
        if(node == null) return new Node(data,null);
        node.next = append(data, node.next);
        return node;
    }
    public void removeFirst(String data)
    {
        head = removeFirst(data, head);
    }
    private Node removeFirst(String data, Node node)
    {
        if(node == null) return null;
        if(node.data.equals(data)) return node.next; // neu node hien tai chua data -> xoa luon(tra ve node ke tiep)
        node.next = removeFirst(data, node.next);
        return node;
    }
    public void removeAll(String data)
    {
        head = removeAll(data, head);
    }
    public Node removeAll(String data, Node node)
    {
        if(node == null) return null;
        if(node.data.equals(data)) removeAll(data, node.next);
        node.next = removeAll(data, node.next);
        return node;
    }
    public String toString()
    {
        return "[" + toString(head) + "]";
    }
    private String toString(Node node)
    {
        if(node == null) return "";
        return node.data + toString(node.next);
    }
    public static void main(String[] args)
    {
        SingleLinkedList list = new SingleLinkedList();
        list.append("One");
        list.append("Two");
        list.append("Three");
        list.append("One");
        System.out.println(list);

    }
}
