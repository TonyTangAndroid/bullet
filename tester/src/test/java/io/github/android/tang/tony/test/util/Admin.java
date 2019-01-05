package io.github.android.tang.tony.test.util;

public class Admin {

    private final Student student;

    public Admin(Student student) {
        this.student = student;
    }

    public void registerStudent() {
        student.register();
    }
}