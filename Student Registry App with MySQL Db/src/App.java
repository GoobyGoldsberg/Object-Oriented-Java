
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
import Controller.Controller;
import Model.*;
import View.View;



public class App {
    public static void main(String[] args) throws Exception {

        View theView = new View();
        Student theModel = new Student("blank", "blank", "blank", 0);
        Controller theController = new Controller(theView, theModel);
            
        theView.setVisible(true);
        connect();  
    }   


    // This code will inform us if the app connected to the database right after it is turned on
    public static void connect() {
        Connection connection = null;
        try {

            String url = "jdbc:sqlite:data.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to DB");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection!=null)  
                    connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
    