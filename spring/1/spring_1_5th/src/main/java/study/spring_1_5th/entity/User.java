package study.spring_1_5th.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(name = "User.findUsersWithNameUsingNamedQuery", query = "select u from User u where u.name = ?1")
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
