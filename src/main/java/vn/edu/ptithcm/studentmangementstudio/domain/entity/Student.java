package vn.edu.ptithcm.studentmangementstudio.domain.entity;

import javafx.beans.property.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.core.utils.AppFormatter;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class Student {
    final private SimpleStringProperty id, lastname, firstname, address, classId;
    final private SimpleObjectProperty<LocalDate> birth;
    final private SimpleIntegerProperty gender;
    final private SimpleBooleanProperty isOff;

    public Student(String id, String lastname, String firstname, String address, LocalDate birth, String classId, int gender, boolean isOff) {
        this.id = new SimpleStringProperty(id);
        this.lastname = new SimpleStringProperty(lastname);
        this.firstname = new SimpleStringProperty(firstname);
        this.address = new SimpleStringProperty(address);
        this.birth = new SimpleObjectProperty<>(birth);
        this.classId = new SimpleStringProperty(classId);
        this.gender = new SimpleIntegerProperty(gender);
        this.isOff = new SimpleBooleanProperty(isOff);
    }

    public String getBirthString() {
        return AppFormatter.formatDate(birth.getValue());
    }

    public String getGenderString() {
        if (gender.getValue() == 0) {
            return K.Strings.FEMALE;
        } else if (gender.getValue() == 1) {
            return K.Strings.MALE;
        } else {
            return K.Strings.BLANK;
        }
    }


    public String getIsOffString() {
        return isOff.getValue() ? K.Strings.INACTIVE : K.Strings.ACTIVE;
    }


    public StringProperty getId() {
        return id;
    }

    public StringProperty getLastname() {
        return lastname;
    }

    public StringProperty getFirstname() {
        return firstname;
    }

    public StringProperty getAddress() {
        return address;
    }

    public ObjectProperty<LocalDate> getBirth() {
        return birth;
    }

    public StringProperty getClassId() {
        return classId;
    }


}



