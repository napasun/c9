package study.spring_1_5th.bean;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(String msg) {
        super(msg);
    }
}