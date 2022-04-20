package com.practice;
import java.util.*;

public class Practice {
	
	public static void maxHeapify(int[] arr, int n, int i) {
		int left=(2*i)+1;
		int right=(2*i)+2;
		int largest=i;
		
		if((left < n) && (arr[left] > arr[largest])) {
			largest=left;
		}
		
		if((right < n) && (arr[right] > arr[largest])) {
			largest=right;
		}
		
		if(largest!=i) {
			int temp=arr[i];
			arr[i]=arr[largest];
			arr[largest]=temp;
			
			maxHeapify(arr, n, largest);
		}
	}
	
	public static void minHeapify(int[] arr, int n, int i) {
		int left=(2*i)+1;
		int right=(2*i)+2;
		int largest=i;
		
		if((left < n) && (arr[left] < arr[largest])) {
			largest=left;
		}
		
		if((right < n) && (arr[right] < arr[largest])) {
			largest=right;
		}
		
		if(largest!=i) {
			int temp=arr[i];
			arr[i]=arr[largest];
			arr[largest]=temp;
			
			minHeapify(arr, n, largest);
		}
	}
	
	public static void buildMaxHeap(int[] arr, int n) {
		int lastChild=(n/2)-1;
		
		for(int i=lastChild; i>=0; i--) {
			maxHeapify(arr, n, i);
		}
	}
	
	public static void buildMinHeap(int[] arr, int n) {
		int lastChild=(n/2)-1;
		
		for(int i=lastChild; i>=0; i--) {
			minHeapify(arr, n, i);
		}
	}
	
	public static int sortMaxHeap(int arr[], int n){
        int lastElement=arr[n-1];
        int maxElement=arr[0];
        arr[0]=lastElement;
        
        n=n-1;
        arr[n]=maxElement;
        
        maxHeapify(arr, n, 0);
        return n;
    }
	
	public static int sortMinHeap(int arr[], int n){
        int lastElement=arr[n-1];
        int maxElement=arr[0];
        arr[0]=lastElement;
        
        n=n-1;
        arr[n]=maxElement;
        
        minHeapify(arr, n, 0);
        return n;
    }


	
	public static void main(String[] args) {
		int[] arr= new int[50];
		int n=0;
		int size=0;
		
		System.out.print("Enter the total no. of students: ");
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		size=n;
		System.out.println();
		
		if(size==0) {
			return;
		}
		
		for(int i=0; i<n; i++) {
			System.out.print("Enter student-"+(i+1)+" marks: ");
			arr[i]=s.nextInt();
		}
		int[] temp=arr.clone();
		System.out.println("\n");
		
		//print initial students marks
		System.out.println("Entered Students Marks: ");
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println("\n");
		
		
		//build for MAX
		buildMaxHeap(arr, n);
		
		//print for max
		System.out.println("Maximum Marks: "+arr[0]);
		System.out.print("Max Heap of Marks: ");
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		//head sort on MAX heap
		while(n!=0){
            n=sortMaxHeap(arr, n);
        }
        
        n=size;
        
        System.out.println();
        System.out.println("Heap Sort on Max Heap of Marks: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println();
        
        arr=temp;

		//build for MIN
		buildMinHeap(arr, n);
		
		//print for min
		System.out.println("Minimum Marks: "+arr[0]);
		System.out.print("Min Heap of Marks: ");
		
		for(int i=0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
		
		//heap sort on MIN heap
		while(n!=0){
            n=sortMinHeap(arr, n);
        }
        
        n=size;
        
        System.out.println();
        System.out.println("Heap Sort on Min Heap of Marks: ");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println();
		
	}
}
