package vn.edu.ptithcm.studentmangementstudio.presentation;


import javafx.scene.Node;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import vn.edu.ptithcm.studentmangementstudio.domain.entity.ContextMenuItem;

import java.util.List;

abstract public class BasePresenter {

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
}