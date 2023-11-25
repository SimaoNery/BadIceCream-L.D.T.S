package badIceCream.model.menu;

import java.util.Arrays;

public class MainMenu extends Menu {

    public MainMenu() {
        super(Arrays.asList("Start", "Instructions", "Exit"));
    }

    public boolean isSelectedExit() {
        return isSelected(2);
    }

    public boolean isSelectedInstructions() {
        return isSelected(1);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

}
