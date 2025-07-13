package vn.edu.eiu.cse456.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Students") //
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id //Mark as a primary key
    @Column(name = "ID", columnDefinition = "CHAR(10)")
    private String id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "YOB", nullable = false)
    private int yob;

    @Column(name = "GPA")
    private double gpa;
}
