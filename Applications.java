package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Applications {

    public static void application() {
        Scanner scan = new Scanner(System.in);
        String databaseURL = "jdbc:ucanaccess://dbCareerApplications.accdb";

        try {
            Connection connection = DriverManager.getConnection(databaseURL);
            String sql2 = "INSERT INTO Applications_Tab (appinfo, appid) VALUES (?, ?)";
            PreparedStatement statement2 = connection.prepareStatement(sql2);

            System.out.println("------------------------------------");
            System.out.println("Experience Applications");

            System.out.println("Do you have any pending applications? (1 for yes, 0 for no) ");

            int pending = scan.nextInt();
            scan.nextLine();
            switch (pending) {
                case 1:
                    System.out.println("How many applications do you have pending?");
                    int appinput = scan.nextInt();
                    System.out.println("You are connected to applications.");

                    for (int counter = 0; counter < appinput; counter++) {
                        scan.nextLine();
                        
                        System.out.println("Enter an application name: ");
                        String appinfo = scan.nextLine();

                        System.out.println("Enter the application ID: ");
                        String appid = scan.nextLine();

                        statement2.setString(1, appinfo);
                        statement2.setString(2, appid);
                        statement2.executeUpdate();
                    }
                    System.out.println("Thank you, I will transfer you back now! ");
                    break;
                case 0:
                    System.out.println("Thank you, no pending applications.");
                    String appinfo2 = "N/a";
                    String appid2 = "N/a";

                    statement2.setString(1, appinfo2);
                    statement2.setString(2, appid2);
                    statement2.executeUpdate();
                
                    break;
                default:
                    System.out.println("ERROR");
                    break;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

	}
}


