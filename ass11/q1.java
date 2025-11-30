//  Q1. Display the contents of the student table from the database.

import java.sql.*;

class Main {
    public static void main(String[] args) {
        String driverName = "org.postgresql.Driver";
        String url = "jdbc:postgresql://192.168.1.17:5432/sample_db";
        String username = "cse";
        String password = "cse123";

        // Try to load the JDBC driver so we can show a helpful message when it's missing
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: PostgreSQL JDBC driver not found on classpath.");
            System.err.println("Download the driver (https://jdbc.postgresql.org/download.html) and run with it on the classpath.");
            System.err.println("Example (Windows PowerShell):");
            System.err.println("  javac q1.java");
            System.err.println("  java -cp .;postgresql-<version>.jar Main");
            return;
        }

        String query = "SELECT * FROM students";

        // Use try-with-resources so Connection, Statement and ResultSet are closed automatically
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            System.out.println("Connected: " + (connection != null));

            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                long mobile = resultSet.getLong("mobile");
                String email = resultSet.getString("email");
                double cgpa = resultSet.getDouble("cgpa");

                System.out.println(firstName + "\t" + lastName + "\t" + mobile + "\t" + email + "\t" + cgpa);
            }

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}