package Model;

public class Module {
    private String name;
    private String code;
    private int semester;

    public Module(String name, String code, int semester) {
        this.name = name;
        this.code = code;
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getSemester() {
        return semester;
    }

    public String intoString() {
        return "\nName: " + name + "\nCode: " + code + "\nSemester: " + semester + "\n";
    }

    public void print() {
        System.out.println("Name: " + name);
        System.out.println("Code: " + code);
        System.out.println("semester: " + semester);
    }
}
