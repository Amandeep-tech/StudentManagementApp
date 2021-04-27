import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management Application");
		System.out.println("------------------------------------------");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to add a student");
			System.out.println("Press 2 to delete a student");
			System.out.println("Press 3 to display a student");
			System.out.println("Press 4 to update a student");
			System.out.println("Press 5 to exit");
			
			int choice = Integer.parseInt(br.readLine());
			
			if(choice == 1) {
				// add student;
				
				// studentId will be auto_generated :)
				System.out.println("Enter user name : ");
				String name = br.readLine();
				
				System.out.println("Enter your phone number");
				String phoneNumber = br.readLine();
				
				System.out.println("Enter your city : ");
				String city = br.readLine();
				
				// create Student object now 
				Student st = new Student(name, phoneNumber, city);
				System.out.println(st);
				System.out.println("----------------------------");
				
				Boolean studentInserted = StudentDao.insertStudentToDB(st);
				if(studentInserted) {
					System.out.println("Student added successfully");
				}
				else {
					System.out.println("Something went wrong :(");
				}
			}
			else if(choice == 2) {
				// delete student
				
				System.out.println("Enter the student id whose record you want to delete");
				int studentId = Integer.parseInt(br.readLine());
				
				Boolean studentDeleted = StudentDao.deleteStudentFromDB(studentId);
				if(studentDeleted) {
					System.out.println("Student deleted successfully");
				}
				else {
					System.out.println("Could\'nt delete the student, something went wrong :(");
				}
			}
			else if(choice == 3) {
				// display student
				StudentDao.displayAllStudents();
			}
			else if(choice == 4) {
				// update
				System.out.println("Enter the student id whose data you want to update");
				int id = Integer.parseInt(br.readLine());
				
				Boolean dataUpdated = StudentDao.updateStudent(id);
				if(dataUpdated) {
					System.out.println("Record updated successfully");
				}
				else {
					System.out.println("Something went wrong :(");
				}
				
			}
			else {
				break;
			}
		}
		System.out.println("Thanks for using my application");
		System.out.println("See you again");

	}

}
