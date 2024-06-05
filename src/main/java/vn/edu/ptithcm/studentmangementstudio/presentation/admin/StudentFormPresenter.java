package vn.edu.ptithcm.studentmangementstudio.presentation.admin;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Student;
import vn.edu.ptithcm.studentmangementstudio.presentation.BaseFormPresenter;

import java.net.URL;
import java.util.ResourceBundle;


public class StudentFormPresenter extends BaseFormPresenter<Student> implements Initializable {

    public TextField textFieldId, textFieldLastname, textFieldFirstname, textFieldAddress;
    public DatePicker datePickerBirth;
    public RadioButton radioButtonMale, radioButtonFemale;
    public ComboBox<?> comboBoxClassId;
    public CheckBox checkBoxOff;

    public void updateUI(Student data) {
        super.updateUI(data);
        textFieldId.setDisable(true);
        textFieldId.setText(data.getId());
        textFieldLastname.setText(data.getLastname());
        textFieldFirstname.setText(data.getFirstname());
        textFieldAddress.setText(data.getAddress());
        radioButtonMale.setSelected(data.getGender() == 1);
        radioButtonFemale.setSelected(data.getGender() == 0);
        datePickerBirth.setValue(data.getBirth());
        checkBoxOff.setSelected(data.getIsOff());
    }

    @Override
    protected String getPath() {
        return K.Routes.STUDENT_FORM;
    }

    @Override
    protected Student onSave() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}