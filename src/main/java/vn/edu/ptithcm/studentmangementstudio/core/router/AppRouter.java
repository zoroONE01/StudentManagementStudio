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
import vn.edu.ptithcm.studentmangementstudio.domain.entity.Size;
import vn.edu.ptithcm.studentmangementstudio.presentation.BasePresenter;

import java.io.IOException;
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

    public static void goTo(Stage stage, String route, Function<FXMLLoader, BasePresenter> presenterBuilder) {
        try {
            stage.close();
            var fxmlLoader = new FXMLLoader(Main.class.getResource(route));

            // handler controller before navigate
            var viewController = presenterBuilder.apply(fxmlLoader);

            Parent root = (Parent) fxmlLoader.load();
            var scene = new Scene(root, 1200, 800);
            stage.setScene(scene);
            stage.show();
            AppLogger.log("Navigating to " + route + " : ", "AppRouter");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void goTo(ActionEvent event, String route, Function<FXMLLoader, BasePresenter> presenterBuilder) {
        goTo(FxUtils.getStageFromEvent(event), route, presenterBuilder);
    }

    public static void goTo(Stage stage, String route, Size size, Function<FXMLLoader, BasePresenter> presenterBuilder) {
        try {
            stage.close();
            var fxmlLoader = new FXMLLoader(Main.class.getResource(route));

            // handler controller before navigate
            var viewController = presenterBuilder.apply(fxmlLoader);

            var root = (Parent) fxmlLoader.load();
            var scene = new Scene(root, size.width(), size.height());
            stage.setScene(scene);
            stage.show();
            AppLogger.log("Navigating to " + route + " : ", "AppRouter");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void goTo(ActionEvent event, String route, Size size, Function<FXMLLoader, BasePresenter> presenterBuilder) {
        goTo(FxUtils.getStageFromEvent(event), route, size, presenterBuilder);
    }

}


