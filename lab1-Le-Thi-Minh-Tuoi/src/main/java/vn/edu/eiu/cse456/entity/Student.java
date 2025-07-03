package vn.edu.eiu.cse456.entity;

public class Student {
    //Khai bao cac thuoc tinh
    private String id;
    private String firstName;
    private String lastName;
    private double gpa;
    private int yearOfBirth;


    //Phuong thuc khoi tao
    //BoilerPlate: Repeated Code
    public Student(){

    }
    public Student(String id, String firstName, String lastName, double gpa, int yearOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gpa = gpa;
        this.yearOfBirth = yearOfBirth;
    }

    //Getter setter

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }


    //toString

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gpa=" + gpa +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
