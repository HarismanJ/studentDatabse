import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.Scanner;

public class UI {
    public static void main(String [] args){
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "harisman";

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            userInput(connection);



        } catch (Exception e) {
            System.out.println("Cannot connect to PostgreSQL: " + e.getMessage());
        }
    }

    private static void userInput(Connection c) {
        SQLMethods.createAndInitializeTables(c);
        String userInput = "";
        int [] monthsW31Days = {1,3,5,7,8,10,12};
        int [] monthsW30Days = {4,6,9,11};
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("Main Menu:");
            System.out.println("1) Display all Student Info");
            System.out.println("2) Add a Student");
            System.out.println("3) Update Student Email");
            System.out.println("4) Delete a Student");
            System.out.println("Press 'q' to quit");

            userInput = scan.nextLine();

            switch(userInput.strip()){
                case ("1"):
                    SQLMethods.getAllStudents(c);
                    break;
                case ("2"):
                    System.out.println("Enter the new students first name: ");
                    String first_name = scan.nextLine();
                    System.out.println("Enter the new students last name: ");
                    String last_name = scan.nextLine();
                    System.out.println("Enter the students email: ");
                    String email = scan.nextLine();
                    while(!email.contains("@")) {
                        System.out.println("Invalid email. Please try again: ");
                        email = scan.nextLine();
                    }
                    System.out.println("Enter enrollment year (ex. 2025): ");
                    String year = scan.nextLine();
                    while(!year.matches("-?\\d+(\\.\\d+)?") ||
                            (year.matches("-?\\d+(\\.\\d+)?") && Integer.parseInt(year)<0)) {
                        System.out.println("Invalid year. Please try again: ");
                        year = scan.nextLine();
                    }
                    System.out.println("Enter enrollment month: (ex. 10)");
                    String month = scan.nextLine();
                    while(!month.matches("-?\\d+(\\.\\d+)?") ||
                            (month.matches("-?\\d+(\\.\\d+)?") && (Integer.parseInt(month)<=0 || Integer.parseInt(month)>12))) {
                        System.out.println("Invalid month. Please try again: ");
                        month = scan.nextLine();
                    }
                    System.out.println("Enter enrollment day (ex. 28)");
                    String day;
                    while(true){
                        day = scan.nextLine();
                        if (!day.matches("\\d+")){
                            System.out.println("Invalid day. Please enter a number: ");
                        }
                        else{
                            int y = Integer.parseInt(year);
                            int m = Integer.parseInt(month);
                            int d = Integer.parseInt(day);
                            int lastDay;

                            if(Arrays.stream(monthsW31Days).anyMatch(x->x==m)) {
                                lastDay = 31;
                                System.out.println("Last day 31");
                            }
                            else if(Arrays.stream(monthsW30Days).anyMatch(x->x==m)){
                                lastDay=30;
                                System.out.println("Last day 30");
                            }
                            else {
                                if ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) {
                                    lastDay = 29;
                                } else {
                                    lastDay = 28;
                                }
                            }
                            if (d>=1 && d<=lastDay) {
                                break;
                            }
                            else {
                                System.out.println("Invalid day for that month or year. Please try again: ");
                            }
                        }
                    }
                    SQLMethods.addStudent(c,first_name,last_name,email,year+"-"+month+"-"+day);
                    System.out.println("Here is the updated database");
                    SQLMethods.getAllStudents(c);
                    System.out.println();
                    break;
                case ("3"):
                    int result=-1;
                    do{
                        if(result == 0){
                            System.out.println("No such member exists. Try again. ");
                        }
                        System.out.println("Enter the students id number: ");
                        String id = scan.nextLine();
                        while(!id.matches("-?\\d+(\\.\\d+)?")) {
                            System.out.println("Not a valid student id. Try again: ");
                            id = scan.nextLine();
                        }
                        System.out.println("Enter the student's updated email: ");
                        String newEmail = scan.nextLine();
                        while(!newEmail.contains("@")) {
                            System.out.println("Invalid email. Please try again: ");
                            newEmail = scan.nextLine();
                        }
                            result = SQLMethods.updateStudentEmail(c,id,newEmail);
                    } while(result==0);
                    System.out.println("Here is the updated database");
                    SQLMethods.getAllStudents(c);
                    System.out.println();
                    break;
                case ("4"):
                    int result2=-1;
                    do{
                        if(result2 == 0){
                            System.out.println("No such member exists. Try again. ");
                        }
                        System.out.println("Enter the id of the student to delete: ");
                        String deleteId = scan.nextLine();
                        while(!deleteId.matches("-?\\d+(\\.\\d+)?")) {
                            System.out.println("Not a valid student id. Try again: ");
                            deleteId = scan.nextLine();
                        }
                            result2 = SQLMethods.deleteStudent(c,deleteId);
                    }while(result2==0);
                    System.out.println("Here is the updated database");
                    SQLMethods.getAllStudents(c);
                    System.out.println();
                    break;
            }

        }while(!userInput.equalsIgnoreCase("q"));


    }

}
