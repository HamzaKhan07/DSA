package com.practice;
import java.util.*;


public class Practice {
	
	public static int[] insert(int[] arr, int size, int data) {
		int pos=(data%size);
		
		if(arr[pos]==-1) {
			arr[pos]=data;
			System.out.println(data+" inserted at index: "+pos+"\n");
			return arr;
		}
		else {
			// from pos to end;
			for(int i=pos; i<size; i++) {
				if(arr[i]==-1) {
					arr[i]=data;
					System.out.println(data+" inserted at index: "+i+"\n");
					return arr;
				}
			}
			
			//from start to pos;
			for(int i=0; i<pos; i++) {
				if(arr[i]==-1) {
					arr[i]=data;
					System.out.println(data+" inserted at index: "+i+"\n");
					return arr;
				}
			}
			
			//if place not found
			System.out.println("Array is Full\n");
			return arr;
		}
		
	}
	
	public static void printArr(int[] arr, int size) {
		for(int i=0; i<size; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n");
	}
	
	public static void search(int[] arr, int size, int data) {
		
		int pos=(data%size);
		
		//from pos to end;
		for(int i=pos; i<size; i++) {
			if(arr[i]==data) {
				System.out.println(data+" found at index: "+i+"\n");
				return;
			}
		}
		
		//for start to pos
		for(int i=0; i<pos; i++) {
			if(arr[i]==data) {
				System.out.println(data+" found at index: "+i+"\n");
				return;
			}
		}
		
		// if data is not found
		System.out.println(data+" is not found.\n");
	}

	public static void main(String[] args) {
		int size=0;
		int ch;
		int data;
		Scanner s=new Scanner(System.in);
		
		//input size
		System.out.print("Enter the size of array: ");
		size=s.nextInt();
		
		//create array
		int[] arr=new int[size];
		
		//initialize array
		for(int i=0; i<size; i++) {
			arr[i]=-1;
		}
		
		while(true) {
			System.out.println("1. Insert");
			System.out.println("2. Search");
			System.out.println("3. Display\n");
			System.out.println("4. Exit\n");
			System.out.print("Enter the choice: ");
			
			ch=s.nextInt();
			
			switch(ch) {
			case 1:
				System.out.print("Enter the element to insert: ");
				data=s.nextInt();
				
				arr=insert(arr, size, data);
				printArr(arr, size);
				break;
				
			case 2:
				System.out.print("Enter the element to search: ");
				data=s.nextInt();
				System.out.println();
				
				search(arr, size, data);
				break;
				
			case 3:
				System.out.println();
				printArr(arr, size);
				break;
				
			default:
				System.exit(0);
				
			}
		}
		
	}
}