package vn.edu.ptithcm.studentmangementstudio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.core.utils.FxmlUtils;

public class Main extends Application {

    @Override
    public void init() throws Exception {
        super.init();
        // TODO: connect to server
    }

    @Override
    public void stop() throws Exception {
        // TODO: disconnect from server
        super.stop();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle(K.Strings.APP_NAME);
        var root = FxmlUtils.getParentFromView(K.Routes.LOGIN);
        var scene = new Scene(root, 400, 360);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}