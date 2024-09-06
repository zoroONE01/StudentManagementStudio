package vn.edu.ptithcm.studentmangementstudio.core.router;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vn.edu.ptithcm.studentmangementstudio.Main;
import vn.edu.ptithcm.studentmangementstudio.core.utils.AppLogger;
import vn.edu.ptithcm.studentmangementstudio.core.utils.FxUtils;
import vn.edu.ptithcm.studentmangementstudio.core.utils.FxmlUtils;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.LoginInfo;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Size;
import vn.edu.ptithcm.studentmangementstudio.presentation.BasePresenter;
import vn.edu.ptithcm.studentmangementstudio.presentation.admin.DashboardPresenter;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Function;


public class AppRouter {


    public static void goTo(Stage stage, String route) {
        stage.close();
        var root = FxmlUtils.getParentFromView(route);
        var scene = new Scene(root, 1200, 800);
        stage.setScene(scene);
        stage.show();
        AppLogger.log("Navigating to " + route, "AppRouter");
    }

    public static void goTo(ActionEvent event, String route) {
        goTo(FxUtils.getStageFromEvent(event), route);
    }

    public static void goTo(Stage stage, String route, Size size) {
        stage.close();
        var root = FxmlUtils.getParentFromView(route);

        var scene = new Scene(root, size.width(), size.height());
        stage.setScene(scene);
        stage.show();
        AppLogger.log("Navigating to " + route, "AppRouter");
    }

    public static void goTo(ActionEvent event, String route, Size size) {
        goTo(FxUtils.getStageFromEvent(event), route, size);
    }

    public static void goTo(Stage stage, String route, Consumer<FXMLLoader> presenterBuilder) {
        try {
            stage.close();
            var fxmlLoader = new FXMLLoader(Main.class.getResource(route));
            Parent root = fxmlLoader.load();

            // handler controller before navigate
            presenterBuilder.accept(fxmlLoader);

            var scene = new Scene(root, 1200, 800);
            stage.setScene(scene);
            stage.show();
            AppLogger.log("Navigating to " + route + " : ", "AppRouter");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void goTo(ActionEvent event, String route, Consumer<FXMLLoader> presenterBuilder) {
        goTo(FxUtils.getStageFromEvent(event), route, presenterBuilder);
    }

    public static void goTo(Stage stage, String route, Size size, Consumer<FXMLLoader> presenterBuilder) {
        try {
            stage.close();
            var fxmlLoader = new FXMLLoader(Main.class.getResource(route));
            Parent root = fxmlLoader.load();

            // handler controller before navigate
            presenterBuilder.accept(fxmlLoader);

            var scene = new Scene(root, size.width(), size.height());
            stage.setScene(scene);
            stage.show();
            AppLogger.log("Navigating to " + route + " : ", "AppRouter");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void goTo(ActionEvent event, String route, Size size, Consumer<FXMLLoader> presenterBuilder) {
        goTo(FxUtils.getStageFromEvent(event), route, size, presenterBuilder);
    }

}


