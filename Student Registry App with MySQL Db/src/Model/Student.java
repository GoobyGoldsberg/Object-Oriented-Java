package Model;

public class Student  {
    private String studentId;
    private String name;
    private String dob;
    private int semester;


    public Student(String studentId, String name, String dob, int semester) {
        this.studentId = studentId;
        this.name = name;
        this.dob = dob;
        this.semester = semester;
    }

    public String getId() {
        return studentId;
    }

    public String intoString() {
        return "\nStudentID: " + studentId + "\nName: " + name + "\ndob: " + dob + "\nsemester: " + semester + "\n===================\n";
    }

    void print() {
        System.out.println("StudentID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("dob: " + dob);
        System.out.println("semester: " + semester);
    }

}
