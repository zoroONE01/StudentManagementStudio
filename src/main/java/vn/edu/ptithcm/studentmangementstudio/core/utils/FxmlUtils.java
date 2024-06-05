package vn.edu.ptithcm.studentmangementstudio.core.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import vn.edu.ptithcm.studentmangementstudio.Main;

import java.io.IOException;

public class FxmlUtils {
    static public Parent getParentFromView(String viewPath) {
        var fxmlLoader = new FXMLLoader(Main.class.getResource(viewPath));
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
