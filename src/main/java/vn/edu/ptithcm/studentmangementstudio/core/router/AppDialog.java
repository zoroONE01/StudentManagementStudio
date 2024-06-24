package vn.edu.ptithcm.studentmangementstudio.core.router;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AppDialog {

    public static Boolean showConfirmDialog(String message) {
        var alert = new Alert(Alert.AlertType.CONFIRMATION, message, ButtonType.OK, ButtonType.CANCEL);
        alert.showAndWait();
        return alert.getResult() == ButtonType.OK;
    }

    public static void showAlertDialog(String message) {
        var alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        alert.showAndWait();
        alert.getResult();
    }

    public static void showLoadingDialog() {
        var alert = new Alert(Alert.AlertType.NONE, "Loading...");
        alert.show();
    }

}
