Harisman Jeyakanthan
101325107

**Objective:** 

Implement a PostgreSQL database using the provided schema and write an application in your language of choice that connects to this database to perform specific CRUD (Create, Read, Update, Delete) operations.
Implement a PostgreSQL database using the provided schema and write an application in Java that connects to this database to perform specific CRUD (Create, Read, Update, Delete) operations.

**Database Schema:**

| Field | Type | Constraints |
|--------|--------|-------------|
| student_id | SERIAL | PRIMARY KEY |
| first_name | TEXT | NOT NULL |
| last_name | TEXT | NOT NULL |
| email | TEXT | NOT NULL, UNIQUE |
| enrollment_date | DATE | — |

**Initial Data:**

INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');

**Project Overview:**

SQLMethods.java - Handles all interactions with the database (CRUD)
UI.java - Handles all the user input through the console

**Implemented Functions:**

| Function | Description |
|----------|-------------|
| `getAllStudents()` | Displays all student records |
| `addStudent(first_name, last_name, email, enrollment_date)` | Inserts a new student |
| `updateStudentEmail(student_id, new_email)` | Updates the email of a student |
| `deleteStudent(student_id)` | Deletes a student by ID |
| `createAndInitializeTables()` | Recreates the table and inserts initial data |

**Running the Program:**

1) Ensure PostgreSQL is running.

2) Within UI.java change the following lines of code if needed to connect to your PostgreSQL server:

  String url = "jdbc:postgresql://localhost:5432/postgres"; 
  String user = "postgres";
  String password = "your_password";

3) Run the program. The program will create the needed tables.

**Using the Program:**

The program will display a main menu in the console:

Main Menu:
1) Display all Student Info
2) Add a Student
3) Update Student Email
4) Delete a Student
Press 'q' to quit

Enter the associated number of the process you want to run, and follow the instructions printed on the console.

Note: After each operation (Add, Update, Delete), the updated table is printed to the console.

*Demo Video:*




