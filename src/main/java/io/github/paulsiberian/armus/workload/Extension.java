/*
 * Copyright (c) Храпунов П. Н., 2019.
 */

package io.github.paulsiberian.armus.workload;

import io.github.paulsiberian.armus.api.GUIManager;
import io.github.paulsiberian.armus.api.extension.IExtension;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

public class Extension implements IExtension {

    @Override
    public void start() {
        var gui = GUIManager.getInstance();
        var menuBar = gui.getMenuBar();
        var fileMenu = menuBar.getMenus().get(0);
        var newMenu = (Menu) fileMenu.getItems().get(0);
        var newErrandCard = new MenuItem("Errand card");
        newMenu.getItems().add(newErrandCard);
    }

}
