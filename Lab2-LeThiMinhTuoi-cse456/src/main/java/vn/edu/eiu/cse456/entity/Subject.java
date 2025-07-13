package vn.edu.eiu.cse456.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Subject")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @Column(name = "Code", columnDefinition = "CHAR(10)")
    private String code;

    @Column(name = "Name", columnDefinition = "NVARCHAR(50)", nullable = false)
    private String name;

    @Column(name = "Description",columnDefinition = "NVARCHAR(250)", nullable = false)
    private String description;

    @Column(name = "Credits")
    private int credits;

    @Column(name = "StudyHours")
    private int studyHours;
}
