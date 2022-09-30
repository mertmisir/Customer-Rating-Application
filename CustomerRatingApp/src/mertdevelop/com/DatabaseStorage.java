package mertdevelop.com;

import java.sql.*;

public class DatabaseStorage {
        Connection connection = null;
        DatabaseStorage() { //constructor to check if db is successfully accessed!
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customers", "root", "");


            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                resetDatabase();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        //method to insert customer data into Customer Table:
        public void insertCustomerToDatabase(Customer customer) throws SQLException {
            String insertion = "INSERT INTO `Customer` (`id`, `user_name`, `origin`, `residence`, `date_of_birth`, `sex`, `rating`, `rating_offset`, `creation_date`) VALUES ("+"'"+customer.getID()+"'"+", "+"'"+customer.getUserName()+"'"+", "+"'"+customer.getOrigin()+"'"+", "+"'"+customer.getResidence()+"'"+", "+"'"+customer.getDateOfBirth()+"'"+", "+"'"+customer.getSex()+"'"+", "+"'"+customer.getRating()+"'"+", "+"'"+customer.getOffsetR()+"'"+", "+"'"+customer.getCreationDate()+"'"+")";
            PreparedStatement newOne = connection.prepareStatement(insertion);
            newOne.execute();
       }
       //method to prevent duplication issue oriented problems by deleting all the rows each time the program will be executed:
       public void resetDatabase() throws SQLException {
            String deletion = "DELETE FROM `Customer`";
            PreparedStatement newOne = connection.prepareStatement(deletion);
            newOne.execute();
       }
}
