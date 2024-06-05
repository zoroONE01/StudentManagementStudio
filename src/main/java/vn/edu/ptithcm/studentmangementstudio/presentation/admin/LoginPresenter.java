package vn.edu.ptithcm.studentmangementstudio.presentation.admin;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.core.router.AppRouter;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Size;
import vn.edu.ptithcm.studentmangementstudio.presentation.BasePresenter;

public class LoginPresenter extends BasePresenter {

    public Button buttonLogin, buttonStudentRole;
    public ComboBox<?> cbbDepartment;
    public PasswordField textFieldPassword;
    public TextField textFieldUsername;

    public void buttonLoginOnPressed(ActionEvent event) {
        AppRouter.goTo(event, K.Routes.DASHBOARD_ADMIN);
    }

    public void buttonStudentRoleOnPressed(ActionEvent event) {
        AppRouter.goTo(event, K.Routes.LOGIN, new Size(400, 360));
    }
}
