package net.codejava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class studentinfo {
	
	static Scanner scan = new Scanner(System.in);
	public static void studentinfo() {
       String databaseURL = "jdbc:ucanaccess://dbCareerPathways.accdb";
      
       try {Connection connection = DriverManager.getConnection(databaseURL); {
       	System.out.println("You are connected.");
       	System.out.println("Please enter your full name:");
			String fullname = scan.nextLine();
			System.out.println("Please enter your School:");
			String school = scan.nextLine();
			System.out.println("Please enter your grade level:");
			String gradelvl = scan.nextLine();
			System.out.println("Please enter your OSIS number:");
			String osis = scan.nextLine();
			System.out.println("Please enter your SSN:");
			String ssn = scan.nextLine();
			System.out.println("Are you I-9 verified? (Yes/No) ");
			String i9veri = scan.nextLine();
			System.out.println("Please enter your gender:");
			String gender = scan.nextLine();
			System.out.println("Please enter your pronouns:");
			String pronouns = scan.nextLine();
			System.out.println("Preferred name: ");
			String prefname = scan.nextLine();
			System.out.println("Please enter your race: ");
			String race = scan.nextLine();
			System.out.println("Please enter your expected graduation month: ");
			String gradmon = scan.nextLine();
			System.out.println("Please enter your expected graduation year: ");
			String gradyr = scan.nextLine();
			System.out.println("Are you an English Language Learner (ELL)? (Yes/No): ");
			String ell = scan.nextLine();
			System.out.println("Do you have any allergies? (Animals, foods, etc.) (Yes/No)");
			String allergies = scan.nextLine();
			if (allergies == "yes")
					{
						System.out.print("Please enter specific allergies you might have: ");
						String allergiespt2 = scan.nextLine();
					}
			System.out.println("Do you speak other languages? (Spanish, French etc.) (Yes/No)");
			String languages = scan.nextLine();
			if (languages == "yes")
					{
						System.out.print("Please enter specific languages you might speak: ");
						String languagespt2 = scan.nextLine();
					}
			System.out.println("------------------------------------");
			System.out.println("Contact Information: ");
			System.out.println("Enter your school based email: ");
			String schoolbased = scan.nextLine();
			System.out.println("Enter your home phone #: ");
			String homenum = scan.nextLine();
			System.out.println("Enter your permanent email : ");
			String permemail = scan.nextLine();
			System.out.println("Enter your cell phone #: ");
			String cell = scan.nextLine();
			System.out.println("Enter your address: ");
			String address = scan.nextLine();
			System.out.println("Enter your APT: ");
			String apt = scan.nextLine();
			System.out.println("Enter your City: ");
			String city = scan.nextLine();
			System.out.println("Enter your state: ");
			String state = scan.nextLine();
			System.out.println("Enter your zip code: ");
			String zipcd = scan.nextLine();
			
			System.out.println("------------------------------------");
			System.out.println("Parent/Guardian Contact Information: ");
			System.out.println("Enter their first name: ");
			String guardianname = scan.nextLine();
			System.out.println("Enter their last name: ");
			String guardianlastname = scan.nextLine();
			System.out.println("Enter their relationship with you: ");
			String relationshipstatus = scan.nextLine();
			System.out.println("Enter their email: ");
			String guardemail = scan.nextLine();
			System.out.println("Enter their home phone: ");
			String guardhome = scan.nextLine();
			System.out.println("Enter their work phone: ");
			String guardwork = scan.nextLine();
			System.out.println("Enter their cell phone: ");
			String guardcell = scan.nextLine();
			
			System.out.println("------------------------------------");
			System.out.println("Emergency Contact Information: ");
			System.out.println("Enter their first name: ");
			String emergencyname = scan.nextLine();
			System.out.println("Enter their last name: ");
			String emergencylastname = scan.nextLine();
			System.out.println("Enter their relationship with you: ");
			String relationshipstatus2 = scan.nextLine();
			System.out.println("Enter their email: ");
			String emergencyemail = scan.nextLine();
			System.out.println("Enter their home phone: ");
			String emergencyhome = scan.nextLine();
			System.out.println("Enter their cell phone: ");
			String emergencycell = scan.nextLine();
			
			
			System.out.println("------------------------------------");
			System.out.println("Other Information: ");
			System.out.println("Do you have a bank account: ");
			String bank = scan.nextLine();
			System.out.println("Would you like to be paid through direct deposit: ");
			String directdep = scan.nextLine();
			System.out.println("Have you completed the Career and Financial "
					+ "Management Course in your school?: ");
			String mngmtcourse = scan.nextLine();
			System.out.println("Do you have access to an electronic device with internet accessibility?");
			String electaccess = scan.nextLine();
			System.out.println("Do you have access to the internet?: ");
			String internetaccess = scan.nextLine();
			System.out.println("What internship environment are you looking for?: ");
			String internship = scan.nextLine();
			
			String sql = "INSERT INTO Student_Info_Tab (Full_Name, School, Grade_Level, Osis, i9Verification, Gender, Pronouns, Preffered_Name, Race, Graduation_Month,"
					+ " Graduation_Year, ELL, Allergies, Languages, schoolbased, homenum, permemail, cell, address, apt, city, state, zipcd, ssn, Guardian_Name,"
					+ " Guardian_Last_Name, Guard_Email, Guard_Home, Guard_Cell, Emergency_Name, Emergency_Last_Name, Relationship_Status2, Emergency_Email,"
					+ " Emergency_Home, Emergency_Cell, Bank, Direct_Deposit, Management_Course, Electronics_Accessibiility, Internet_Accessibiility, Internship, Relationship_Status) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, fullname);
			statement.setString(2, school);
			statement.setString(3, gradelvl);
			statement.setString(4, osis);
			statement.setString(5, gender);
			statement.setString(6, pronouns);
			statement.setString(7, prefname);
			statement.setString(8, race);
			statement.setString(9, gradmon);
			statement.setString(10, gradyr);
			statement.setString(11, ell);
			statement.setString(12, allergies);
			statement.setString(13, languages);
			statement.setString(14, schoolbased);
			statement.setString(15, homenum);
			statement.setString(16, permemail);
			statement.setString(17, cell);
			statement.setString(18, address);
			statement.setString(19, apt);
			statement.setString(20, city);
			statement.setString(21, state);
			statement.setString(22, zipcd);
			statement.setString(23, ssn);
			statement.setString(24, guardianname);
			statement.setString(25, guardianlastname);
			statement.setString(26, guardemail);
			statement.setString(27, guardhome);
			statement.setString(28, guardwork);
			statement.setString(29, guardcell);
			statement.setString(30, emergencyname);
			statement.setString(31, emergencylastname);
			statement.setString(32, relationshipstatus2);
			statement.setString(33, emergencyemail);
			statement.setString(34, emergencyhome);
			statement.setString(35, emergencycell);
			statement.setString(36, bank);
			statement.setString(37, directdep);
			statement.setString(38, mngmtcourse);
			statement.setString(39, electaccess);
			statement.setString(40, internetaccess);
			statement.setString(41, internship);
			statement.setString(42, relationshipstatus);
			
			int rows = statement.executeUpdate();
			if (rows > 0)
			{
				System.out.println("A new contact has been inserted");
				System.out.println("Heres all the information you inserted.");
				System.out.println("------------------------------------");
				System.out.println("------------------------------------");
				System.out.println("Student Information:");
				System.out.println("Full Name: " + fullname);
				System.out.println("School: " + school);
				System.out.println("Grade Level: " + gradelvl);
				System.out.println("OSIS Number: " + osis);
				System.out.println("SSN: " + ssn);
				System.out.println("I-9 Verified: " + i9veri);
				System.out.println("Gender: " + gender);
				System.out.println("Pronouns: " + pronouns);
				System.out.println("Preferred Name: " + prefname);
				System.out.println("Race: " + race);
				System.out.println("Expected Graduation Month: " + gradmon);
				System.out.println("Expected Graduation Year: " + gradyr);
				System.out.println("ELL: " + ell);
				System.out.println("Allergies: " + allergies);
				System.out.println("Languages: " + languages);
				System.out.println("------------------------------------");
				System.out.println("Contact Information:");
				System.out.println("School-based Email: " + schoolbased);
				System.out.println("Home Phone #: " + homenum);
				System.out.println("Permanent Email: " + permemail);
				System.out.println("Cell Phone #: " + cell);
				System.out.println("Address: " + address);
				System.out.println("APT: " + apt);
				System.out.println("City: " + city);
				System.out.println("State: " + state);
				System.out.println("Zip Code: " + zipcd);
				System.out.println("------------------------------------");
				System.out.println("Parent/Guardian Contact Information:");
				System.out.println("Guardian's First Name: " + guardianname);
				System.out.println("Guardian's Last Name: " + guardianlastname);
				System.out.println("Relationship Status: " + relationshipstatus);
				System.out.println("Guardian's Email: " + guardemail);
				System.out.println("Guardian's Home Phone: " + guardhome);
				System.out.println("Guardian's Work Phone: " + guardwork);
				System.out.println("Guardian's Cell Phone: " + guardcell);
				System.out.println("------------------------------------");
				System.out.println("Emergency Contact Information:");
				System.out.println("Emergency Contact's First Name: " + emergencyname);
				System.out.println("Emergency Contact's Last Name: " + emergencylastname);
				System.out.println("Relationship Status: " + relationshipstatus2);
				System.out.println("Emergency Contact's Email: " + emergencyemail);
				System.out.println("Emergency Contact's Home Phone: " + emergencyhome);
				System.out.println("Emergency Contact's Cell Phone: " + emergencycell);
				System.out.println("------------------------------------");
				System.out.println("Other Information:");
				System.out.println("Bank Account: " + bank);
				System.out.println("Direct Deposit: " + directdep);
				System.out.println("Management Course Completed: " + mngmtcourse);
				System.out.println("Electronics Accessibility: " + electaccess);
				System.out.println("Internet Accessibility: " + internetaccess);
				System.out.println("Internship Environment Preference: " + internship);
				System.out.println("------------------------------------");
			}
			
			connection.close();
       }
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}



