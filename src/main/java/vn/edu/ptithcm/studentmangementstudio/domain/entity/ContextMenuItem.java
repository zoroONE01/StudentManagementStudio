package vn.edu.ptithcm.studentmangementstudio.domain.entity;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ContextMenuItem {
    private String label;
    private EventHandler<ActionEvent> action;

    public ContextMenuItem(String label, EventHandler<ActionEvent> action) {
        this.label = label;
        this.action = action;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public EventHandler<ActionEvent> getAction() {
        return action;
    }

    public void setAction(EventHandler<ActionEvent> action) {
        this.action = action;
    }
}
