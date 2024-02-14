package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Messageboards {
	static Scanner scanner = new Scanner(System.in);
	public static void messaging() {
		
		System.out.println("1. Insert Message");
        System.out.println("2. View Messages");
        System.out.println("3. Exit");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                insertMessage();
                break;
            case 2:
                viewMessages();
                break;
            case 3:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }

public static void insertMessage() {
    try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://messages.accdb")) {
        System.out.print("Enter your message: ");
        String message = scanner.nextLine();
        
        String sql = "INSERT INTO messages (MessageInput) VALUES (?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, message);
            
            int rows = statement.executeUpdate();
            if (rows > 0) {
                System.out.println("Message inserted successfully!");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

public static void viewMessages() {
    try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://messages.accdb")) {
    	
        System.out.print("Enter the message ID to view: ");
        int messageId = scanner.nextInt();
        scanner.nextLine();
        
        String sql = "SELECT * FROM messages WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, messageId);
            
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String message = resultSet.getString("MessageInput");
                    System.out.println("Message ID: " + messageId);
                    System.out.println("Message: " + message);
                } else {
                    System.out.println("No message found with ID " + messageId);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
