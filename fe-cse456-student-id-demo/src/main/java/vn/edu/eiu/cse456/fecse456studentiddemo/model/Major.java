package vn.edu.eiu.cse456.fecse456studentiddemo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_Major")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(100)", nullable = false)
    private String name;

    @Column(name = "Description", columnDefinition = "TEXT", nullable = false)
    private String description;

    //Connect with the student table (bi-directional)
    //mappedBy = "the name of props of Major in Student"
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "major")
    private List<Student> students = new ArrayList<>();

    //2 methods adding and deleting students

    //Adding method
    public void addStudent(Student student) {
        //Add student to major
        students.add(student);
        //Add major to the student
        student.setMajor(this);
    }

    //Deleting method
    public void removeStudent(Student student) {
        students.remove(student);
        student.setMajor(null);
    }

    //If ID is auto-incremental, then build a constructor wihtout id
    public Major(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
