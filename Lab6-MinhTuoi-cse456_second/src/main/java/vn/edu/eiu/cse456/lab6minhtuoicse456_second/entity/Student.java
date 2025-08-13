package vn.edu.eiu.cse456.lab6minhtuoicse456_second.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Havent done @Table, @Entity yet
@AllArgsConstructor
@NoArgsConstructor
@Data
/**
 * If table has the automatically incremental key, then we need to add another constructor without key
 */
public class Student {
    // If id is automatically incremental, then the constructor wont have it.
    private int id;
    private String name;
    private int yob;
    private double gpa;


}
