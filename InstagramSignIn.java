package com.ig;
import java.sql.*;
import java.sql.Connection;
public class InstagramSignIn {
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/Adithya";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        // Replace "testUser" and "testPassword" with actual user input
        String user_id = "testuser";
        String password = "testpassword";

        try {
            // Connect to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Prepare a statement to retrieve user data based on the username
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM instapage WHERE user_id = ?");
            statement.setString(1, user_id);
          

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Check if any row is returned
            if (resultSet.next()) {
                // Retrieve the password from the database
                String dbpassword = resultSet.getString("user_id");

                // Verify the password
                if (password.equals(dbpassword)) {
                    System.out.println("Sign-in successful");
                    // Additional code for successful sign-in (e.g., redirect to homepage)
                } else {
                    System.out.println("Invalid password");
                    // Additional code for handling invalid password (e.g., show error message)
                }
            } else {
                System.out.println("User not found");
                // Additional code for handling user not found (e.g., show error message)
            }

            // Close connections
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
