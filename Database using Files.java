package com.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Files {

	public static void insert(PrintWriter pw) {
		Scanner s=new Scanner(System.in);
		
		//take data
		System.out.print("Enter Student ID: ");
		int id=s.nextInt();
				
		System.out.print("Enter Student Name: ");
		String name=s.next();
				
		System.out.print("Enter Student Fees: ");
		int fees=s.nextInt();
				
		System.out.print("Enter Student City: ");
		String city=s.next();
		System.out.println();
				
		//add data
		pw.append(id+","+name+","+fees+","+city+"\n");
		pw.close();
		
		System.out.println("Records added Successfully.\n");
	}
	
	public static void display(PrintWriter pw) throws IOException{
		BufferedReader bf=new BufferedReader(new FileReader("Stud"));
		String s="";
		
		while((s=bf.readLine())!=null){
			String[] data=new String[4];
			data=s.split(",");
			
			System.out.println();
			for(int i=0; i<4; i++) {
				System.out.print(data[i]+" ");
			}
		}
		System.out.println("\n");
		bf.close();
		
	}
	
	public static void update(PrintWriter pw) throws IOException {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter to ID for which you want to update: ");
		int idToUpdate=s.nextInt();
		
		int[] updateOrNot=new int[4];
		String[] updateList=new String[4];
	
		String[] colNames={"ID:", "Name:", "Fees:", "City:"};
		
		// column selection for update
		System.out.println("Select the Columns to Update (0=no / 1=yes)");
		
		for(int i=1; i<colNames.length; i++) {
			System.out.print(colNames[i]+" (0=no / 1=yes) ");
			int choice=s.nextInt();
			
			//update update choices
			updateOrNot[i]=choice;
			
			if(choice==1) {
				System.out.println("Enter new value for: "+colNames[i]+": ");
				updateList[i]=s.next();
			}
			System.out.println();
			
		}
		
		//updating values
		StringBuffer sb=new StringBuffer();
		String st="";
		BufferedReader bf=new BufferedReader(new FileReader("Stud"));
		boolean recordFound=false;
		
		while((st=bf.readLine())!=null) {
			String[] data=new String[4];
			data=st.split(",");
			
			if(Integer.parseInt(data[0].trim())==idToUpdate) {
				recordFound=true;
				String row=data[0]+",";
				
				for(int i=1; i<data.length; i++) {
					
					if(updateOrNot[i]==1) {
						row=row+updateList[i]+",";
					}
					else {
						row=row+data[i]+",";
					}
				}
				sb.append(row);
				sb.append("\n");
			}
			else {
				sb.append(st);
				sb.append("\n");
			}
		}
		
		if(recordFound==true) {
			//update the original file
			File f=new File("Stud");
			PrintWriter p=new PrintWriter(new FileWriter(f, false));
			p.print(sb.toString());
			p.close();
			
			System.out.println("File updated Successfully.\n");
		}
		else {
			System.out.println(idToUpdate+" not found in Database.\n");
		}
		
		bf.close();
	}
	
	public static void delete(PrintWriter pw) throws IOException {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the ID to delete the record: ");
		int idToDelete=sc.nextInt();
		boolean recordFound=false;
		System.out.println();
		
		BufferedReader bf=new BufferedReader(new FileReader("Stud"));
		StringBuffer sb=new StringBuffer();
		String s="";
		
		//check for the id to delete
		while((s=bf.readLine())!=null) {
			String[] data=new String[4];
			data=s.split(",");
			
			
			if(Integer.parseInt(data[0])==idToDelete) {
				recordFound=true;
				//do nothing, skip this part
			}
			else {
				sb.append(s);
				sb.append("\n");
			}
		}
		
		//modify original file
		if(recordFound==true) {
			File f=new File("Stud");
			PrintWriter p=new PrintWriter(new FileWriter(f, false));
			p.print(sb.toString());
			p.close();
			
			System.out.println("Record with ID: "+idToDelete+" deleted Successfully.\n");
		}
		else {
			System.out.println("Record with ID: "+idToDelete+" does not exists.\n");
		}
		bf.close();
		
	}
	
	public static void search(PrintWriter pw) throws IOException {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the id to search: ");
		int idToSearch=sc.nextInt();
		boolean dataFound=false;
		System.out.println();
		
		BufferedReader bf=new BufferedReader(new FileReader("Stud"));
		String s="";
		
		System.out.println("Records found: ");
		while((s=bf.readLine())!=null) {
			String[] data=new String[4];
			data=s.split(",");
			
			if(Integer.parseInt(data[0])==idToSearch) {
				dataFound=true;
				
				for(int i=0; i<data.length; i++) {
					System.out.print(data[i]+" ");
				}
			}
			
		}
		System.out.println();
		
		if(dataFound==false) {
			System.out.println(idToSearch+" not exists in Database");
		}
		System.out.println("\n");
	}
	
	public static void main(String[] args) throws IOException {
		Scanner s=new Scanner(System.in);
		int choice=0;
		File f;
		PrintWriter pw;
		
		//insert(pw);
		//display(pw);
		//update(pw);
		//delete(pw);
		
		while(true) {
			System.out.println("1. Insert Records");
			System.out.println("2. Update Records");
			System.out.println("3. Delete Records");
			System.out.println("4. Search Records");
			System.out.println("5. Display Records");
			System.out.println("6. Exit\n");
			System.out.println("Enter the choice: ");
			
			choice=s.nextInt();
			
			switch(choice) {
			case 1:
				//create file
				f=new File("Stud");
				pw=new PrintWriter(new FileWriter(f, true));
				
				insert(pw);
				break;
				
			case 2://create file
				f=new File("Stud");
				pw=new PrintWriter(new FileWriter(f, true));
				
				update(pw);
				break;
				
			case 3:
				f=new File("Stud");
				pw=new PrintWriter(new FileWriter(f, true));
				
				delete(pw);
				break;
				
			case 4:
				f=new File("Stud");
				pw=new PrintWriter(new FileWriter(f, true));
				
				search(pw);
				break;
				
			case 5:
				f=new File("Stud");
				pw=new PrintWriter(new FileWriter(f, true));
				
				display(pw);
				break;
				
			default:
				System.exit(0);
			}
		}
		
		
	}

}
