package tomkous.algos;

import java.util.*;


public class BetterProgrammerTask4 {

    // Please do not change this interface
    public static interface Node {
        int getValue();
        List<Node> getChildren();
    }


    public static int getLargestRootToLeafSum(Node root) {
        /*
          A root-to-leaf path in a tree is a path from a leaf node through all its ancestors
          to the root node inclusively.
          A "root-to-leaf sum" is a sum of the node values in a root-to-leaf path.

          Please implement this method to
          return the largest root-to-leaf sum in the tree.
         */
    	int temp = 0;
    	int indice = 0;
    	int res = root.getValue();
    	
    	if(root.getChildren()==null)
    		return root.getValue();
    	else{
    		for(Node n : root.getChildren()){
    			if( n.getValue()>temp){
    				temp = n.getValue();   					
    			}
    			indice++;
    		}
    		res = res + temp;
    	}
    	return getLargestRootToLeafSum(root.getChildren().get(indice));
    			
    }
    		

}
