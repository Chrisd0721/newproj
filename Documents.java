package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Documents {
	static Scanner scanner = new Scanner(System.in);
	public static void docs() {
		System.out.println("1. Insert Documents");
        System.out.println("2. View Documents");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                insertdoc();
                break;
            case 2:
                viewdoc();
                break;
            case 3:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }

public static void insertdoc() {
    try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://documents.accdb")) {
        System.out.print("Enter the document file type (Resume, employment verification): ");
        String doctype = scanner.nextLine();
        System.out.print("Enter the name of the file (Resume.png, employmentverification.jpg): ");
        String docname = scanner.nextLine();
        System.out.print("Enter the name of the person whom uploaded the file (Christian David): ");
        String docperson = scanner.nextLine();
        System.out.print("Enter todays date and time (2/13/2024 11:56am): ");
        String doctime = scanner.nextLine();
        

        String sql = "INSERT INTO documents (Document_Type,File_Name, Uploaded_By, Uploaded_Time) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, doctype);
            statement.setString(2, docname);
            statement.setString(3, docperson);
            statement.setString(4, doctime);
            
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Document inserted successfully!");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public static void viewdoc() {
    try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://documents.accdb")) {
    	
        System.out.print("Enter the document ID to view: ");
        int docID = scanner.nextInt();
        scanner.nextLine();
        
        String sql = "SELECT * FROM documents WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, docID);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String doctypes = resultSet.getString("Document_Type");
                    String docnames = resultSet.getString("File_Name");
                    String docpersons = resultSet.getString("Uploaded_By");
                    String doctimes = resultSet.getString("Uploaded_Time");
                    
                    
                    System.out.println("Document ID: " + docID);
                    System.out.println("Document name: " + doctypes);
                    System.out.println("Document file name: " + docnames);
                    System.out.println("The person who uploaded this document is: " + docpersons);
                    System.out.println("This document was uploaded at: " + doctimes);
                } else {
                    System.out.println("No Document found with ID " + docID);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

								}
}