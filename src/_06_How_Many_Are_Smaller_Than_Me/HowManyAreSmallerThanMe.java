package _06_How_Many_Are_Smaller_Than_Me;

import _05_Intro_to_AVL_Trees.AVLNode;
import _05_Intro_to_AVL_Trees.AVLTree;

public class HowManyAreSmallerThanMe {

    /*
     * Given an AVLTree filled with the random numbers from 1 to 20, and a
     * single number within the AVL Tree, figure out how many numbers in the
     * AVLTree are smaller than the provided number and return the result.
     * 
     * You may want to create a helper method to search through the AVLTree and
     * count iteratively or recursively.
     */

    public int howManyAreSmallerThanMe(AVLTree<Integer> avlTree, int me) {

        return helper(avlTree.getRoot(), me);
        

    }

    public static int helper(AVLNode<Integer> curr, int me) {
    	if(curr == null) {
    		return 0;
    	}	
    	int cnt = 0;
    	AVLNode<Integer> right = curr.getRight();
    	AVLNode<Integer> left = curr.getLeft();
    	
    	cnt+=helper(left,me);
    	cnt+=helper(right, me);
    	if(curr.getValue() < me) {
    		cnt++;
    	}
    	return cnt;
    	
    }
}
