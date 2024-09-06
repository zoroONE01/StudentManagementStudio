package vn.edu.ptithcm.studentmangementstudio.domain.entity;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Classroom {
    final private SimpleStringProperty id, className, classYear, departmentId;

    public Classroom(String id, String className, String classYear, String departmentId) {
        this.id = new SimpleStringProperty(id);
        this.className = new SimpleStringProperty(className);
        this.classYear = new SimpleStringProperty(classYear);
        this.departmentId = new SimpleStringProperty(departmentId);
    }

    public StringProperty getId() {
        return id;
    }

    public StringProperty getClassName() {
        return className;
    }

    public StringProperty getClassYear() {
        return classYear;
    }

    public StringProperty getDepartmentId() {
        return departmentId;
    }

}
