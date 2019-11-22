package study.spring_1_5th.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userid;
    private String name;
    @OneToMany(mappedBy = "user")
    private List<Todo> todos;
    public User() {

    }
}
