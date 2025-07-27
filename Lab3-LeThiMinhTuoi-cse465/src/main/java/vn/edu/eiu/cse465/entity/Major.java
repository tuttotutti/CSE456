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
@Table(name = "tbl_Major")
public class Major {
    @Id
    @Column(name = "MajorId", nullable = false, columnDefinition = "CHAR(4)")
    private String majorId;

    @Column(name = "MajorName", nullable = false, columnDefinition = "NVARCHAR(100)")
    private String majorName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SchoolId")
    private School school;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "major")
    private List<Student> students = new ArrayList<Student>();

    public void addStudent(Student student) {
        students.add(student);
        student.setMajor(this);
    }

    public Major(String majorId, String majorName) {
        this.majorId = majorId;
        this.majorName = majorName;
    }
}
