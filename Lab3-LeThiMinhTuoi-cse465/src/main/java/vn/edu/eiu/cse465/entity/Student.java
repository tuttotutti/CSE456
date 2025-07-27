package vn.edu.eiu.cse465.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tbl_Student")
public class Student {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "studentId", nullable = false)
    private long studentId;

    @Column(name = "studentName", nullable = false, columnDefinition = "NVARCHAR(100)")
    private String studentName;

    public Student(String studentName) {
        this.studentName = studentName;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "MajorId")
    private Major major;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "SchoolId")
    private School school;
}
