package vn.edu.ptithcm.studentmangementstudio.presentation;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.core.router.AppRouter;
import vn.edu.ptithcm.studentmangementstudio.core.utils.AppLogger;
import vn.edu.ptithcm.studentmangementstudio.data.repository.Repositories;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Department;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.LoginInfo;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.LoginInput;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Result;
import vn.edu.ptithcm.studentmangementstudio.domain.usecase.auth.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginPresenter extends BasePresenter implements Initializable {

    public Button buttonLogin;
    public ComboBox<Department> cbbDepartment;
    public PasswordField textFieldPassword;
    public TextField textFieldUsername;
    public VBox vBoxMain;
    public ProgressIndicator progressIndicator;
    public CheckBox checkBoxAdmin;


    @Override
    protected void onProgressChange(Double progress) {
        super.onProgressChange(progress);
        Platform.runLater(() -> {
            vBoxMain.setDisable(isLoading());
            progressIndicator.setVisible(isLoading());
            progressIndicator.setProgress(progress);
        });
    }


    public void buttonLoginOnPressed(ActionEvent event) {

        runAsTask(() -> {
            var validateMessage = getValidateMessage(textFieldUsername, textFieldPassword, cbbDepartment);
            if (validateMessage != null) {
                showAlertDialog(validateMessage);
                return;
            }
            setProgress(.1);

            var disconnectError = new DisconnectDbUseCase(Repositories.auth).call();
            if (disconnectError != null) {
                showAlertDialog(disconnectError);
                return;
            }
            setProgress(.3);


            // connect to server
            var input = new LoginInput(textFieldUsername.getText(), textFieldPassword.getText(), cbbDepartment.getValue());
            Exception connectError;
            if (checkBoxAdmin.isSelected()) {
                connectError = new ConnectToServerUseCase(Repositories.auth, input).call();
            } else {
                connectError = new ConnectToServerAsStudentUseCase(Repositories.auth, input.department().serverName()).call();
            }
            if (connectError != null) {
                showAlertDialog(connectError);
                return;
            }
            setProgress(.6);


            // get user info
            Result<LoginInfo, Exception> result;
            if (checkBoxAdmin.isSelected()) {
                result = new GetTeacherInfoUseCase(Repositories.auth, input.username()).call();

            } else {
                result = new GetStudentInfoUseCase(Repositories.auth, input).call();
            }
            if (result.isError()) {
                showAlertDialog(result.error());
                return;
            }
            setProgress(1.0);

            showAlertDialog(result.data().toString());

            // TOTO: save user info to local storage
//            Platform.runLater(() -> AppRouter.goTo(event, K.Routes.DASHBOARD_ADMIN));
        });
    }

    void initDepartment() {
        runAsTask(() -> {
            var result = new GetDepartmentUseCase(Repositories.auth).call();
            if (result.isError()) {
                showAlertDialog(result.error());
                return;
            }
            var departments = result.data();
            for (var department : departments) cbbDepartment.getItems().add(department);
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);
        runAsTask(() -> {
            var error = new ConnectToServerAsRootUseCase(Repositories.auth).call();
            if (error != null) {
                AppLogger.log(error.toString(), this.getClass().toString());
            } else {
                initDepartment();
            }
        });
    }

}
