package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Redirector {
	static Applications application = new Applications();
	static studentinfo students = new studentinfo();
	static Messageboards message = new Messageboards();
	static Employability employ = new Employability();
	static Documents doc = new Documents();
		static Scanner scan = new Scanner(System.in);
		
		public static void main(String[] args)
		{
			System.out.print("1 - Message Board\n2 - Student Information\n3 - Applications\n4 - Documents\n5 - Employability profile\nPlease pick between these selections:");
			int pick = scan.nextInt();
			
			switch(pick)
			{
			case 1:
				System.out.println("LOADING..");
				Messageboards.messaging();
				break;
			case 2:
				System.out.println("LOADING..");
				studentinfo.studentinfo();
				break;
			case 3:
				System.out.println("LOADING..");
				Applications.application();
				break;
			case 4:
				System.out.println("LOADING..");
				Documents.docs();;
				break;
			case 5:
				System.out.println("LOADING..");
				Employability.employ();;
				break;
				
			default:
				System.out.println("PLEASE ENTER A CORRECT SELECTION");
			}
		}
}