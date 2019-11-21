package study.spring_1_5th.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid")
    private User user;
    private String title;
    private String description;
    private Date targetDate;
    private boolean isDone;
    public Todo() {

    }
}
