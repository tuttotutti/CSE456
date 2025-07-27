package vn.edu.eiu.cse465.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_school")
public class School {
    @Id
    @Column(name = "SchoolId", nullable = false, columnDefinition = "CHAR(3)")
    private String schoolId;

    @Column(name = "SchoolName", nullable = false, columnDefinition = "VARCHAR(100)")
    private String schoolName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "school")
    private List<Major> majors = new ArrayList<Major>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "school")
    private List<Student> students = new ArrayList<Student>();

    public void addStudent(Student student) {
        students.add(student);
        student.setSchool(this);
    }

    public void addMajor(Major major) {
        majors.add(major);
        major.setSchool(this);
    }

    public School(String schoolId, String schoolName) {
        this.schoolId = schoolId;
        this.schoolName = schoolName;
    }
}
