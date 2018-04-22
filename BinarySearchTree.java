
class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean contains(Node root, int value) {
        //throw new UnsupportedOperationException("Waiting to be implemented.");
        System.out.println("Checking if tree contains " + value);
     if(root.value == value) {
         System.out.println("Root value is " + root.value);
         return true;
     }
        else if ((root.value < value) && (root.right!=null)){
        	root = root.right;
          return contains(root, value);
                //System.out.println("Just checked right child " + root.value);  
        }
                   
      else if((root.value > value) && (root.left!=null)){  
    	  root = root.left;
            return contains(root, value);
                //System.out.println("Just checked left child " + root.value);
                 
        }
     return false;
               
    }
    
    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);
        
        System.out.println(contains(n2, 3));
    }
}
