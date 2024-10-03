package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.*;
import View.View;

public class Controller {
    private View theView;

    public Controller(View theView, Student theModel) {
        
        this.theView = theView;

        this.theView.addButtonListener(new AddListener());
        this.theView.removeButtonListener(new RemoveListener());
        this.theView.listButtonListener(new ListListener());
        this.theView.addModuleListener(new AddModuleListener());
        this.theView.removeModuleListener(new RemoveModuleListener());
        this.theView.listModuleListener(new ListModuleListener());
        this.theView.refreshBoxListener(new RefreshListener());
        this.theView.selectButtonListener(new SelectListener());
        this.theView.leakButtonListener(new LeakListener());

    }




    //==========================Connecting to DB=================================
    public class Connect {
        private Connection connection;
    
    
        public Connect(String url) throws SQLException {
            this.connection = DriverManager.getConnection(url);
        }
        
        public Connection getConnection() {
            return connection;
        }
    }





    //==================== Listeners for all the buttons in the app==================================



    //Add Student Listener
    class AddListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String studentId = theView.getStudentId();
            String studentName = theView.getStudentName();
            String studentAge = theView.getStudentDob();
            int studentSemester = theView.getStudentSemester();

            Connect connection = null;
            try {connection = new Connect("jdbc:sqlite:data.db");} catch (SQLException q) {System.out.println(q.getMessage());}
            

            if (studentId.length() == 0 || studentName.length() == 0 || studentSemester == 0 || studentAge.length() == 0){
                theView.setOutputField("Please fill out all the textfields!");
                return;
            }

            try {
                String addSql = "INSERT INTO students (student_id, name, dob, semester) VALUES (?, ?, ?, ?)";
                PreparedStatement addStatement = connection.getConnection().prepareStatement(addSql);
                addStatement.setString(1, studentId);
                addStatement.setString(2, studentName);
                addStatement.setString(3, studentAge);
                addStatement.setInt(4, studentSemester);
                addStatement.executeUpdate();
                addStatement.close();
                theView.setOutputField("Student was added successfully!");

            } catch (SQLException i) {
                theView.setOutputField(i.getMessage());
            };
        }
        
    }





    //Remove student listener
    class RemoveListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            String studentId = theView.getStudentId();
            Connect connection = null;
            try {connection = new Connect("jdbc:sqlite:data.db");} catch (SQLException q) {System.out.println(q.getMessage());}
            
            try {
                String removeSql = "DELETE FROM students WHERE student_id = ?";
                PreparedStatement removeStatement = connection.getConnection().prepareStatement(removeSql);
                removeStatement.setString(1, studentId);
                removeStatement.executeUpdate();
                removeStatement.close();
                theView.setOutputField("Student was removed successfully!");

            } catch (SQLException q) {
                theView.setOutputField(q.getMessage());
            }
        }

    }









    //List all students and print them to the outputfield listener
    class ListListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Connect connection = null;
            try {connection = new Connect("jdbc:sqlite:data.db");} catch (SQLException q) {System.out.println(q.getMessage());}
            
            try {
                String listSql = "SELECT * FROM students";
                Statement listStatement = connection.getConnection().createStatement();
                ResultSet resultSet = listStatement.executeQuery(listSql);
                theView.setOutputField("");
                while (resultSet.next()) {
                    // Extract the data for each row
                    String studentId = resultSet.getString("student_id");
                    String name = resultSet.getString("name");
                    String dob = resultSet.getString("dob");
                    int semester = resultSet.getInt("semester");

                    
                    theView.appendOutputField("\n\nStudent ID: " + studentId);
                    theView.appendOutputField("\nName: " + name);
                    theView.appendOutputField("\nDate of Birth: " + dob);
                    theView.appendOutputField("\nSemester: " + semester);
                }
            } catch (SQLException w) {
                        theView.setOutputField(w.getMessage());
                }

        }
    }



    //=====================================Second Tab (Modules)===============================




    //Add module to DB
    class AddModuleListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String moduleName = theView.getModuleName();
            String moduleCode = theView.getModuleCode();
            int moduleSemester = theView.getModuleSemester();

            Connect connection = null;
            try {connection = new Connect("jdbc:sqlite:data.db");} catch (SQLException q) {System.out.println(q.getMessage());}
            

            if (moduleName.length() == 0 || moduleCode.length() == 0 || moduleSemester == 0){
                theView.setOutputField("Please fill out all the textfields!");
                return;
            }

            try {
                String addSql = "INSERT INTO modules (code, name, semester) VALUES (?, ?, ?)";
                PreparedStatement addStatement = connection.getConnection().prepareStatement(addSql);
                addStatement.setString(1, moduleCode);
                addStatement.setString(2, moduleName);
                addStatement.setInt(3, moduleSemester);
                addStatement.executeUpdate();
                addStatement.close();
                theView.setModuleOutputField("Module was added successfully!");

            } catch (SQLException i) {
                theView.setModuleOutputField(i.getMessage());
            };
        }

        
    }







    //Remove module from DB
    class RemoveModuleListener implements ActionListener {
        
        public void actionPerformed(ActionEvent e) {
            String moduleCode = theView.getModuleCode();
            Connect connection = null;
            try {connection = new Connect("jdbc:sqlite:data.db");} catch (SQLException q) {System.out.println(q.getMessage());}
            
            try {
                String removeSql = "DELETE FROM modules WHERE code = ?";
                PreparedStatement removeStatement = connection.getConnection().prepareStatement(removeSql);
                removeStatement.setString(1, moduleCode);
                removeStatement.executeUpdate();
                removeStatement.close();
                theView.setModuleOutputField("Module was removed successfully!");

            } catch (SQLException q) {
                theView.setModuleOutputField(q.getMessage());
            }
        }
    }








    //List all modules from DB
    class ListModuleListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Connect connection = null;
            try {connection = new Connect("jdbc:sqlite:data.db");} catch (SQLException q) {System.out.println(q.getMessage());}
            
            try {
                String listSql = "SELECT * FROM modules";
                Statement listStatement = connection.getConnection().createStatement();
                ResultSet resultSet = listStatement.executeQuery(listSql);
                theView.setModuleOutputField("");
                while (resultSet.next()) {
                    // Extract the data for each row
                    String moduleCode = resultSet.getString("code");
                    String name = resultSet.getString("name");
                    int semester = resultSet.getInt("semester");

                    
                    theView.appendModuleOutputField("\n\nModule Code: " + moduleCode);
                    theView.appendModuleOutputField("\nName: " + name);
                    theView.appendModuleOutputField("\nSemester: " + semester);
                }
            } catch (SQLException w) {
                        theView.setModuleOutputField(w.getMessage());
                    }
                }
    }




    //===============================Third Tab (Select students)============================


    //Refresh/Show the Ids of all students in the DB
    class RefreshListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
        theView.clearBox();

        String query = "SELECT student_id FROM students";
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:data.db");
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                String id = resultSet.getString("student_id");
                theView.addToBox(id);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        }
        
    }







    //Select the student from the combobox and print their details into the outputfield
    class SelectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String studentId = theView.getSelectedId();
            
            if (studentId != null) {

                try { 
                    Connect connection = null;
                    try {connection = new Connect("jdbc:sqlite:data.db");} catch (SQLException q) {System.out.println(q.getMessage());}
                    
                    String query = "SELECT * FROM students WHERE student_id = ?";
                    PreparedStatement selectStatement = connection.getConnection().prepareStatement(query);
                    selectStatement.setString(1, studentId);

                    ResultSet resultSet = selectStatement.executeQuery();
                        theView.setGradesOutputField("");
                        while (resultSet.next()) {

                            String id = resultSet.getString("student_id");
                            String name = resultSet.getString("name");
                            String dob = resultSet.getString("dob");
                            int semester = resultSet.getInt("semester");

                            theView.appendGradesOutputField("\n\nStudent ID: " + id);
                            theView.appendGradesOutputField("\nName: " + name);
                            theView.appendGradesOutputField("\nDate of Birth: " + dob);
                            theView.appendGradesOutputField("\nSemester: " + semester);
                        }
                    } catch (SQLException q) {
                        theView.setGradesOutputField(q.getMessage());
                    }
            } else {
                theView.setGradesOutputField("Selected ID is Null");
            }
        }
    }








    // MEMORY LEAK BUTTON
    class LeakListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            List<Student> students = new ArrayList<>();
            try {
                while (true) {
                students.add(new Student("This", "is", "MemoryLeak", 1));
                }
            } catch (OutOfMemoryError error) {
                theView.setOutputField("Out Of Memory!");
            }
        }
        
    }
    
}