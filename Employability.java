package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employability {
	
	static Scanner scanner = new Scanner(System.in);
	static Employability2 addliteracy = new Employability2();
	static Employability3 technical = new Employability3();
	public static void employ() 
		{
		System.out.println("1. View CTE Courses");
        System.out.println("2. Employability Skills");
        System.out.println("3. Additional Literacy Skills");
        System.out.println("4. Technical Skills");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                ctecourse();
                break;
            case 2:
                employability();
                break;
            case 3:
                Employability2.additionalliteracy();
                break;
            case 4:
            	Employability3.technical();
                break;
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please choose a valid option.");
                break;
        	}
        }
		public static void ctecourse()
		{
			 try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://CTECourses.accdb")) {
			    	
			        System.out.print("Enter the CTE Course ID to view: ");
			        int cteID = scanner.nextInt();
			        scanner.nextLine();
			        
			        String sql = "SELECT * FROM CTE WHERE id = ?";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			            statement.setInt(1, cteID);
			            
			            try (ResultSet resultSet = statement.executeQuery()) {
			                if (resultSet.next()) {
			                    String coursename = resultSet.getString("ctecourse");
			                    String term = resultSet.getString("term");
			                    String hours = resultSet.getString("hours");
			                    String year = resultSet.getString("year");
			                    String status = resultSet.getString("status");
			                    String teacher = resultSet.getString("teacher");
			                    String commented = resultSet.getString("commented");
			                    
			                    
			                    System.out.println("ID: " + cteID);
			                    System.out.println("Course name: " + coursename);
			                    System.out.println("Term: " + term);
			                    System.out.println("Amount of hours: " + hours);
			                    System.out.println("Year: " + year);
			                    System.out.println("status: " + status);
			                    System.out.println("teacher: " + teacher);
			                    System.out.println("Comments: " + commented);
			                    
			                } else {
			                    System.out.println("No CTE Course found with ID " + cteID);
			                }
			            }
			        }
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }
	
		}
		public static void employability() 
		{
			 try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://CTECourses.accdb")) {
			    	
			        System.out.print("Enter the Employability grade year to view (10-12): ");
			        int employID = scanner.nextInt();
			        scanner.nextLine();
			        
			      switch (employID)
			      {
			      case 10:
						System.out.println("Would you like to access the fall or spring Employability skills? (1 for fall, 0 for spring): ");
						int pick = scanner.nextInt();
						switch (pick)
						{
						case 1:
							scanner.nextLine();
							Employability.fall_10();
							break;
						case 0:
							scanner.nextLine();
							Employability.spring10();
							break;
						default:
							System.out.println("PLEASE ENTER A CORRECT SELECTION");
							break;
						}
						
						break;
			      case 11:
						System.out.println("Would you like to access the fall or spring Employability skills? (1 for fall, 0 for spring):");
						int pick2 = scanner.nextInt();
						switch (pick2)
						{
						case 1:
							scanner.nextLine();
							Employability.fall_11();
							
							break;
						case 0:
							scanner.nextLine();
							Employability.spring11();
							
							break;
						default:
							System.out.println("PLEASE ENTER A CORRECT SELECTION");
							break;
						}
						break;
			      case 12:
						System.out.println("LOADING..");
						Employability.fall_12();
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
			        System.out.print("Please enter your rating on collaboration: ");
			        String collab = scanner.nextLine();
			        System.out.print("Please enter your rating on dependibility: ");
			        String dependability = scanner.nextLine();
			        System.out.print("Please enter your rating on your personal mind: ");
			        String personalmind = scanner.nextLine();
			        System.out.print("Please enter your rating on problem solving: ");
			        String problemsolve = scanner.nextLine();
			        System.out.print("Please enter your rating on professional awareness: ");
			        String professional = scanner.nextLine();
			        System.out.print("Please enter your rating on social awareness: ");
			        String socialaware = scanner.nextLine();
			        System.out.print("Please enter your rating on technology: ");
			        String tech = scanner.nextLine();
			        System.out.print("Please enter your rating on time and attendance: ");
			        String timeandattend = scanner.nextLine();
			        			        
			        String deleteSql = "DELETE FROM EmpSkills12Fall WHERE Person = ?";
			        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			            deleteStatement.setString(1, "Student");
			            deleteStatement.executeUpdate();
			        }

			        
			        
			        String sql = "INSERT INTO EmpSkills12Fall (Person, Collaboration, Dependable, Personal_Mindset, " +
                            "Problem_Solving, Professional_Attitude, Social_Awareness, Technology, Time_and_Attendance) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			        String person = "Student";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setString(1, person);
			            statement.setString(2, collab);
			            statement.setString(3, dependability);
			            statement.setString(4, personalmind);
			            statement.setString(5, problemsolve);
			            statement.setString(6, professional);
			            statement.setString(7, socialaware);
			            statement.setString(8, tech);
			            statement.setString(9, timeandattend);
			            
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
			        System.out.print("Please enter your rating on collaboration: ");
			        String collab = scanner.nextLine();
			        System.out.print("Please enter your rating on dependibility: ");
			        String dependability = scanner.nextLine();
			        System.out.print("Please enter your rating on your personal mind: ");
			        String personalmind = scanner.nextLine();
			        System.out.print("Please enter your rating on problem solving: ");
			        String problemsolve = scanner.nextLine();
			        System.out.print("Please enter your rating on professional awareness: ");
			        String professional = scanner.nextLine();
			        System.out.print("Please enter your rating on social awareness: ");
			        String socialaware = scanner.nextLine();
			        System.out.print("Please enter your rating on technology: ");
			        String tech = scanner.nextLine();
			        System.out.print("Please enter your rating on time and attendance: ");
			        String timeandattend = scanner.nextLine();
			        			        
			        String deleteSql = "DELETE FROM EmpSkills11Spring WHERE Person = ?";
			        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			            deleteStatement.setString(1, "Student");
			            deleteStatement.executeUpdate();
			        }

			        
			        
			        String sql = "INSERT INTO EmpSkills11Spring (Person, Collaboration, Dependable, Personal_Mindset, " +
                         "Problem_Solving, Professional_Attitude, Social_Awareness, Technology, Time_and_Attendance) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			        String person = "Student";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setString(1, person);
			            statement.setString(2, collab);
			            statement.setString(3, dependability);
			            statement.setString(4, personalmind);
			            statement.setString(5, problemsolve);
			            statement.setString(6, professional);
			            statement.setString(7, socialaware);
			            statement.setString(8, tech);
			            statement.setString(9, timeandattend);
			            
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
			        System.out.print("Please enter your rating on collaboration: ");
			        String collab = scanner.nextLine();
			        System.out.print("Please enter your rating on dependibility: ");
			        String dependability = scanner.nextLine();
			        System.out.print("Please enter your rating on your personal mind: ");
			        String personalmind = scanner.nextLine();
			        System.out.print("Please enter your rating on problem solving: ");
			        String problemsolve = scanner.nextLine();
			        System.out.print("Please enter your rating on professional awareness: ");
			        String professional = scanner.nextLine();
			        System.out.print("Please enter your rating on social awareness: ");
			        String socialaware = scanner.nextLine();
			        System.out.print("Please enter your rating on technology: ");
			        String tech = scanner.nextLine();
			        System.out.print("Please enter your rating on time and attendance: ");
			        String timeandattend = scanner.nextLine();
			        			        
			        String deleteSql = "DELETE FROM EmpSkills11Fall WHERE Person = ?";
			        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			            deleteStatement.setString(1, "Student");
			            deleteStatement.executeUpdate();
			        }

			        
			        
			        String sql = "INSERT INTO EmpSkills11Fall (Person, Collaboration, Dependable, Personal_Mindset, " +
                      "Problem_Solving, Professional_Attitude, Social_Awareness, Technology, Time_and_Attendance) " +
                      "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			        String person = "Student";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setString(1, person);
			            statement.setString(2, collab);
			            statement.setString(3, dependability);
			            statement.setString(4, personalmind);
			            statement.setString(5, problemsolve);
			            statement.setString(6, professional);
			            statement.setString(7, socialaware);
			            statement.setString(8, tech);
			            statement.setString(9, timeandattend);
			            
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
			        System.out.print("Please enter your rating on collaboration: ");
			        String collab = scanner.nextLine();
			        System.out.print("Please enter your rating on dependibility: ");
			        String dependability = scanner.nextLine();
			        System.out.print("Please enter your rating on your personal mind: ");
			        String personalmind = scanner.nextLine();
			        System.out.print("Please enter your rating on problem solving: ");
			        String problemsolve = scanner.nextLine();
			        System.out.print("Please enter your rating on professional awareness: ");
			        String professional = scanner.nextLine();
			        System.out.print("Please enter your rating on social awareness: ");
			        String socialaware = scanner.nextLine();
			        System.out.print("Please enter your rating on technology: ");
			        String tech = scanner.nextLine();
			        System.out.print("Please enter your rating on time and attendance: ");
			        String timeandattend = scanner.nextLine();
			        			        
			        String deleteSql = "DELETE FROM EmpSkills10Spring WHERE Person = ?";
			        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			            deleteStatement.setString(1, "Student");
			            deleteStatement.executeUpdate();
			        }

			        
			        
			        String sql = "INSERT INTO EmpSkills10Spring (Person, Collaboration, Dependable, Personal_Mindset, " +
                   "Problem_Solving, Professional_Attitude, Social_Awareness, Technology, Time_and_Attendance) " +
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			        String person = "Student";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setString(1, person);
			            statement.setString(2, collab);
			            statement.setString(3, dependability);
			            statement.setString(4, personalmind);
			            statement.setString(5, problemsolve);
			            statement.setString(6, professional);
			            statement.setString(7, socialaware);
			            statement.setString(8, tech);
			            statement.setString(9, timeandattend);
			            
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
			        System.out.print("Please enter your rating on collaboration: ");
			        String collab = scanner.nextLine();
			        System.out.print("Please enter your rating on dependibility: ");
			        String dependability = scanner.nextLine();
			        System.out.print("Please enter your rating on your personal mind: ");
			        String personalmind = scanner.nextLine();
			        System.out.print("Please enter your rating on problem solving: ");
			        String problemsolve = scanner.nextLine();
			        System.out.print("Please enter your rating on professional awareness: ");
			        String professional = scanner.nextLine();
			        System.out.print("Please enter your rating on social awareness: ");
			        String socialaware = scanner.nextLine();
			        System.out.print("Please enter your rating on technology: ");
			        String tech = scanner.nextLine();
			        System.out.print("Please enter your rating on time and attendance: ");
			        String timeandattend = scanner.nextLine();
			        			        
			        String deleteSql = "DELETE FROM EmpSkills10Fall WHERE Person = ?";
			        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			            deleteStatement.setString(1, "Student");
			            deleteStatement.executeUpdate();
			        }

			        
			        
			        String sql = "INSERT INTO EmpSkills10Fall (Person, Collaboration, Dependable, Personal_Mindset, " +
                "Problem_Solving, Professional_Attitude, Social_Awareness, Technology, Time_and_Attendance) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			        String person = "Student";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setString(1, person);
			            statement.setString(2, collab);
			            statement.setString(3, dependability);
			            statement.setString(4, personalmind);
			            statement.setString(5, problemsolve);
			            statement.setString(6, professional);
			            statement.setString(7, socialaware);
			            statement.setString(8, tech);
			            statement.setString(9, timeandattend);
			            
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