package com.bst;
import java.util.Scanner;

public class BST {

	class Node{
		int data;
		Node left, right;
		
		Node(int data){
			this.data=data;
			left=null;
			right=null;
		}
	}
	
	Node node;
	
	BST(){
		node = null;
	}
	
	public void  preInsert() {
		int data;
		int size;
		
		System.out.println("Enter the no. of Nodes to be inserted: ");
		Scanner s=new Scanner(System.in);
		size=s.nextInt();
		
		for(int i=0; i<size; i++) {
			System.out.println("Enter data "+(i+1)+": ");
			data=s.nextInt();
			node=insertRec(node, data);
		}
	}
	
	public void insert() {
		int data;
		
		System.out.println("Enter the node data: ");
		Scanner s=new Scanner(System.in);
		data=s.nextInt();
		
		node=insertRec(node, data);
		System.out.println("Data inserted.");
	}
	
	public void delete() {
		int data;
		
		System.out.println("Enter the Node data to delete: ");
		Scanner s=new Scanner(System.in);
		data=s.nextInt();
		
		node=deleteRec(node, data);
		System.out.println("Data deleted");
	}
	
	public Node insertRec(Node node, int data) {
		if(node==null) {
			Node new_node=new Node(data);
			return new_node;
		}
		if(data < node.data) {
			node.left=insertRec(node.left, data);
		}
		else if(data > node.data) {
			node.right=insertRec(node.right, data);
		}
		return node;
	}
	
	public int max(Node node) {
		if(node.right!=null) {
			return max(node.right);
		}
		else {
			return node.data;
		}
	}
	
	public Node deleteRec(Node node, int data) {
		if(node==null) {
			return null;
		}
		
		if(data < node.data) {
			node.left=deleteRec(node.left, data);
		}
		else if(data > node.data) {
			node.right=deleteRec(node.right, data);
		}
		else {
			//work
			
			if(node.left!=null && node.right!=null) {
				int lmax=max(node.left);
				node.left=deleteRec(node.left, lmax);
				node.data=lmax;
				return node;
			}
			else if(node.left!=null) {
				return node.left;
			}
			else if(node.right!=null) {
				return node.right;
			}
			else {
				return null;
			}
		}
		return node;
	}
	
	
	public void inOrder(Node node) {
		
		if(node==null) {
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}
	
	public Node searchNode(Node node, int data) {
		
		if(node==null || node.data==data){
			return node;
		}
		
		if(data < node.data) {
			return searchNode(node.left, data);
		}
		else {
			return searchNode(node.right, data);
		}
	}
	
	public void search() {
		int data;
		
		System.out.println("Enter data to search: ");
		Scanner s=new Scanner(System.in);
		data=s.nextInt();
		
		Node temp=searchNode(node, data);
		
		if(temp==null) {
			System.out.println("Node does not Exists!");
			return;
		}
		
		if(temp.data==data) {
			System.out.println("Node Exists!");
		}
		else {
			System.out.println("Node does not Exists!");
		}
	}
	
	public void display() {
		inOrder(node);
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		int cont;
		BST bst=new BST();
		
		bst.preInsert();
		System.out.print("Nodes: ");
		bst.display();
		
		do {
			System.out.println("1. Insert Node");
			System.out.println("2. Delete Node");
			System.out.println("3. Search Node");
			System.out.println("4. Display Nodes");
			
			System.out.println("Enter your choice: ");
			Scanner s=new Scanner(System.in);
			int choice=s.nextInt();
			
			switch(choice) {
			case 1:
				//insert 
				int ch;
				do {
					bst.insert();
					System.out.println("Do you want to continue to insert: ? (1, 0)");
					ch=s.nextInt();
					System.out.println();
				}while(ch==1);
				
				break;
				
			case 2:
				//delete
				bst.delete();
				break;
				
			case 3: 
				//search
				bst.search();
				break;
				
			case 4:
				//display
				bst.display();
				System.out.println();
				break;
				
			default: System.out.println("Invalid Input.");
			}
			
			System.out.println("Do you want to continue with choices... (1, 0)");
			cont=s.nextInt();
		}while(cont==1);

	}

}
