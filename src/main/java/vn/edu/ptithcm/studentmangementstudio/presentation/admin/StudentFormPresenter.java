package vn.edu.ptithcm.studentmangementstudio.presentation.admin;

import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lombok.Setter;
import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.core.utils.AppLogger;
import vn.edu.ptithcm.studentmangementstudio.data.repository.Repositories;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Classroom;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Student;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.StudentDetail;
import vn.edu.ptithcm.studentmangementstudio.domain.usecase.auth.GetStudentDetailUseCase;
import vn.edu.ptithcm.studentmangementstudio.presentation.BaseFormPresenter;

import java.net.URL;
import java.util.ResourceBundle;


public class StudentFormPresenter extends BaseFormPresenter<Student> implements Initializable {

    @Setter
    private String id;

    public TextField textFieldId, textFieldLastname, textFieldFirstname, textFieldAddress;
    public DatePicker datePickerBirth;
    public RadioButton radioButtonMale, radioButtonFemale;
    public ComboBox<Classroom> comboBoxClassId;
    public CheckBox checkBoxOff;
    public Button buttonPassword;
    public PasswordField textFieldPassword;

    private final ToggleGroup toggleGroupGender = new ToggleGroup();

    private final SimpleObjectProperty<StudentDetail> student = new SimpleObjectProperty<>();


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
        super.initialize(url, resourceBundle);
        runAsTask(() -> {
            setProgress(.2);
            var result = new GetStudentDetailUseCase(Repositories.student, id).call();
            if (result.isError()) {
                return result.error();
            }
            student.set(result.data());
            initComponent();
            return null;
        });

    }

    private void initComponent() {
        radioButtonMale.setToggleGroup(toggleGroupGender);
        radioButtonFemale.setToggleGroup(toggleGroupGender);
        textFieldId.textProperty().bind(student.get().getId());
        textFieldLastname.textProperty().bind(student.get().getLastname());
        textFieldFirstname.textProperty().bind(student.get().getFirstname());
        textFieldAddress.textProperty().bind(student.get().getAddress());
        datePickerBirth.valueProperty().bind(student.get().getBirth());
        textFieldPassword.textProperty().bind(student.get().passwordProperty());
    }
}

