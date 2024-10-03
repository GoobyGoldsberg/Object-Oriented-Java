package View;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;



public class View extends JFrame {
    
    //Frame Dimensions/Panel Dimensions
    private int frameWidth = 450;
    private int frameHeight = 600;
    private int numOfPanels = 8;
    private int panelHeight = frameHeight/numOfPanels;
    private Dimension labelDimension = new Dimension(frameWidth, panelHeight-30);
    private Font font = new Font("Arial", Font.PLAIN, 18);


    //Object declarations
    private JButton addBtn, removeBtn, listBtn, addModuleButton, removeModuleButton, listModulesButton, refreshButton, selectButton, memoryLeakButton;
    private JTextField studentIdField, studentNameField, studentSemesterField, studentModuleField, studentDobField, moduleCodeField, moduleSemesterField, moduleNameField;
    private JTextArea outputField, thirdOutputField, secondOutputField;
    private JTabbedPane tabbedPane;
    private JComboBox<String> comboBox;
    
    public View() {
        
        
        tabbedPane = new JTabbedPane();
        JPanel firstTabPanel = new JPanel();

        JPanel secondTabPanel = new JPanel();

        JPanel thirdTabPanel = new JPanel();






        // ---------------------------------Student ID--------------------------------------------
        
        JPanel studentIdPanel = new JPanel();
        // studentIdPanel.setBorder(BorderFactory.createDashedBorder(getForeground()));
        // studentIdPanel.setBounds(0, 0, frameWidth, panelHeight);

        JLabel studentIdLabel = new JLabel();
        studentIdLabel.setPreferredSize(labelDimension);
        studentIdLabel.setFont(font);
        studentIdLabel.setVerticalAlignment(JLabel.CENTER);
        studentIdLabel.setHorizontalAlignment(JLabel.LEFT);
        studentIdLabel.setText("Enter StudentID:");

        studentIdField = new JTextField();
        studentIdField.setFont(font);
        studentIdField.setBounds(150, 10, 169, 26);

        studentIdLabel.add(studentIdField);
        studentIdPanel.add(studentIdLabel);






        // --------------------------------------Student Name-----------------------------------------------

        JPanel studentNamePanel = new JPanel();
        // studentNamePanel.setBorder(BorderFactory.createDashedBorder(getForeground()));
        // studentNamePanel.setBounds(0, 50, frameWidth, panelHeight);
        
        JLabel studentNameLabel = new JLabel();
        studentNameLabel.setPreferredSize(labelDimension);
        studentNameLabel.setFont(font);
        studentNameLabel.setVerticalAlignment(JLabel.CENTER);
        studentNameLabel.setHorizontalAlignment(JLabel.LEFT);
        studentNameLabel.setText("Enter Name:");
        
        studentNameField = new JTextField();
        studentNameField.setFont(font);
        studentNameField.setBounds(150, 10, 169, 26);

        studentNameLabel.add(studentNameField);
        studentNamePanel.add(studentNameLabel);







        // ---------------------------------Student Dob-------------------------------------

        JPanel studentDobPanel = new JPanel();
        // studentDobPanel.setBorder(BorderFactory.createDashedBorder(getForeground()));
        // studentDobPanel.setBounds(0, 100, frameWidth, panelHeight);

        JLabel studentDobLabel = new JLabel();
        studentDobLabel.setPreferredSize(labelDimension);
        studentDobLabel.setFont(font);
        studentDobLabel.setVerticalAlignment(JLabel.CENTER);
        studentDobLabel.setHorizontalAlignment(JLabel.LEFT);
        studentDobLabel.setText("Enter DoB:");

        studentDobField = new JTextField();
        studentDobField.setFont(font);
        studentDobField.setBounds(150, 10, 169, 26);

        studentDobLabel.add(studentDobField);
        studentDobPanel.add(studentDobLabel);








        // ----------------------Student Semester---------------------------------------

        JPanel studentSemesterPanel = new JPanel();
        // studentSemesterPanel.setBorder(BorderFactory.createDashedBorder(getForeground()));
        // studentSemesterPanel.setBounds(0, 150, frameWidth, panelHeight);

        JLabel studentSemesterLabel = new JLabel();
        studentSemesterLabel.setPreferredSize(labelDimension);
        studentSemesterLabel.setFont(font); 
        studentSemesterLabel.setVerticalAlignment(JLabel.CENTER);
        studentSemesterLabel.setHorizontalAlignment(JLabel.LEFT);
        studentSemesterLabel.setText("Enter Semester:");
        
        studentSemesterField = new JTextField();
        studentSemesterField.setFont(font);
        studentSemesterField.setBounds(150, 10, 169, 26);

        studentSemesterLabel.add(studentSemesterField);
        studentSemesterPanel.add(studentSemesterLabel);







        //-------------------------------------Add, Remove, List Buttons-------------------------------------

        JPanel arlButtonsPanel = new JPanel();
        // arlButtonsPanel.setBorder(BorderFactory.createDashedBorder(getForeground()));
        // arlButtonsPanel.setBounds(0, 200, frameWidth, panelHeight);

        JLabel arlButtonsLabel = new JLabel();
        arlButtonsLabel.setPreferredSize(labelDimension);


        addBtn = new JButton("Add");
        addBtn.setBounds(120, 10, 90, 30);
        addBtn.setFocusable(false);

        removeBtn = new JButton("Del");
        removeBtn.setBounds(258, 10, 60, 30);
        removeBtn.setFocusable(false);

        listBtn = new JButton("List");
        listBtn.setBounds(10, 10, 100, 30);
        listBtn.setFocusable(false);

        memoryLeakButton = new JButton("Leak");
        memoryLeakButton.setBounds(350, 10, 70, 30);

        arlButtonsPanel.add(arlButtonsLabel);
        arlButtonsLabel.add(addBtn);
        arlButtonsLabel.add(removeBtn);
        arlButtonsLabel.add(listBtn);
        arlButtonsLabel.add(memoryLeakButton);








        //----------------------------------------OutPutBox----------------------------------------------------

        JPanel outputPanel = new JPanel();
        // outputPanel.setBorder(BorderFactory.createDashedBorder(getForeground()));
        // outputPanel.setBounds(0, 270, frameWidth, panelHeight*3+20);
        outputPanel.setLayout(new FlowLayout());



        JLabel outputLabel = new JLabel();
        outputLabel.setPreferredSize(new Dimension(frameWidth, panelHeight*3-20));

        outputField = new JTextArea();
        outputField.setBounds(9, 7, frameWidth-40, panelHeight*3);
        outputField.setEditable(false);
        outputField.setFont(new Font("Arial", Font.PLAIN, 12));

       
        outputLabel.add(outputField);
        outputPanel.add(outputLabel);

        
        firstTabPanel.setSize(frameWidth, frameHeight);
        
        firstTabPanel.add(studentIdLabel);
        firstTabPanel.add(studentNameLabel);
        firstTabPanel.add(studentDobLabel);
        firstTabPanel.add(studentSemesterLabel);
        firstTabPanel.add(arlButtonsLabel);
        firstTabPanel.add(outputLabel);
        firstTabPanel.setVisible(true);

        tabbedPane.setSize(frameWidth, frameHeight);
        tabbedPane.add("Students", firstTabPanel);
        tabbedPane.setVisible(true);

        this.add(tabbedPane);
        this.setTitle("Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(frameWidth, frameHeight);
        this.setVisible(true);




        //===================================Second Tab=========================================================





        //==================================Module Code=================================================        

        JPanel moduleCodePanel = new JPanel();
        

        JLabel moduleCodeLabel = new JLabel();
        moduleCodeLabel.setPreferredSize(labelDimension);
        moduleCodeLabel.setFont(font);
        moduleCodeLabel.setVerticalAlignment(JLabel.CENTER);
        moduleCodeLabel.setHorizontalAlignment(JLabel.LEFT);
        moduleCodeLabel.setText("Enter Module Code:");

        moduleCodeField = new JTextField();
        moduleCodeField.setFont(font);
        moduleCodeField.setBounds(180, 10, 169, 26);

        moduleCodeLabel.add(moduleCodeField);
        moduleCodePanel.add(moduleCodeLabel);

        secondTabPanel.add(moduleCodePanel);







        // --------------------------------------Module Name-----------------------------------------------

        JPanel moduleNamePanel = new JPanel();
        
        
        JLabel moduleNameLabel = new JLabel();
        moduleNameLabel.setPreferredSize(labelDimension);
        moduleNameLabel.setFont(font);
        moduleNameLabel.setVerticalAlignment(JLabel.CENTER);
        moduleNameLabel.setHorizontalAlignment(JLabel.LEFT);
        moduleNameLabel.setText("Enter Module Name:");
        
        moduleNameField = new JTextField();
        moduleNameField.setFont(font);
        moduleNameField.setBounds(180, 10, 169, 26);

        moduleNameLabel.add(moduleNameField);
        moduleNamePanel.add(moduleNameLabel);

        secondTabPanel.add(moduleNamePanel);







        // ---------------------------------Module Semester-------------------------------------

        JPanel moduleSemesterPanel = new JPanel();
       

        JLabel moduleSemesterLabel = new JLabel();
        moduleSemesterLabel.setPreferredSize(labelDimension);
        moduleSemesterLabel.setFont(font);
        moduleSemesterLabel.setVerticalAlignment(JLabel.CENTER);
        moduleSemesterLabel.setHorizontalAlignment(JLabel.LEFT);
        moduleSemesterLabel.setText("Enter Semester:");

        moduleSemesterField = new JTextField();
        moduleSemesterField.setFont(font);
        moduleSemesterField.setBounds(180, 10, 169, 26);

        moduleSemesterLabel.add(moduleSemesterField);
        moduleSemesterPanel.add(moduleSemesterLabel);

        secondTabPanel.add(moduleSemesterPanel);







        //======================================Output Box===============================

        JPanel secondOutputPanel = new JPanel();
        
        secondOutputPanel.setLayout(new FlowLayout());



        JLabel secondOutputLabel = new JLabel();
        secondOutputLabel.setPreferredSize(new Dimension(frameWidth, panelHeight*3-20));

        secondOutputField = new JTextArea();
        secondOutputField.setBounds(9, 7, frameWidth-40, panelHeight*3);
        secondOutputField.setEditable(false);
        secondOutputField.setFont(new Font("Arial", Font.PLAIN, 12));

        secondOutputLabel.add(secondOutputField);
        secondOutputPanel.add(secondOutputLabel);

        secondTabPanel.add(secondOutputPanel);






        //================================Module Buttons=======================================

        addModuleButton = new JButton("Add");
        addModuleButton.setBounds(120, 10, 90, 30);
        addModuleButton.setFocusable(false);

        removeModuleButton = new JButton("Del");
        removeModuleButton.setBounds(258, 10, 60, 30);
        removeModuleButton.setFocusable(false);

        listModulesButton = new JButton("List");
        listModulesButton.setBounds(10, 10, 100, 30);
        listModulesButton.setFocusable(false);

        secondTabPanel.add(addModuleButton);
        secondTabPanel.add(removeModuleButton);
        secondTabPanel.add(listModulesButton);
    




        //================================Third Tab=====================================


        comboBox = new JComboBox<>();

        JLabel selectAStudent = new JLabel();
        
        selectAStudent.setPreferredSize(labelDimension);
        selectAStudent.setFont(font);
        selectAStudent.setVerticalAlignment(JLabel.CENTER);
        selectAStudent.setHorizontalAlignment(JLabel.CENTER);
        selectAStudent.setText("Select a student");

        refreshButton = new JButton("Refresh");
        selectButton = new JButton("Select");

        thirdTabPanel.add(selectAStudent);
        thirdTabPanel.add(comboBox);
        thirdTabPanel.add(selectButton);
        thirdTabPanel.add(refreshButton);

        JLabel studentRecord = new JLabel();
        studentRecord.setPreferredSize(new Dimension(frameWidth, panelHeight*3-20));

        thirdOutputField = new JTextArea();
        thirdOutputField.setBounds(9, 7, frameWidth-40, panelHeight*3);
        thirdOutputField.setEditable(false);
        thirdOutputField.setFont(new Font("Arial", Font.PLAIN, 12));

        studentRecord.add(thirdOutputField);

        thirdTabPanel.add(studentRecord);

        tabbedPane.add("Modules", secondTabPanel);
        tabbedPane.add("Grades", thirdTabPanel);

        

    }


    //=============================First Panel Methods============================


    public String getStudentId() {
        return studentIdField.getText();
    }

    public String getStudentName() {
        return studentNameField.getText();
    }

    public String getStudentDob() {
        return studentDobField.getText();
    }

    public int getStudentSemester() {
        try {
            return Integer.parseInt(studentSemesterField.getText());
                } catch (NumberFormatException i) {
                     return 0;
            }
    }





    //===========================Second Panel Methods===============================

    public String getModuleCode() {
        return moduleCodeField.getText();
    }

    public String getModuleName() {
        return moduleNameField.getText();
    }

    public int getModuleSemester() {
        try {
            return Integer.parseInt(moduleSemesterField.getText());
                } catch (NumberFormatException i) {
                     return 0;
            }
    }

    public void setOutputField(String input) {
        outputField.setText(input);
    }

    public void appendOutputField(String input) {
        outputField.append(input);
    }

    public void setModuleOutputField(String input) {
        secondOutputField.setText(input);
    }

    public void appendModuleOutputField(String input) {
        secondOutputField.append(input);
    }

    public String getModule() {
        return studentModuleField.getText();
    }



   


    // =========================Third Panel Methods================================

    public void addToBox(String input) {
        comboBox.addItem(input);
    }

    public void clearBox() {
        comboBox.removeAllItems();
    }

    public void setGradesOutputField(String input) {
        thirdOutputField.setText(input);
    }

    public void appendGradesOutputField(String input) {
        thirdOutputField.append(input);
    }

    public String getSelectedId() {
        String item = (String) comboBox.getSelectedItem();
        return item;
    }

    
    
    
    
    
    // ==============================Button Listeners==============================
    
    
    
    public void addButtonListener(ActionListener listenForAddButton) {
        addBtn.addActionListener(listenForAddButton);
    }

    public void removeButtonListener(ActionListener listenForRemoveButton) {
        removeBtn.addActionListener(listenForRemoveButton);
    }

    public void listButtonListener(ActionListener listenForListButton) {
        listBtn.addActionListener(listenForListButton);
    }

    public void addModuleListener(ActionListener listenForAddModuleButton) {
        addModuleButton.addActionListener(listenForAddModuleButton);
    }

    public void removeModuleListener(ActionListener listenForRemoveModuleButton) {
        removeModuleButton.addActionListener(listenForRemoveModuleButton);
    }
    
    public void listModuleListener(ActionListener listenForListModuleButton) {
        listModulesButton.addActionListener(listenForListModuleButton);
    }


    public void refreshBoxListener(ActionListener listenForRefreshButton) {
        refreshButton.addActionListener(listenForRefreshButton);
    }

    public void selectButtonListener(ActionListener listenForSelectButton) {
        selectButton.addActionListener(listenForSelectButton);
    }
    
    public void leakButtonListener(ActionListener listenForLeakButton) {
        memoryLeakButton.addActionListener(listenForLeakButton);
    }
}
    
    

    