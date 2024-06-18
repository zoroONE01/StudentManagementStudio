package vn.edu.ptithcm.studentmangementstudio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.core.helper.DBHelper;
import vn.edu.ptithcm.studentmangementstudio.core.utils.FxmlUtils;

import java.sql.Connection;

public class Main extends Application {
    Connection connection;

    @Override
    public void init() throws Exception {
        super.init();
        DBHelper.getInstance().initialize(1430, "sa", "adminadmin");
    }

    @Override
    public void stop() throws Exception {
        DBHelper.getInstance().close();
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