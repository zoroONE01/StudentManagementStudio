package vn.edu.ptithcm.studentmangementstudio.presentation;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import vn.edu.ptithcm.studentmangementstudio.Main;
import vn.edu.ptithcm.studentmangementstudio.core.K;

import java.io.IOException;
import java.util.function.Function;

abstract public class BaseFormPresenter<T> extends BasePresenter {
    private final ButtonType CONFIRM = new ButtonType(K.Strings.CONFIRM, ButtonType.APPLY.getButtonData());

    protected abstract String getPath();

    abstract protected T onSave();

    protected void onClose() {
    }

    public void updateUI(T data) {
    }

    public T show() throws IOException {

        // Load the FXML file
        var loader = new FXMLLoader(Main.class.getResource(getPath()));

        // Create the dialog
        DialogPane pane = loader.load();
        var dialog = new Dialog<T>();
        dialog.setDialogPane(pane);
        BaseFormPresenter<T> controller = loader.getController();
        var type = dialog.showAndWait();
        if (type.isPresent() && type.get() == CONFIRM) {
            return controller.onSave();
        } else {
            controller.onClose();
            return null;
        }
    }

    public T show(Function<FXMLLoader, BaseFormPresenter<T>> presenterBuilder) throws IOException {

        // Load the FXML file
        var loader = new FXMLLoader(Main.class.getResource(getPath()));

        // Create the dialog
        DialogPane pane = loader.load();
        var dialog = new Dialog<>();
        dialog.setDialogPane(pane);
        var controller = presenterBuilder.apply(loader);
        var type = dialog.showAndWait();
        if (type.isPresent() && type.get() == CONFIRM) {
            return controller.onSave();
        } else {
            controller.onClose();
            return null;
        }
    }
}
