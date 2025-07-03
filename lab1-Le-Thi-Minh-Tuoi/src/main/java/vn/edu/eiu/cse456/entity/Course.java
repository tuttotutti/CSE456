package vn.edu.eiu.cse456.entity;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Course {
    private String id;
    private String name;
    private int credits;
    private double hours;


}
