package vn.edu.ptithcm.studentmangementstudio.presentation.admin;

import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.core.router.AppDialog;
import vn.edu.ptithcm.studentmangementstudio.core.router.AppRouter;
import vn.edu.ptithcm.studentmangementstudio.core.utils.AppLogger;
import vn.edu.ptithcm.studentmangementstudio.core.utils.FxUtils;
import vn.edu.ptithcm.studentmangementstudio.data.repository.Repositories;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.LoginInfo;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Size;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Student;
import vn.edu.ptithcm.studentmangementstudio.domain.usecase.auth.DisconnectDbUseCase;
import vn.edu.ptithcm.studentmangementstudio.domain.usecase.auth.GetStudentListUseCase;
import vn.edu.ptithcm.studentmangementstudio.presentation.BasePresenter;

import java.net.URL;
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
    public Button buttonRefreshStudent, buttonCreateStudent, buttonEditStudent, buttonDeleteStudent, buttonSearchStudent, buttonStudentUndo, buttonStudentRedo, buttonStudentSave;
    public ToolBar toolbar;
    public ComboBox<String> comboBoxId, comboBoxLastName, comboBoxFirstName, comboBoxBirth, comboBoxGender, comboBoxAddress, comboBoxClassId, comboBoxIsOff;
    public HBox hBoxModifyStudent;
    public Menu menuBranch;

    private LoginInfo info;

    public void setMenuBranch(String branch) {
        menuBranch.setText(branch);
    }

    public void setInfo(LoginInfo info) {
        this.info = info;
        labelBranchTag.setText(info.group().getName() + "  >  " + info.id() + "  >  " + info.fullName());
    }

    private final SimpleObjectProperty<Student> studentSelected = new SimpleObjectProperty<>();

    private final ObservableList<Student> students = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        runAsTask(() -> {
            // Initialize student table
            initializeStudentTable();

            // Initialize student detail
            initComboBoxFromData();

            // Initialize student detail
            hBoxModifyStudent.setDisable(studentSelected.getValue() == null);

            // Update student detail
            studentSelected.addListener((obs, oldSelection, newSelection) -> {
                updateStudentDetail(newSelection);
            });
            setProgress(0.2);

            var result = new GetStudentListUseCase(Repositories.student).call();
            if (result.isError()) {
                return result.error();
            }
            students.addAll(result.data());
            setProgress(1.0);
            return null;
        });
    }

    @Override
    protected void onProgressChange(Double progress) {
        super.onProgressChange(progress);
        progressBar.setProgress(progress);
        vBoxMainBody.setDisable(isLoading());
    }

    private void initializeStudentTable() {
        tableColumnStudentId.setCellValueFactory(cellData -> cellData.getValue().getId());
        tableColumnLastName.setCellValueFactory(cellData -> cellData.getValue().getLastname());
        tableColumnFirstName.setCellValueFactory(cellData -> cellData.getValue().getFirstname());
        tableColumnBirth.setCellValueFactory(data -> {
            var value = data.getValue().getBirthString();
            return new SimpleStringProperty(value);
        });
        tableColumnGender.setCellValueFactory(data -> {
            var value = data.getValue().getGenderString();
            return new SimpleStringProperty(value);
        });
        tableColumnAddress.setCellValueFactory(cellData -> cellData.getValue().getAddress());
        tableColumnClassId.setCellValueFactory(cellData -> cellData.getValue().getClassId());
        tableColumnIsOff.setCellValueFactory(data -> {
            var value = data.getValue().getIsOffString();
            return new SimpleStringProperty(value);
        });
        tableViewStudent.setItems(students);
        tableViewStudent.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            studentSelected.setValue(newSelection);
            hBoxModifyStudent.setDisable(newSelection == null);
        });

    }


    private void updateStudentDetail(Student model) {
        if (model == null) {
            labelId.setText("");
            labelFullName.setText("");
            labelBirth.setText("");
            labelGender.setText("");
            labelAddress.setText("");
            labelClassId.setText("");
            labelIsOff.setText("");
            return;
        }
//        labelId.getProperties().put(K.DbFields.ID, model.getId());
        labelId.setText(model.getId().getValue());
        labelFullName.setText(model.getLastname().getValue() + " " + model.getFirstname().getValue());
        labelBirth.setText(model.getBirthString());
        labelGender.setText(model.getGenderString());
        labelAddress.setText(model.getAddress().getValue());
        labelClassId.setText(model.getClassId().getValue());
        labelIsOff.setText(model.getIsOffString());
    }

    // function for init all comboBox as filter for student table
    private void initComboBoxFromData() {
    }

    public void buttonRefreshStudentOnPressed(ActionEvent actionEvent) {
    }

    public void buttonSearchStudentOnPressed(ActionEvent actionEvent) {
        var validateMessage = getValidateMessage(textFieldSearchStudent);
        if (validateMessage != null) {
            textFieldSearchStudent.requestFocus();
            return;
        }

        // TODO: search student

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
                StudentFormPresenter controller = fxmlLoader.getController();
                controller.setId(tableViewStudent.getSelectionModel().getSelectedItem().getId().getValue());
            });
            if (result != null) {
                AppLogger.log(result.toString());
            } else {
                AppLogger.log("Cancelled");
            }
        } catch (Exception e) {
            AppLogger.log(e.getCause().toString());
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
            runAsTask(() -> {
                var error = new DisconnectDbUseCase(Repositories.auth).call();
                if (error == null) {
                    Platform.runLater(() -> AppRouter.goTo(FxUtils.getStageFromNode(menuBar), K.Routes.LOGIN, new Size(400, 360)));
                }
                return error;
            });
        }
    }

    public void buttonStudentUndoOnPressed(ActionEvent actionEvent) {
    }

    public void buttonStudentRedoOnPressed(ActionEvent actionEvent) {
    }

    public void buttonStudentSaveOnPressed(ActionEvent actionEvent) {
    }
}
