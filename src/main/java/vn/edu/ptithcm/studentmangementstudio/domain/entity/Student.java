package vn.edu.ptithcm.studentmangementstudio.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.core.utils.AppFormatter;

import java.time.LocalDate;
import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Student {
    private String id;
    private String lastname;
    private String firstname;
    private String address;
    private LocalDate birth;
    private Integer gender;
    private String classId;
    private Boolean isOff;

    public String getBirthString() {
        return AppFormatter.formatDate(birth);
    }

    public String getGenderString() {
        if (gender == 0) {
            return K.Strings.FEMALE;
        } else if (gender == 1) {
            return K.Strings.MALE;
        } else {
            return K.Strings.BLANK;
        }
    }

    public String getIsOffString() {
        return isOff ? K.Strings.INACTIVE : K.Strings.ACTIVE;
    }
}
