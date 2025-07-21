package studentapp;

public class Main {
    public static void main(String[] args) {

        // Step 1: Create the students table
        StudentOperations.createTable();

        // Step 2: Insert sample students
        StudentOperations.insertStudent(1, "Kavya", "Java");
        StudentOperations.insertStudent(2, "Ravi", "Python");
        StudentOperations.insertStudent(3, "Anjali", "C++");

        // Step 3: Display all students
        StudentOperations.displayStudents();
    }
}
