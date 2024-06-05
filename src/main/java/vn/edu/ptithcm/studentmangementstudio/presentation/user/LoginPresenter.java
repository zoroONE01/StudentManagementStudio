package vn.edu.ptithcm.studentmangementstudio.presentation.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.core.router.AppRouter;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Size;
import vn.edu.ptithcm.studentmangementstudio.presentation.BasePresenter;

public class LoginPresenter extends BasePresenter {

    @FXML
    private Button buttonLogin;

    @FXML
    private Button buttonMangerRole;

    @FXML
    private PasswordField textFieldPassword;

    @FXML
    private TextField textFieldUsername;

    @FXML
    void buttonLoginOnPressed(ActionEvent event) {
        AppRouter.goTo(event, K.Routes.DASHBOARD);
    }

    @FXML
    void buttonMangerRoleOnPressed(ActionEvent event) {
        AppRouter.goTo(event, K.Routes.LOGIN_ADMIN, new Size(400, 360));
    }
}
