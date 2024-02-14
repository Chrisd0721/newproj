package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employability2 {
	
	static Scanner scanner = new Scanner(System.in);
		public static void additionalliteracy() 
		{
			 try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://CTECourses.accdb")) {
			    	
			        System.out.print("Enter the Additional literacy Skills grade year to view (10-12): ");
			        int literacyID = scanner.nextInt();
			        scanner.nextLine();
			        
			      switch (literacyID)
			      {
			      case 10:
						System.out.println("Would you like to access the fall or spring Additional literacy skills? (1 for fall, 0 for spring): ");
						int pick = scanner.nextInt();
						switch (pick)
						{
						case 1:
							scanner.nextLine();
							Employability2.fall_10();
							break;
						case 0:
							scanner.nextLine();
							Employability2.spring10();
							break;
						default:
							System.out.println("PLEASE ENTER A CORRECT SELECTION");
							break;
						}
						
						break;
			      case 11:
						System.out.println("Would you like to access the fall or spring Additional literacy skills? (1 for fall, 0 for spring):");
						int pick2 = scanner.nextInt();
						switch (pick2)
						{
						case 1:
							scanner.nextLine();
							Employability2.fall_11();
							
							break;
						case 0:
							scanner.nextLine();
							Employability2.spring11();
							
							break;
						default:
							System.out.println("PLEASE ENTER A CORRECT SELECTION");
							break;
						}
						break;
			      case 12:
						System.out.println("LOADING..");
						Employability2.fall_12();
						break;
			      default:
						System.out.println("PLEASE ENTER A CORRECT SELECTION");
						break;
			      }
			 } catch (SQLException e) {
				e.printStackTrace();
			}		      
		}
		
		
		
		
		public static void fall_12() {
			 try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://CTECourses.accdb")) {
			        System.out.print("Please enter your rating on Civic: ");
			        String civic = scanner.nextLine();
			        System.out.print("Please enter your rating on creativity: ");
			        String Creativity = scanner.nextLine();
			        System.out.print("Please enter your rating on your economic skills: ");
			        String Economic = scanner.nextLine();
			        System.out.print("Please enter your rating on enviornmental skills: ");
			        String Environmental = scanner.nextLine();
			        System.out.print("Please enter your rating on global awareness: ");
			        String globalawareness = scanner.nextLine();
			        System.out.print("Please enter your rating on Health and Wellness: ");
			        String healthwellness = scanner.nextLine();
			        System.out.print("Please enter your rating on Scientific Literacy: ");
			        String scientificliteracy = scanner.nextLine();
			        			        
			        String deleteSql = "DELETE FROM LiteracySkills12Fall WHERE Person = ?";
			        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			            deleteStatement.setString(1, "Student");
			            deleteStatement.executeUpdate();
			        }

			        
			        
			        String sql = "INSERT INTO LiteracySkills12Fall (Person, Civic, Creativity, Economic, " +
                            "Environmental, Global_Awareness, Health_and_Wellness, Scientific_Literacy) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			        String person = "Student";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setString(1, person);
			            statement.setString(2, civic);
			            statement.setString(3, Creativity);
			            statement.setString(4, Economic);
			            statement.setString(5, Environmental);
			            statement.setString(6, globalawareness);
			            statement.setString(7, healthwellness);
			            statement.setString(8, scientificliteracy);
			            
			            int rows = statement.executeUpdate();
			            if (rows > 0) {
			                System.out.println("Document inserted successfully!");
			            }
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
			}
		
		
		public static void spring11() {

			 try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://CTECourses.accdb")) {
			        System.out.print("Please enter your rating on Civic: ");
			        String civic = scanner.nextLine();
			        System.out.print("Please enter your rating on creativity: ");
			        String Creativity = scanner.nextLine();
			        System.out.print("Please enter your rating on your economic skills: ");
			        String Economic = scanner.nextLine();
			        System.out.print("Please enter your rating on enviornmental skills: ");
			        String Environmental = scanner.nextLine();
			        System.out.print("Please enter your rating on global awareness: ");
			        String globalawareness = scanner.nextLine();
			        System.out.print("Please enter your rating on Health and Wellness: ");
			        String healthwellness = scanner.nextLine();
			        System.out.print("Please enter your rating on Scientific Literacy: ");
			        String scientificliteracy = scanner.nextLine();
			        			        
			        String deleteSql = "DELETE FROM LiteracySkills11Spring WHERE Person = ?";
			        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			            deleteStatement.setString(1, "Student");
			            deleteStatement.executeUpdate();
			        }

			        
			        
			        String sql = "INSERT INTO LiteracySkills11Spring (Person, Civic, Creativity, Economic, " +
                         "Environmental, Global_Awareness, Health_and_Wellness, Scientific_Literacy) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			        String person = "Student";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setString(1, person);
			            statement.setString(2, civic);
			            statement.setString(3, Creativity);
			            statement.setString(4, Economic);
			            statement.setString(5, Environmental);
			            statement.setString(6, globalawareness);
			            statement.setString(7, healthwellness);
			            statement.setString(8, scientificliteracy);
			            
			            int rows = statement.executeUpdate();
			            if (rows > 0) {
			                System.out.println("Document inserted successfully!");
			            }
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
		}
		public static void fall_11() {
			 try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://CTECourses.accdb")) {
			        System.out.print("Please enter your rating on Civic: ");
			        String civic = scanner.nextLine();
			        System.out.print("Please enter your rating on creativity: ");
			        String Creativity = scanner.nextLine();
			        System.out.print("Please enter your rating on your economic skills: ");
			        String Economic = scanner.nextLine();
			        System.out.print("Please enter your rating on enviornmental skills: ");
			        String Environmental = scanner.nextLine();
			        System.out.print("Please enter your rating on global awareness: ");
			        String globalawareness = scanner.nextLine();
			        System.out.print("Please enter your rating on Health and Wellness: ");
			        String healthwellness = scanner.nextLine();
			        System.out.print("Please enter your rating on Scientific Literacy: ");
			        String scientificliteracy = scanner.nextLine();;
			        			        
			        String deleteSql = "DELETE FROM LiteracySkills11Fall WHERE Person = ?";
			        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			            deleteStatement.setString(1, "Student");
			            deleteStatement.executeUpdate();
			        }

			        
			        
			        String sql = "INSERT INTO LiteracySkills11Fall (Person, Civic, Creativity, Economic, " +
                      "Environmental, Global_Awareness, Health_and_Wellness, Scientific_Literacy) " +
                      "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			        String person = "Student";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setString(1, person);
			            statement.setString(2, civic);
			            statement.setString(3, Creativity);
			            statement.setString(4, Economic);
			            statement.setString(5, Environmental);
			            statement.setString(6, globalawareness);
			            statement.setString(7, healthwellness);
			            statement.setString(8, scientificliteracy);
			            
			            int rows = statement.executeUpdate();
			            if (rows > 0) {
			                System.out.println("Document inserted successfully!");
			            }
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
		}

		public static void spring10() {
			 try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://CTECourses.accdb")) {
			        System.out.print("Please enter your rating on Civic: ");
			        String civic = scanner.nextLine();
			        System.out.print("Please enter your rating on creativity: ");
			        String Creativity = scanner.nextLine();
			        System.out.print("Please enter your rating on your economic skills: ");
			        String Economic = scanner.nextLine();
			        System.out.print("Please enter your rating on enviornmental skills: ");
			        String Environmental = scanner.nextLine();
			        System.out.print("Please enter your rating on global awareness: ");
			        String globalawareness = scanner.nextLine();
			        System.out.print("Please enter your rating on Health and Wellness: ");
			        String healthwellness = scanner.nextLine();
			        System.out.print("Please enter your rating on Scientific Literacy: ");
			        String scientificliteracy = scanner.nextLine();
			        			        
			        String deleteSql = "DELETE FROM LiteracySkills10Spring WHERE Person = ?";
			        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			            deleteStatement.setString(1, "Student");
			            deleteStatement.executeUpdate();
			        }

			        
			        
			        String sql = "INSERT INTO LiteracySkills10Spring (Person, Civic, Creativity, Economic, " +
                   "Environmental, Global_Awareness, Health_and_Wellness, Scientific_Literacy) " +
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			        String person = "Student";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setString(1, person);
			            statement.setString(2, civic);
			            statement.setString(3, Creativity);
			            statement.setString(4, Economic);
			            statement.setString(5, Environmental);
			            statement.setString(6, globalawareness);
			            statement.setString(7, healthwellness);
			            statement.setString(8, scientificliteracy);
			            
			            int rows = statement.executeUpdate();
			            if (rows > 0) {
			                System.out.println("Document inserted successfully!");
			            }
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
		}
		public static void fall_10() {
			 try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://CTECourses.accdb")) {
			        System.out.print("Please enter your rating on Civic: ");
			        String civic = scanner.nextLine();
			        System.out.print("Please enter your rating on creativity: ");
			        String Creativity = scanner.nextLine();
			        System.out.print("Please enter your rating on your economic skills: ");
			        String Economic = scanner.nextLine();
			        System.out.print("Please enter your rating on enviornmental skills: ");
			        String Environmental = scanner.nextLine();
			        System.out.print("Please enter your rating on global awareness: ");
			        String globalawareness = scanner.nextLine();
			        System.out.print("Please enter your rating on Health and Wellness: ");
			        String healthwellness = scanner.nextLine();
			        System.out.print("Please enter your rating on Scientific Literacy: ");
			        String scientificliteracy = scanner.nextLine();

			        			        
			        String deleteSql = "DELETE FROM LiteracySkills10Fall WHERE Person = ?";
			        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			            deleteStatement.setString(1, "Student");
			            deleteStatement.executeUpdate();
			        }

			        
			        
			        String sql = "INSERT INTO LiteracySkills10Fall (Person, Civic, Creativity, Economic, " +
                "Environmental, Global_Awareness, Health_and_Wellness, Scientific_Literacy) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			        String person = "Student";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setString(1, person);
			            statement.setString(2, civic);
			            statement.setString(3, Creativity);
			            statement.setString(4, Economic);
			            statement.setString(5, Environmental);
			            statement.setString(6, globalawareness);
			            statement.setString(7, healthwellness);
			            statement.setString(8, scientificliteracy);
			            
			            int rows = statement.executeUpdate();
			            if (rows > 0) {
			                System.out.println("Document inserted successfully!");
			            }
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
		}
}

