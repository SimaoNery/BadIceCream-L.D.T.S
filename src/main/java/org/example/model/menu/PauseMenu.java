package org.example.model.menu;

import java.util.Arrays;

public class PauseMenu extends Menu {
    public PauseMenu() {
        super(Arrays.asList("Resume", "Menu"));
    }
    public boolean isSelectedMenu() {
        return isSelected(1);
    }

    public boolean isSelectedResume() {
        return isSelected(0);
    }
}
