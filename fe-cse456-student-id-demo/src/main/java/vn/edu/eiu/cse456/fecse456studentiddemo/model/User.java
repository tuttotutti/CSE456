package vn.edu.eiu.cse456.fecse456studentiddemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_user")
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //usually auto-incremental id use wrapper class( Long )

    @Column(unique = true, nullable = false, columnDefinition = "VARCHAR(50)")
    private String username;

    @Column(nullable = false, columnDefinition = "VARCHAR(30)")
    private String password;

    @Column(nullable = false)
    private int role;

    //create the constructor with all but id by ourselves
    public User(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
