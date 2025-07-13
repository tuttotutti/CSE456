package vn.edu.eiu.cse456.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Lecturer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lecturer {

    @Id
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Yob")
    private int yob;

    @Column(name = "Salary")
    private double salary;
}
