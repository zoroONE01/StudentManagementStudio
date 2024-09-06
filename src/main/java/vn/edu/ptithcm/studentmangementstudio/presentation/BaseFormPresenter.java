package vn.edu.ptithcm.studentmangementstudio.presentation;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.stage.Stage;
import vn.edu.ptithcm.studentmangementstudio.Main;
import vn.edu.ptithcm.studentmangementstudio.core.K;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

abstract public class BaseFormPresenter<T> extends BasePresenter {
    private final ButtonType CONFIRM = new ButtonType(K.Strings.CONFIRM, ButtonType.APPLY.getButtonData());
    protected final Dialog<T> dialog = new Dialog<>();


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

    public T show(Consumer<FXMLLoader> presenterBuilder) throws IOException {

        // Load the FXML file
        var loader = new FXMLLoader(Main.class.getResource(getPath()));

        // Create the dialog
        DialogPane pane = loader.load();
        presenterBuilder.accept(loader);

        dialog.setDialogPane(pane);
        var type = dialog.showAndWait();
        BaseFormPresenter<T> controller = loader.getController();
        if (type.isPresent() && type.get() == CONFIRM) {
            return controller.onSave();
        } else {
            controller.onClose();
            return null;
        }
    }

}
