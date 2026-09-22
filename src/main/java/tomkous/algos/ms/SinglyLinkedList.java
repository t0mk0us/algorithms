package tomkous.algos.ms;

public class SinglyLinkedList<E> {

    // Node representation
    private static class Node<E> {
        private final E data;
        private Node<E> next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Add to the front of the list: O(1) time
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        System.out.println("Adding as first " + element);
        newNode.next = head;
        head = newNode;
        size++;
        System.out.println("head is " + head.data);
        System.out.println("size is " + size);
    }

    // Add to the end of the list: O(N) time
    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);
        System.out.println("Adding as last " + element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Remove from the front of the list: O(1) time
    public E removeFirst() {
        if (head == null) {
            return null;
        }
        E removedData = head.data;
        head = head.next;
        size--;
        return removedData;
    }

    // Check if element exists: O(N) time
    public boolean contains(E element) {
        Node<E> current = head;
        while (current != null) {
            if ((element == null && current.data == null) || 
                (element != null && element.equals(current.data))) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
    
    public static void main(String[] args) {
		
    	SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
    	
    	list.addFirst(10);
    	list.addFirst(20);
    	list.addFirst(30);
    	
    	list.toString();
    	System.out.println("Created LinkedList is " + list.toString());
    }
}

