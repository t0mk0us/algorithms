package tomkous.algos.ms;

public class TamarasLinkedList {
	
	private LinkListNode head;
	
	public void insert(Integer data) {
		LinkListNode newNode = new LinkListNode(data);
		
		System.out.println("Inserting " + data);
		
		if (head == null) {
			head = newNode;
			return;
		}
		
		LinkListNode current = head;
		
		while (current.next != null) {
			current.next = newNode;
			
		}
	}
	
	public void display() {
		if(head == null) {
			System.out.println("An empty Node");
			return;
		}
		
		LinkListNode current = head;
		while (current != null) {
			System.out.println(current.data + " -> ");
			current = current.next;
		}
		System.out.println("End of the LinkedList");
	}

	public static void main(String[] args) {
		
		TamarasLinkedList list = new TamarasLinkedList();
		
		/*
		 * int nmbrOfElts = 3; int count = 0; int elt = 10;
		 * 
		 * do {
		 * 
		 * System.out.println(elt); list.insert(elt); list.display();
		 * System.out.println("count = " + count); elt = elt * 3 ; count++; } while
		 * (count < nmbrOfElts);
		 * 
		 * list.display();
		 */
        // Inserting elements
        list.insert(10);
        list.insert(20);
        list.insert(30);

        // Printing elements (Output: 10 -> 20 -> 30 -> null)
        list.display();
		}			
}
