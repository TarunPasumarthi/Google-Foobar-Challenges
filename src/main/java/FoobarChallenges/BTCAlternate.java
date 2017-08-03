package FoobarChallenges;

/*Binary bunnies
==============
As more and more rabbits were rescued from Professor Booleans horrid laboratory,
you had to develop a system to track them, since some habitually continue to
gnaw on the heads of their brethren and need extra supervision.
For obvious reasons, you based your rabbit survivor tracking system on a binary
search tree, but all of a sudden that decision has come back to haunt you.
To make your binary tree, the rabbits were sorted by their ages and each,
luckily enough, had a distinct age.
For a given group, the first rabbit became the root,
and then the next one (taken in order of rescue) was added,
older ages to the left and younger to the right.
The order that the rabbits returned to you determined the end pattern of
the tree, and herein lies the problem.
Some rabbits were rescued from multiple cages in a single rescue operation,
and you need to make sure that all of the modifications or pathogens
introduced by Professor Boolean are contained properly.
Since the tree did not preserve the order of rescue, it falls to you to figure
out how many different sequences of rabbits could have produced an identical
tree to your sample sequence, so you can keep all the rescued rabbits safe.
For example, if the rabbits were processed in order from [5, 9, 8, 2, 1],
it would result in a binary tree identical to one created from [5, 2, 9, 1, 8].
You must write a function answer(seq) that takes an array of up to 50 integers
and returns a string representing the number (in base-10) of sequences that
would result in the same tree as the given sequence.
*/

import java.math.BigInteger;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class BNode{
	int digit;
	BNode left;
	BNode right;
	public BNode(int i) {
		digit= i;
		left=null;
		right=null;
	}
}
class BST{
	BNode root;
	void add(int i){
		BNode newNode= new BNode(i);
		if(root==null){
			root=newNode;
			return;
		}
		BNode node= root;
		while(true){
			if(node.digit>i){
				if(node.left==null){
					node.left=newNode;
					break;
				}
				else{
					node=node.left;
				}
			}
			else if(node.digit<i){
				if(node.right==null){
					node.right=newNode;
					break;
				}
				else{
					node=node.right;
				}
			}
		}
	}
	LinkedList<Integer> getChildern(int i){
		BNode node= root;
		while(true){
			if(node.digit==i){
				LinkedList<Integer> retvals= new LinkedList<Integer>();
				if(node.left!=null){
					retvals.add(node.left.digit);
				}
				if(node.right!=null){
					retvals.add(node.right.digit);
				}
				return retvals;
			}
			else if(node.digit>i){
				node=node.left;
			}
			else if(node.digit<i){
				node=node.right;
			}
		}
	}
}

public class BTCAlternate {
	private static Map<Integer, BigInteger> storedVals = new HashMap<Integer, BigInteger>();
	
	private static BigInteger nCr(int n, int r) {
		if(r>n){
			return nCr(r, n);
		}
		BigInteger difference = factorial(n-r);
		BigInteger numerator = factorial(n);
		BigInteger denominator = factorial(r);
		denominator = denominator.multiply(difference);
		return numerator.divide(denominator);
	}
	
	private static BigInteger factorial(int number) {
		if(storedVals.containsKey(number)){
			return storedVals.get(number);
		}
		BigInteger retval = BigInteger.ONE;
		for(int i=1; i<=number; i++){
			retval = retval.multiply(BigInteger.valueOf(i));
		}
		storedVals.put(number, retval);
		return retval;
	}	
	
	private static String combinations(BNode node) {
		if(node == null){
			return "1";
		}
		int leftNodes = numNodes(node.left);
		int rightNodes = numNodes(node.right);
		int sum=leftNodes+rightNodes;
		BigInteger combinations;
		if(leftNodes<rightNodes){
			combinations  = nCr(sum, leftNodes);
		}
		else{
			combinations  = nCr(sum, rightNodes);
		}
		BigInteger leftComb = new BigInteger(combinations(node.left));
		BigInteger rightComb = new BigInteger(combinations(node.right));
		return combinations.multiply(leftComb).multiply(rightComb).toString();
	}
	
	private static int numNodes(BNode node) {
		if(node==null){
			return 0;
		}
		return 1+numNodes(node.left)+numNodes(node.right);
	}

	public static String answer(int[] seq) {
		BST tree = new BST();
		for(int i:seq){
			tree.add(i);
		}
		return combinations(tree.root);
	}
	public static void main(String[] args) {
		//int[] values = new int[]{5,2,9,1,8};
		int[] values = new int[]{4,2,6,1,3,5,7};
		System.out.println(answer(values));
		return;
	}
}
