package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Employability3 {
	
	static Scanner scanner = new Scanner(System.in);
		public static void technical() 
		{
			 try (Connection connection = DriverManager.getConnection("jdbc:ucanaccess://CTECourses.accdb")) {
			    	
			        System.out.println("Enter the technical skills grade year to view (10-12): ");
			        int literacyID = scanner.nextInt();
			        scanner.nextLine();
			        
			      switch (literacyID)
			      {
			      case 10:
						System.out.println("Would you like to access the fall or spring technical skills? (1 for fall, 0 for spring): ");
						int pick = scanner.nextInt();
						switch (pick)
						{
						case 1:
							scanner.nextLine();
							Employability3.fall_10();
							break;
						case 0:
							scanner.nextLine();
							Employability3.spring10();
							break;
						default:
							System.out.println("PLEASE ENTER A CORRECT SELECTION");
							break;
						}
						
						break;
			      case 11:
						System.out.println("Would you like to access the fall or spring technical skills? (1 for fall, 0 for spring):");
						int pick2 = scanner.nextInt();
						switch (pick2)
						{
						case 1:
							scanner.nextLine();
							Employability3.fall_11();
							
							break;
						case 0:
							scanner.nextLine();
							Employability3.spring11();
							
							break;
						default:
							System.out.println("PLEASE ENTER A CORRECT SELECTION");
							break;
						}
						break;
			      case 12:
						System.out.println("LOADING..");
						Employability3.fall_12();
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
			        System.out.println("ST 1  1. Apply the skills and abilities in requirements analysis and configuration control while working plans processes and projects as assigned.");
			        String st11 = scanner.nextLine();
			        System.out.println("ST 1  2. Use the skills required in project management to track and assess the progress of a plan process or project as assigned.");
			        String st12 = scanner.nextLine();
			        System.out.println("ST 2  3. Apply a currently applicable computer programming language to a process project plan or issue as assigned.");
			        String st23 = scanner.nextLine();
			        System.out.println("ST 2  5. Apply a technological scientific or mathematical concept (use of algorithms) when communicating with others on issues plans processes problems or concepts. ");
			        String st25 = scanner.nextLine();
			        System.out.println("ST 5  3. Develop a career plan for advancement in science technology engineering and mathematics careers");
			        String st53 = scanner.nextLine();
			        System.out.println("STET 1  2. Develop the active use of information technology applications.");
			        String stet12 = scanner.nextLine();
			        System.out.println("STET 3  1. Use knowledge techniques skills and modern tools necessary for engineering practice.");
			        String stet31 = scanner.nextLine();
			        System.out.println("STET 5  2. Demonstrate the ability to evaluate a design or product and improve the design using testing modeling and research.");
			        String stet52 = scanner.nextLine();
			        System.out.println("STSM 1  1. Apply science and mathematics concepts and principles to resolve plans projects processes issues or problems through methods of inquiry.");
			        String stst11 = scanner.nextLine();
			        System.out.println("STSM 2  6. Apply the Scientific Method to projects as assigned. ");
			        String stsm26 = scanner.nextLine();
			        System.out.println("STSM 4  1. Demonstrate and use effective critical thinking and reasoning skills by making and testing conjectures drawing logical conclusions and justifying thinking.: ");
			        String stsm41 = scanner.nextLine();
			        			        
			        String deleteSql = "DELETE FROM TechnicalSkills12Fall WHERE Person = ?";
			        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			            deleteStatement.setString(1, "Student");
			            deleteStatement.executeUpdate();
			        }

			        
			        
			        String sql = "INSERT INTO TechnicalSkills12Fall (Person, ST11, ST12,ST23,ST25,ST53,STET12,STET31," + 
			        "STET52,STSM11,STSM26,STSM41) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			        String person = "Student";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setString(1, person);
			            statement.setString(2, st11);
			            statement.setString(3, st12);
			            statement.setString(4, st23);
			            statement.setString(5, st25);
			            statement.setString(6, st53);
			            statement.setString(7, stet12);
			            statement.setString(8, stet31);
			            statement.setString(9, stet52);
			            statement.setString(10, stst11);
			            statement.setString(11, stsm26);
			            statement.setString(12, stsm41);
			            
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
			        System.out.println("ST 1  1. Apply the skills and abilities in requirements analysis and configuration control while working plans processes and projects as assigned.");
			        String st11 = scanner.nextLine();
			        System.out.println("ST 1  2. Use the skills required in project management to track and assess the progress of a plan process or project as assigned.");
			        String st12 = scanner.nextLine();
			        System.out.println("ST 2  3. Apply a currently applicable computer programming language to a process project plan or issue as assigned.");
			        String st23 = scanner.nextLine();
			        System.out.println("ST 2  5. Apply a technological scientific or mathematical concept (use of algorithms) when communicating with others on issues plans processes problems or concepts. ");
			        String st25 = scanner.nextLine();
			        System.out.println("ST 5  3. Develop a career plan for advancement in science technology engineering and mathematics careers");
			        String st53 = scanner.nextLine();
			        System.out.println("STET 1  2. Develop the active use of information technology applications.");
			        String stet12 = scanner.nextLine();
			        System.out.println("STET 3  1. Use knowledge techniques skills and modern tools necessary for engineering practice.");
			        String stet31 = scanner.nextLine();
			        System.out.println("STET 5  2. Demonstrate the ability to evaluate a design or product and improve the design using testing modeling and research.");
			        String stet52 = scanner.nextLine();
			        System.out.println("STSM 1  1. Apply science and mathematics concepts and principles to resolve plans projects processes issues or problems through methods of inquiry.");
			        String stst11 = scanner.nextLine();
			        System.out.println("STSM 2  6. Apply the Scientific Method to projects as assigned. ");
			        String stsm26 = scanner.nextLine();
			        System.out.println("STSM 4  1. Demonstrate and use effective critical thinking and reasoning skills by making and testing conjectures drawing logical conclusions and justifying thinking.: ");
			        String stsm41 = scanner.nextLine();
			        
			        			        
			        String deleteSql = "DELETE FROM TechnicalSkills11Spring WHERE Person = ?";
			        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			            deleteStatement.setString(1, "Student");
			            deleteStatement.executeUpdate();
			        }

			        
			        
			        String sql = "INSERT INTO TechnicalSkills11Spring (Person, Person, ST11, ST12,ST23,ST25,ST53,STET12,STET31," +
			        		"STET52,STSM11,STSM26,STSM41) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			        String person = "Student";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setString(1, person);
			            statement.setString(2, st11);
			            statement.setString(3, st12);
			            statement.setString(4, st23);
			            statement.setString(5, st25);
			            statement.setString(6, st53);
			            statement.setString(7, stet12);
			            statement.setString(8, stet31);
			            statement.setString(9, stet52);
			            statement.setString(10, stst11);
			            statement.setString(11, stsm26);
			            statement.setString(12, stsm41);
			            
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
			        System.out.println("Please enter your rating on Civic: ");
			        System.out.println("ST 1  1. Apply the skills and abilities in requirements analysis and configuration control while working plans processes and projects as assigned.");
			        String st11 = scanner.nextLine();
			        System.out.println("ST 1  2. Use the skills required in project management to track and assess the progress of a plan process or project as assigned.");
			        String st12 = scanner.nextLine();
			        System.out.println("ST 2  3. Apply a currently applicable computer programming language to a process project plan or issue as assigned.");
			        String st23 = scanner.nextLine();
			        System.out.println("ST 2  5. Apply a technological scientific or mathematical concept (use of algorithms) when communicating with others on issues plans processes problems or concepts. ");
			        String st25 = scanner.nextLine();
			        System.out.println("ST 5  3. Develop a career plan for advancement in science technology engineering and mathematics careers");
			        String st53 = scanner.nextLine();
			        System.out.println("STET 1  2. Develop the active use of information technology applications.");
			        String stet12 = scanner.nextLine();
			        System.out.println("STET 3  1. Use knowledge techniques skills and modern tools necessary for engineering practice.");
			        String stet31 = scanner.nextLine();
			        System.out.println("STET 5  2. Demonstrate the ability to evaluate a design or product and improve the design using testing modeling and research.");
			        String stet52 = scanner.nextLine();
			        System.out.println("STSM 1  1. Apply science and mathematics concepts and principles to resolve plans projects processes issues or problems through methods of inquiry.");
			        String stst11 = scanner.nextLine();
			        System.out.println("STSM 2  6. Apply the Scientific Method to projects as assigned. ");
			        String stsm26 = scanner.nextLine();
			        System.out.println("STSM 4  1. Demonstrate and use effective critical thinking and reasoning skills by making and testing conjectures drawing logical conclusions and justifying thinking.: ");
			        String stsm41 = scanner.nextLine();
			        			        
			        String deleteSql = "DELETE FROM TechnicalSkills11Fall WHERE Person = ?";
			        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			            deleteStatement.setString(1, "Student");
			            deleteStatement.executeUpdate();
			        }

			        
			        
			        String sql = "INSERT INTO TechnicalSkills11Fall (Person, ST11, ST12,ST23,ST25,ST53,STET12,STET31," +
			        "STET52,STSM11,STSM26,STSM41) " +
                      "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			        String person = "Student";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setString(1, person);
			            statement.setString(2, st11);
			            statement.setString(3, st12);
			            statement.setString(4, st23);
			            statement.setString(5, st25);
			            statement.setString(6, st53);
			            statement.setString(7, stet12);
			            statement.setString(8, stet31);
			            statement.setString(9, stet52);
			            statement.setString(10, stst11);
			            statement.setString(11, stsm26);
			            statement.setString(12, stsm41);
			            
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
			        System.out.println("ST 1  1. Apply the skills and abilities in requirements analysis and configuration control while working plans processes and projects as assigned.");
			        String st11 = scanner.nextLine();
			        System.out.println("ST 1  2. Use the skills required in project management to track and assess the progress of a plan process or project as assigned.");
			        String st12 = scanner.nextLine();
			        System.out.println("ST 2  3. Apply a currently applicable computer programming language to a process project plan or issue as assigned.");
			        String st23 = scanner.nextLine();
			        System.out.println("ST 2  5. Apply a technological scientific or mathematical concept (use of algorithms) when communicating with others on issues plans processes problems or concepts. ");
			        String st25 = scanner.nextLine();
			        System.out.println("ST 5  3. Develop a career plan for advancement in science technology engineering and mathematics careers");
			        String st53 = scanner.nextLine();
			        System.out.println("STET 1  2. Develop the active use of information technology applications.");
			        String stet12 = scanner.nextLine();
			        System.out.println("STET 3  1. Use knowledge techniques skills and modern tools necessary for engineering practice.");
			        String stet31 = scanner.nextLine();
			        System.out.println("STET 5  2. Demonstrate the ability to evaluate a design or product and improve the design using testing modeling and research.");
			        String stet52 = scanner.nextLine();
			        System.out.println("STSM 1  1. Apply science and mathematics concepts and principles to resolve plans projects processes issues or problems through methods of inquiry.");
			        String stst11 = scanner.nextLine();
			        System.out.println("STSM 2  6. Apply the Scientific Method to projects as assigned. ");
			        String stsm26 = scanner.nextLine();
			        System.out.println("STSM 4  1. Demonstrate and use effective critical thinking and reasoning skills by making and testing conjectures drawing logical conclusions and justifying thinking.: ");
			        String stsm41 = scanner.nextLine();
			        			        
			        String deleteSql = "DELETE FROM TechnicalSkills10Spring WHERE Person = ?";
			        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			            deleteStatement.setString(1, "Student");
			            deleteStatement.executeUpdate();
			        }

			        
			        
			        String sql = "INSERT INTO TechnicalSkills10Spring (Person, ST11, ST12,ST23,ST25,ST53,STET12,STET31," + "STET52,STSM11,STSM26,STSM41) " +
                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			        String person = "Student";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setString(1, person);
			            statement.setString(2, st11);
			            statement.setString(3, st12);
			            statement.setString(4, st23);
			            statement.setString(5, st25);
			            statement.setString(6, st53);
			            statement.setString(7, stet12);
			            statement.setString(8, stet31);
			            statement.setString(9, stet52);
			            statement.setString(10, stst11);
			            statement.setString(11, stsm26);
			            statement.setString(12, stsm41);
			            
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
			        System.out.println("ST 1  1. Apply the skills and abilities in requirements analysis and configuration control while working plans processes and projects as assigned.");
			        String st11 = scanner.nextLine();
			        System.out.println("ST 1  2. Use the skills required in project management to track and assess the progress of a plan process or project as assigned.");
			        String st12 = scanner.nextLine();
			        System.out.println("ST 2  3. Apply a currently applicable computer programming language to a process project plan or issue as assigned.");
			        String st23 = scanner.nextLine();
			        System.out.println("ST 2  5. Apply a technological scientific or mathematical concept (use of algorithms) when communicating with others on issues plans processes problems or concepts. ");
			        String st25 = scanner.nextLine();
			        System.out.println("ST 5  3. Develop a career plan for advancement in science technology engineering and mathematics careers");
			        String st53 = scanner.nextLine();
			        System.out.println("STET 1  2. Develop the active use of information technology applications.");
			        String stet12 = scanner.nextLine();
			        System.out.println("STET 3  1. Use knowledge techniques skills and modern tools necessary for engineering practice.");
			        String stet31 = scanner.nextLine();
			        System.out.println("STET 5  2. Demonstrate the ability to evaluate a design or product and improve the design using testing modeling and research.");
			        String stet52 = scanner.nextLine();
			        System.out.println("STSM 1  1. Apply science and mathematics concepts and principles to resolve plans projects processes issues or problems through methods of inquiry.");
			        String stst11 = scanner.nextLine();
			        System.out.println("STSM 2  6. Apply the Scientific Method to projects as assigned. ");
			        String stsm26 = scanner.nextLine();
			        System.out.println("STSM 4  1. Demonstrate and use effective critical thinking and reasoning skills by making and testing conjectures drawing logical conclusions and justifying thinking.: ");
			        String stsm41 = scanner.nextLine();

			        			        
			        String deleteSql = "DELETE FROM TechnicalSkills10Fall WHERE Person = ?";
			        try (PreparedStatement deleteStatement = connection.prepareStatement(deleteSql)) {
			            deleteStatement.setString(1, "Student");
			            deleteStatement.executeUpdate();
			        }

			        
			        
			        String sql = "INSERT INTO TechnicalSkills10Fall (Person, ST11, ST12,ST23,ST25,ST53,STET12,STET31,"
			        		+ "STET52,STSM11,STSM26,STSM41) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			        String person = "Student";
			        try (PreparedStatement statement = connection.prepareStatement(sql)) {
			        	statement.setString(1, person);
			            statement.setString(2, st11);
			            statement.setString(3, st12);
			            statement.setString(4, st23);
			            statement.setString(5, st25);
			            statement.setString(6, st53);
			            statement.setString(7, stet12);
			            statement.setString(8, stet31);
			            statement.setString(9, stet52);
			            statement.setString(10, stst11);
			            statement.setString(11, stsm26);
			            statement.setString(12, stsm41);
			            
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

