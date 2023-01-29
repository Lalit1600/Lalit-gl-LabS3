package com.gl.Question2;

import java.util.ArrayList;


public class FindLongestpath {
	
	public class Node {

		
		public static class TreeNode
		{
			public TreeNode left;
			public TreeNode right;
			int data;
		};

	
		public static TreeNode newNode(int data)
		{
			TreeNode temp = new TreeNode();

			temp.data = data;
			temp.left = null;
			temp.right = null;

			return temp;
		
		}

		
	}

	public static ArrayList<Integer> findLongestPath(Node.TreeNode root) {

		if (root == null) {
			ArrayList<Integer> output = new ArrayList<>();
			return output;
		}

		
		ArrayList<Integer> rightNode = findLongestPath(root.right);

		ArrayList<Integer> leftNode = findLongestPath(root.left);

		
		if (rightNode.size() < leftNode.size()) {
			leftNode.add(root.data);
		} else {
			rightNode.add(root.data);
		}

		return (leftNode.size() > rightNode.size() ? leftNode : rightNode);
	}

	
	public static void main(String[] args) {
		Node.TreeNode root = Node.newNode(40);
		root.left = Node.newNode(20);
		root.right = Node.newNode(60);
		root.left.left = Node.newNode(10);
		root.left.right = Node.newNode(30);
		root.right.left = Node.newNode(50);
		root.right.right = Node.newNode(70);
		

		ArrayList<Integer> output = findLongestPath(root);
		int n = output.size();

		System.out.print(output.get(n - 1));
		for (int i = n - 2; i >= 0; i--) {
			System.out.print(" -> " + output.get(i));
		}
	}

}
