package vn.edu.ptithcm.studentmangementstudio.domain.entity;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

public class StudentDetail extends Student {

    private final SimpleObjectProperty<String> password;

    public StudentDetail(String id, String lastname, String firstname, String address, LocalDate birth, String classId, int gender, boolean isOff, String password) {
        super(id, lastname, firstname, address, birth, classId, gender, isOff);
        this.password = new SimpleObjectProperty<>(password);
    }

    public SimpleObjectProperty<String> passwordProperty() {
        return password;
    }

}
