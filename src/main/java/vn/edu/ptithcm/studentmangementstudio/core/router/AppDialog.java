package vn.edu.ptithcm.studentmangementstudio.core.router;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AppDialog {

    public static Boolean showAlertDialog(String message) {
        var alert = new Alert(Alert.AlertType.CONFIRMATION, message, ButtonType.OK, ButtonType.CANCEL);
        alert.showAndWait();
        return alert.getResult() == ButtonType.OK;
    }
}
