package badIceCream.model.menu;

import java.util.Arrays;
import java.util.List;

public class InstructionsMenu extends Menu {

    public InstructionsMenu() {
        super(Arrays.asList("Quit to Main Menu"));
    }
    public boolean isSelectedQuitToMainMenu() {
        return isSelected(0);
    }
}
