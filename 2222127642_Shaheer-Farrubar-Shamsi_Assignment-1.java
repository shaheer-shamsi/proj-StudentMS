// Shaheer Farrubar Shamsi
// 2222127642

// Assignment-1

package assignment1;
import java.util.Scanner;


// Student Class with its datafields and methods
class Student {
    int id;
    String name;
    String password;
    String[] coursesEnrolled; // Updated to string array
    int numCoursesEnrolled; // Track number of courses enrolled

    public Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.coursesEnrolled = new String[10]; // Initialize string array with size 10
        this.numCoursesEnrolled = 0; // Initialize number of courses enrolled to 0
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    // Method to add a course to enrolled courses
    public void addCourse(String courseName) {
        if (numCoursesEnrolled < coursesEnrolled.length) { // Check if array has space
            coursesEnrolled[numCoursesEnrolled++] = courseName; // Add course and increment count
            System.out.println("Course '" + courseName + "' added successfully.");
        } else {
            System.out.println("Unable to add course. Maximum courses enrolled.");
        }
    }
    
    // Method to remove a course from enrolled courses
    public void removeCourse(String courseName) {
        boolean found = false;
        for (int i = 0; i < numCoursesEnrolled; i++) {
            if (coursesEnrolled[i].equals(courseName)) {
                for (int j = i; j < numCoursesEnrolled - 1; j++) {
                    coursesEnrolled[j] = coursesEnrolled[j + 1]; // Shift array elements
                }
                numCoursesEnrolled--; // Decrement count
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Course '" + courseName + "' removed successfully.");
        } else {
            System.out.println("Course not found in enrolled courses.");
        }
    }
    
    // Method to view courses enrolled by the student
    public void viewCoursesEnrolled() {
        System.out.println("Courses Enrolled:");
        if (numCoursesEnrolled == 0) {
            System.out.println("No courses enrolled.");
        } else {
            for (int i = 0; i < numCoursesEnrolled; i++) {
                System.out.println(coursesEnrolled[i]);
            }
        }
    }
    
    public boolean isEnrolledInCourse(String courseName) {
        for (int i = 0; i < numCoursesEnrolled; i++) {
            if (coursesEnrolled[i].equals(courseName)) {
                return true; // Course found
            }
        }
        return false; // Course not found
    }
}


//Teacher Class with its datafields and methods
class Teacher {
	// Private visibility modifier could have been used
    int id;
    String name;
    String password;
    String[] coursesTeaching; // Updated to string array
    int numCoursesTeaching; // Track number of courses teaching

    public Teacher(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.coursesTeaching = new String[10]; // Initialize string array with size 10
        this.numCoursesTeaching = 0; // Initialize number of courses teaching to 0
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    // Method to add a course to coursesTeaching
    public void addCourse(String courseName) {
        if (numCoursesTeaching < coursesTeaching.length) { // Check if array has space
            coursesTeaching[numCoursesTeaching++] = courseName; // Add course and increment count
            System.out.println("You have been enrolled in " + courseName + "successfully.");
        } else {
            System.out.println("Unable to add course. Maximum courses taken.");
        }
    }

    // Method to remove a course from coursesTeaching
    public void removeCourse(String courseName) {
        boolean found = false;
        for (int i = 0; i < numCoursesTeaching; i++) {
            if (coursesTeaching[i].equals(courseName)) {
                for (int j = i; j < numCoursesTeaching - 1; j++) {
                    coursesTeaching[j] = coursesTeaching[j + 1]; // Shift array elements
                }
                numCoursesTeaching--; // Decrement count
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("You have dropped " + courseName + "successfully.");
        } else {
            System.out.println("Course not found in courses teaching.");
        }
    }

    // Method to view courses teaching by the teacher
    public void viewCoursesTeaching() {
        System.out.println("Courses Teaching:");
        if (numCoursesTeaching == 0) {
            System.out.println("No courses teaching.");
        } else {
            for (int i = 0; i < numCoursesTeaching; i++) {
                System.out.println(coursesTeaching[i]);
            }
        }
    }
    
    

    // Method to list students enrolled in a particular course
    public void listCourseStudents(String courseName, Student[] students) {
        boolean found = false;
        System.out.println("Students enrolled in course '" + courseName + "':");
        for (Student student : students) {
            if (student != null && student.isEnrolledInCourse(courseName)) {
                System.out.println("ID: " + student.getId() + ", Name: " + student.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students enrolled in the course.");
        }
    }
}


	// StudentManagementSystem Class with its methods
	public class StudentManagementSystem {
		static final int MAX_STUDENTS = 99; // Maximum number of students
	    static Student[] students = new Student[MAX_STUDENTS]; // Array to store students
	    static int numStudents = 0; // Counter for number of students
	    static Teacher[] teachers = new Teacher[MAX_STUDENTS]; // Array to store teachers
	    static int numTeachers = 0; // Counter for number of teachers

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int choice;

	        while (true) {
	            System.out.println("Student Management System");
	            System.out.println("1. Student");
	            System.out.println("2. Teacher");
	            System.out.println("3. Exit");
	            System.out.print(">");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline character

	            switch (choice) {
	                case 1:
	                    if (loginAsStudent(scanner)) {
	                    	System.out.println("Student Index:");
	                    	int index= scanner.nextInt();
	                        showStudentMenu(students[index]);
	                    } else {
	                        System.out.println("Invalid login credentials.");
	                    }
	                    break;
	                case 2:
	                    if (loginAsTeacher(scanner)) {
	                        //showTeacherMenu(scanner);
	                    } else {
	                        System.out.println("Invalid login credentials.");
	                    }
	                    break;
	                case 3:
	                    System.out.println("Exiting...");
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        }
	    }

	    // Method to perform student login
	    static boolean loginAsStudent(Scanner scanner) {
	        System.out.print("Provide Teacher ID: >");
	        int id = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character
	        System.out.print("Password: >");
	        String password = scanner.nextLine();

	        // Validate login credentials
	        for (int i = 0; i < numStudents; i++) {
	            if (students[i].getId() == id && students[i].getPassword().equals(password)) {
	            	System.out.print("Welcome Student!");
	                return true;
	            }
	        }
	        return false;
	    }

	    // Method to perform teacher login
	    static boolean loginAsTeacher(Scanner scanner) {
	        System.out.print("Provide Teacher ID: >");
	        int id = scanner.nextInt();
	        scanner.nextLine(); // Consume newline character
	        System.out.print("Password: >");
	        String password = scanner.nextLine();

	        // Validate login credentials
	        for (int i = 0; i < numTeachers; i++) {
	            if (teachers[i].getId() == id && teachers[i].getPassword().equals(password)) {
	            	System.out.print("Welcome Teacher!");
	                return true;
	            }
	        }
	        return false;
	    }
	    
	 // Method to view courses enrolled by a student
	    static void viewCoursesEnrolled(int studentIndex) {
	        System.out.println("Courses Enrolled:");
	        students[studentIndex].viewCoursesEnrolled();
	    }

	    // Method to remove a course from a student's enrolled courses
	    static void removeCourse(int studentIndex) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Remove Course");
	        System.out.print("Enter the course name: ");
	        String courseName = scanner.nextLine();
	        if (students[studentIndex].viewCoursesEnrolled().contains(courseName)) {
	            //students[studentIndex].viewCoursesEnrolled().remove(courseName);
	            System.out.println("Course '" + courseName + "' removed successfully.");
	        } else {
	            System.out.println("No courses to show.");
	        }
	    }
	    
	    // Method to show student menu
	    public static void showStudentMenu(Student student) {
	        Scanner scanner = new Scanner(System.in);
	        int choice;
	        do {
	            //System.out.println("\n----- Student Menu -----");
	            System.out.println("1. Add Course");
	            System.out.println("2. View Courses");
	            System.out.println("3. Back");
	            System.out.print(">");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline character

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter the course name to add: ");
	                    String courseToAdd = scanner.nextLine();
	                    student.addCourse(courseToAdd);
	                    System.out.println("Course added successfully!");
	                    break;
	                case 2:
	                    student.viewCoursesEnrolled();
	                    break;
	                case 3:
	                    System.out.println("Returning to main menu...");
	                    break;
	                default:
	                    System.out.println("Invalid choice! Please try again.");
	                    break;
	            }
	        } while (choice != 3);
	    }
	    
	    public static void showTeacherMenu(Teacher teacher) {
	        Scanner scanner = new Scanner(System.in);
	        int choice;
	        do {
	            //System.out.println("\n----- Teacher Menu -----");
	            System.out.println("1. View Course");
	            System.out.println("2. Logout");
	            System.out.print(">");
	            choice = scanner.nextInt();
	            scanner.nextLine(); // Consume newline character

	            switch (choice) {
	                case 1:
	                    System.out.print("Enter the course name: ");
	                    String courseName = scanner.nextLine();
	                    teacher.listCourseStudents(courseName,students);
	                    break;
	                case 2:
	                    System.out.println("Logging out...");
	                    break;
	                default:
	                    System.out.println("Invalid choice! Please try again.");
	                    break;
	            }
	        } while (choice != 2);
	    }
}