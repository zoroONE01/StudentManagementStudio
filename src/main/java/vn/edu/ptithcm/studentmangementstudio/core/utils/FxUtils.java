package vn.edu.ptithcm.studentmangementstudio.core.utils;

import javafx.event.Event;
import javafx.scene.Node;
import javafx.stage.Stage;

public class FxUtils {
    public static Stage getStageFromNode(Node node) {
        return (Stage) node.getScene().getWindow();
    }

    public static Stage getStageFromEvent(Event event) {
        var node = (Node) event.getSource();
        return (Stage) node.getScene().getWindow();
    }
}
