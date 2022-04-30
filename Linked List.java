package com.LinkedList;
import java.util.Scanner;

public class LinkedListDemo {
	
	public static class Node{
		int data;
		Node next;
	}
	
	public static class LinkedList {
		Node head;
		Node tail;
		int size=0;
		
		public void addAtBegin() {
			Node node=new Node();
			int data;
			
			System.out.println("Enter the element to insert: ");
			Scanner s=new Scanner(System.in);
			
			data=s.nextInt();
			
			node.data=data;
			node.next=null;
			
			if(size==0) {
				head=tail=node;
			
				
				System.out.println(data+" inserted successfully.\n");
			}
			else {
				node.next=head;
				head=node;
				
				System.out.println(data+" inserted successfully.\n");
			}
			size++;
		}
		
		public void addAtMiddle() {
			int index;
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the index: \n");
			index=s.nextInt();
			
			if(index<0 || index>size) {
				System.out.println("Invalid index\n");
				
			}else if(index==0) {
				addAtBegin();
				
			}else if(index==size) {
				addAtLast();
			}
			else {
				Node node=new Node();
				Node p=head;
				int data;
				
				System.out.println("Enter the element to insert: ");
				data=s.nextInt();
				node.data=data;
				node.next=null;
				
				for(int i=0; i<index-1; i++) {
					p=p.next;
				}
				
				node.next=p.next;
				p.next=node;
				
				System.out.println(data+" inserted successfully.");
			}
			
			size++;
		}
		
		
		public void addAtLast() {
			Node node=new Node();
			int data;
			
			System.out.println("Enter the element to insert: ");
			Scanner s=new Scanner(System.in);
			
			data=s.nextInt();
			
			node.data=data;
			node.next=null;
			
			if(size==0) {
				head=tail=node;
				System.out.println(data+" inserted successfully.\n");
			}
			else {
				tail.next=node;
				tail=node;
				System.out.println(data+" inserted successfully.\n");
			}
			size++;
		}
		
		public void deleteAtBegin() {
			
			if(size==0) {
				System.out.println("List is empty.\n");
			}
			else if(size==1) {
				int data;
				data=head.data;
				
				head=tail=null;
				size=0;
				
				System.out.println(data+" deleted successfully.\n");
			}
			else {
				int data;
				data=head.data;
				
				head=head.next;
				size--;
				
				System.out.println(data+" deleted successfully.\n");
			}
		}
		
		public void deleteAtMiddle() {
			int index;
			int data;
			Scanner s=new Scanner(System.in);
			System.out.println("Enter the index: \n");
			index=s.nextInt();
			
			if(size==0) {
				System.out.println("List is empty\n");
			}
			else if(index<0 || index>size) {
				System.out.println("Invalid index.\n");
			}
			else if(index == 0) {
				deleteAtBegin();
			}
			else if(index == size) {
				deleteAtEnd();
			}
			else {
				Node p=head;
				
				for(int i=0; i<index-1; i++) {
					p=p.next;
				}
				
				data=p.next.data;
				p.next=p.next.next;
				size--;
				
				System.out.println(data+" deleted successfully.\n");
			}
			
		}
		
		public void deleteAtEnd() {
			if(size==0) {
				System.out.println("List is empty.\n");
			}
			else if(size==1) {
				int data;
				data=head.data;
				
				head=tail=null;
				size=0;
				
				System.out.println(data+" deleted successfully.\n");
			}
			else {
				int data;
				data=tail.data;
				
				Node p=head;
				
				while(p.next!=tail) {
					p=p.next;
				}
				
				p.next=null;
				tail=p;
				size--;
				
				System.out.println(data+" deleted successfully.\n");
			
			}
			
		}
		
	
		
		public void display() {
			if(size==0) {
				System.out.println("List is empty\n");
			}
			else {
				Node p=head;
				
				while(p!=null) {
					System.out.print(p.data+" ");
					p=p.next;
				}
				System.out.println("\n");
			}
		}
	}
	
	public static void main(String[] args) {
		LinkedList ll=new LinkedList();
		int c1, c2;
	
		while(true) {
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Display");
			System.out.println("4. Exit\n");
			System.out.println("Enter the choice:");
			
			Scanner s=new Scanner(System.in);
			c1=s.nextInt();
			
			switch(c1) {
			case 1: 
				System.out.println("1. Add at begin");
				System.out.println("2. Add at middle");
				System.out.println("3. Add at end");
				
				System.out.println("Enter the choice: ");
				c2=s.nextInt();
				
				switch(c2) {
				case 1:
					//add at begin
					ll.addAtBegin();
					break;
					
				case 2:
					//add at middle
					ll.addAtMiddle();
					break;
					
				case 3:
					//add at last
					ll.addAtLast();
					break;
					
				default:
					System.out.println("Invalid choice");
					
				}
				
				break;
				
			case 2: 
				System.out.println("1. Delete at begin");
				System.out.println("2. Delete at middle");
				System.out.println("3. Delete at end");
				
				System.out.println("Enter the choice: ");
				c2=s.nextInt();
				
				switch(c2) {
				case 1:
					//delete at begin
					ll.deleteAtBegin();
					break;
					
				case 2:
					//delete at middle
					ll.deleteAtMiddle();
					break;
					
				case 3:
					//delete at end
					ll.deleteAtEnd();
					break;
					
				default:
					System.out.println("Invalid choice");
					
				}
				
				break;
				
			case 3: 
				//display
				ll.display();
				break;
				
			case 4:
				System.exit(0);
				
			default:
				System.out.println("Invalid choice");
				
			}
			
		}
	}
}
