package vn.edu.ptithcm.studentmangementstudio.presentation.admin;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.core.router.AppDialog;
import vn.edu.ptithcm.studentmangementstudio.core.router.AppRouter;
import vn.edu.ptithcm.studentmangementstudio.core.utils.AppLogger;
import vn.edu.ptithcm.studentmangementstudio.core.utils.FxUtils;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Size;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Student;
import vn.edu.ptithcm.studentmangementstudio.presentation.BasePresenter;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DashboardPresenter extends BasePresenter implements Initializable {

    public VBox vBoxMainBody;
    public MenuBar menuBar;
    public MenuItem menuItemLogout, menuItemUndo, menuItemRedo, menuItemAboutUs;
    public Tab tabClass, tabStudent, tabClassSubject, tabCreditClass, tabScore;
    public TableView<Student> tableViewStudent;
    public ProgressBar progressBar;
    public TableColumn<Student, String> tableColumnStudentId, tableColumnLastName, tableColumnFirstName, tableColumnBirth, tableColumnGender, tableColumnAddress, tableColumnClassId, tableColumnIsOff;
    public Label labelId, labelFullName, labelBirth, labelGender, labelAddress, labelClassId, labelIsOff, labelBranchTag;
    public TextField textFieldSearchStudent;
    public Button buttonRefreshStudent, buttonCreateStudent, buttonEditStudent, buttonDeleteStudent, buttonSearchStudent;
    public ToolBar toolbar;
    public ComboBox<String> comboBoxId, comboBoxLastName, comboBoxFirstName, comboBoxBirth, comboBoxGender, comboBoxAddress, comboBoxClassId, comboBoxIsOff;
    public HBox hBoxModifyStudent;


    private final SimpleObjectProperty<Student> studentSelected = new SimpleObjectProperty<>(null);

    private final ArrayList<Student> students = new ArrayList<>() {
        {
            add(new Student("1", "Nguyễn", "Văn A", "Hà Nội", LocalDate.now(), 1, "1", false));
            add(new Student("2", "Trần", "Thị B", "Hà Nội", LocalDate.now(), 0, "1", true));
            add(new Student("3", "Lê", "Văn C", "Hà Nội", LocalDate.now(), 1, "1", false));
            add(new Student("4", "Phạm", "Thị D", "Hà Nội", LocalDate.now(), 0, "1", true));
            add(new Student("5", "Nguyễn", "Văn E", "Hà Nội", LocalDate.now(), 1, "1", false));
            add(new Student("6", "Trần", "Thị F", "Hà Nội", LocalDate.now(), 0, "1", true));
            add(new Student("7", "Lê", "Văn G", "Hà Nội", LocalDate.now(), 1, "1", false));
            add(new Student("8", "Phạm", "Thị H", "Hà Nội", LocalDate.now(), 0, "1", true));
            add(new Student("9", "Nguyễn", "Văn I", "Hà Nội", LocalDate.now(), 1, "1", false));
            add(new Student("10", "Trần", "Thị K", "Hà Nội", LocalDate.now(), 0, "1", true));
            add(new Student("11", "Lê", "Văn L", "Hà Nội", LocalDate.now(), 1, "1", false));
            add(new Student("12", "Phạm", "Thị M", "Hà Nội", LocalDate.now(), 0, "1", true));
            add(new Student("13", "Nguyễn", "Văn N", "Hà Nội", LocalDate.now(), 1, "1", false));
            add(new Student("14", "Trần", "Thị O", "Hà Nội", LocalDate.now(), 0, "1", true));
        }
    };

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeStudentTable();
        initComboBoxFromData();
        hBoxModifyStudent.setDisable(studentSelected.getValue() == null);
        studentSelected.addListener((obs, oldSelection, newSelection) -> {
            updateStudentDetail(newSelection);
        });

    }

    private void initializeStudentTable() {
        tableColumnStudentId.setCellValueFactory(new PropertyValueFactory<>(K.DbFields.ID));
        tableColumnLastName.setCellValueFactory(new PropertyValueFactory<>(K.DbFields.LASTNAME));
        tableColumnFirstName.setCellValueFactory(new PropertyValueFactory<>(K.DbFields.FIRSTNAME));
        tableColumnBirth.setCellValueFactory(data -> {
            var value = data.getValue().getBirthString();
            return new SimpleStringProperty(value);
        });
        tableColumnGender.setCellValueFactory(data -> {
            var value = data.getValue().getGenderString();
            return new SimpleStringProperty(value);
        });
        tableColumnAddress.setCellValueFactory(new PropertyValueFactory<>(K.DbFields.ADDRESS));
        tableColumnClassId.setCellValueFactory(new PropertyValueFactory<>(K.DbFields.CLASS_ID));
        tableColumnIsOff.setCellValueFactory(data -> {
            var value = data.getValue().getIsOffString();
            return new SimpleStringProperty(value);
        });
        tableViewStudent.getItems().addAll(students);
        tableViewStudent.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            studentSelected.setValue(newSelection);
            hBoxModifyStudent.setDisable(newSelection == null);
        });
    }


    private void updateStudentDetail(Student model) {
        labelId.setText(model.getId());
        labelFullName.setText(model.getLastname() + " " + model.getFirstname());
        labelBirth.setText(model.getBirthString());
        labelGender.setText(model.getGenderString());
        labelAddress.setText(model.getAddress());
        labelClassId.setText(model.getClassId());
        labelIsOff.setText(model.getIsOffString());
    }

    // function for init all comboBox as filter for student table
    private void initComboBoxFromData() {
    }

    public void buttonRefreshStudentOnPressed(ActionEvent actionEvent) {
    }

    public void buttonSearchStudentOnPressed(ActionEvent actionEvent) {

    }

    public void buttonCreateStudentOnPressed(ActionEvent actionEvent) {
        try {
            var form = new StudentFormPresenter();
            var result = form.show();
            if (result != null) {
                AppLogger.log(result.toString());
            } else {
                AppLogger.log("Cancelled");
            }
        } catch (Exception e) {
            AppLogger.log(e.getMessage());
        }
    }

    public void buttonEditEditOnPressed(ActionEvent actionEvent) {
        try {
            var form = new StudentFormPresenter();
            var result = form.show(fxmlLoader -> {
                var controller = (StudentFormPresenter) fxmlLoader.getController();
                controller.updateUI(tableViewStudent.getSelectionModel().getSelectedItem());
                return controller;
            });
            if (result != null) {
                AppLogger.log(result.toString());
            } else {
                AppLogger.log("Cancelled");
            }
        } catch (Exception e) {
            AppLogger.log(e.getMessage());
        }
    }

    public void buttonDeleteDeleteOnPressed(ActionEvent actionEvent) {
        var isConfirmed = AppDialog.showConfirmDialog(K.Strings.CONFIRM_DELETE);
        if (isConfirmed) {
            var selectedItem = tableViewStudent.getSelectionModel().getSelectedItem();
            tableViewStudent.getItems().remove(selectedItem);
        }
    }

    public void menuItemLogoutOnSelected(ActionEvent actionEvent) {
        var isConfirmed = AppDialog.showConfirmDialog(K.Strings.CONFIRM_LOGOUT);
        if (isConfirmed) {
            AppRouter.goTo(FxUtils.getStageFromNode(menuBar), K.Routes.LOGIN, new Size(400, 360));
        }
    }
}
