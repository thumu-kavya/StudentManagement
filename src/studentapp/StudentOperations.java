package studentapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentOperations {

    static final String URL = "jdbc:mysql://localhost:3306/studentdb";
    static final String USER = "root";
    static final String PASSWORD = "kavya123";

    public static void createTable() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS students ("
                    + "id INT PRIMARY KEY,"
                    + "name VARCHAR(100),"
                    + "course VARCHAR(100))";
            stmt.executeUpdate(sql);
            System.out.println("✅ Table created successfully.");
            conn.close();
        } catch (Exception e) {
            System.out.println("❌ Error in creating table");
            e.printStackTrace();
        }
    }

    public static void insertStudent(int id, String name, String course) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO students VALUES(" + id + ", '" + name + "', '" + course + "')";
            stmt.executeUpdate(sql);
            System.out.println("✅ Student inserted successfully.");
            conn.close();
        } catch (Exception e) {
            System.out.println("❌ Error in inserting student");
            e.printStackTrace();
        }
    }

    public static void displayStudents() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            System.out.println("\n📋 Students List:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Name: " + rs.getString("name")
                        + ", Course: " + rs.getString("course"));
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("❌ Error in displaying students");
            e.printStackTrace();
        }
    }
}
