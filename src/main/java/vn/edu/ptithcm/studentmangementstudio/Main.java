package vn.edu.ptithcm.studentmangementstudio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vn.edu.ptithcm.studentmangementstudio.core.K;
import vn.edu.ptithcm.studentmangementstudio.core.utils.AppLogger;
import vn.edu.ptithcm.studentmangementstudio.core.utils.FxmlUtils;
import vn.edu.ptithcm.studentmangementstudio.data.repository.Repositories;
import vn.edu.ptithcm.studentmangementstudio.domain.usecase.auth.DisconnectDbUseCase;
import vn.edu.ptithcm.studentmangementstudio.domain.usecase.auth.ConnectToServerAsRootUseCase;

public class Main extends Application {

/*    @Override
    public void init() throws Exception {
        super.init();
        var error = new ConnectToServerAsRootUseCase(Repositories.auth).call();
        if (error != null) {
            AppLogger.log(error.getMessage(), this.getClass().toString());
        } else {
            AppLogger.log("Connected to database", this.getClass().toString());
        }
    }*/

    @Override
    public void stop() throws Exception {
        var error = new DisconnectDbUseCase(Repositories.auth).call();
        if (error != null) {
            AppLogger.log(error.getMessage(), this.getClass().toString());
        }
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