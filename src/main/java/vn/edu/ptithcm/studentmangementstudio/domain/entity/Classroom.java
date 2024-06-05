package vn.edu.ptithcm.studentmangementstudio.domain.entity;


public class Classroom {
    public String name;
    public int capacity;
    public String description;

    public Classroom(String name, int capacity, String description) {
        this.name = name;
        this.capacity = capacity;
        this.description = description;
    }

}
