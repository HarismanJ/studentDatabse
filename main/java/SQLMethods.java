import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLMethods {
    public static void getAllStudents(Connection c) {
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                int student_id = rs.getInt("student_id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String email = rs.getString("email");
                String enrollment_date = rs.getDate("enrollment_date").toString();
                System.out.println("ID: " + student_id + ", First Name: " + first_name
                        + ", Last Name: " + last_name + ", Email: " + email + ", Enrollment Date: " + enrollment_date);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
    }


    public static void addStudent(Connection c, String first_name, String last_name, String email, String enrollment_date) {
        try {
            Statement st = c.createStatement();
            st.executeUpdate("INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES ('" +
                    first_name + "', '" + last_name + "', '" + email + "', '" + enrollment_date + "');");
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public static int updateStudentEmail(Connection c, String student_id, String newEmail) {
        try{
            Statement st = c.createStatement();
            return st.executeUpdate("UPDATE students SET email = '" + newEmail + "' WHERE student_id=" + student_id + ";");
        }catch (Exception e){
            System.out.println("Error updating student email: " + e.getMessage());
        }
        return -1;
    }

    public static int deleteStudent(Connection c, String student_id) {
        try {
            Statement st = c.createStatement();
            return st.executeUpdate("DELETE FROM students WHERE student_id=" + student_id + ";");
        } catch (Exception e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
        return -1;
    }



    public static void createAndInitializeTables(Connection c){
        try {
            Statement st = c.createStatement();
            st.executeUpdate("DROP TABLE IF EXISTS students");

            Statement st1 = c.createStatement();
            st1.executeUpdate("CREATE TABLE IF NOT EXISTS students("+
                    "student_id SERIAL PRIMARY KEY,"+
                    "first_name TEXT NOT NULL,"+
                    "last_name TEXT NOT NULL,"+
                    "email TEXT NOT NULL UNIQUE," +
                    "enrollment_date DATE)");

            Statement st2 = c.createStatement();
            st2.executeUpdate("INSERT INTO students(first_name, last_name, email, enrollment_date) VALUES "+
                    "('John', 'Doe', 'john.doe@example.com', '2023-09-01'),"+
                    "('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),"+
                    "('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');");

        }catch (Exception e){
            System.out.println("Error creating or initializing the students table: " + e.getMessage());
        }
    }
}
