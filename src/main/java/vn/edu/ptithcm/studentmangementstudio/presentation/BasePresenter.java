package vn.edu.ptithcm.studentmangementstudio.presentation;


import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.core.router.AppDialog;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.ContextMenuItem;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

abstract public class BasePresenter implements Initializable {

    private final SimpleDoubleProperty progress = new SimpleDoubleProperty(-1);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        progress.addListener((observable, oldValue, newValue) -> onProgressChange(newValue.doubleValue()));
    }

    protected void setProgress(Double progress) {
        this.progress.set(progress);
    }

    protected void turnOnLoading() {
        progress.set(0.1);
    }

    protected void turnOffLoading() {
        progress.set(0);
    }

    protected boolean isLoading() {
        return progress.get() > 0;
    }

    protected void onProgressChange(Double progress) {
    }

    protected void showAlertDialog(Exception exception) {
        showAlertDialog(exception.getMessage());
    }

    protected void showAlertDialog(String message) {
        Platform.runLater(() -> AppDialog.showAlertDialog(message));
    }

    protected void runAsTask(Supplier<Exception> callable) {
        turnOnLoading();
        var task = new Task<Exception>() {
            @Override
            protected Exception call() {
                return callable.get();
            }
        };
        task.setOnSucceeded(workerStateEvent -> {
            turnOffLoading();
            var exception = task.getValue();
            if (exception == null) return;
            showAlertDialog(exception);
        });
        new Thread(task).start();
    }

    protected void showContextMenu(Node node, List<ContextMenuItem> items) {
        var contextMenu = new ContextMenu();
        var menuItems = List.copyOf(items.stream().map(item -> {
            var menuItem = new MenuItem(item.getLabel());
            menuItem.setOnAction(item.getAction());
            return menuItem;
        }).toList());
        contextMenu.getItems().addAll(menuItems);
        contextMenu.show(node, node.getLayoutX(), node.getLayoutY() + node.getLayoutBounds().getHeight());
    }

    protected String getValidateMessage(Control... components) {
        var errorList = new ArrayList<Control>();
        for (var component : components) {
            if (component instanceof TextField) {
                if (((TextField) component).getText().isBlank()) {
                    errorList.add(component);
                }
            } else if (component instanceof ComboBox) {
                if (((ComboBox<?>) component).getValue() == null) {
                    errorList.add(component);
                }
            }
        }
        if (errorList.isEmpty()) return null;
        var errorString = errorList.stream().map(Control::getAccessibleHelp).collect(Collectors.joining(", "));
        return errorString + K.Strings.DO_NOT_LEAVE_BLANK;
    }
}