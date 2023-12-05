package badIceCream.model.menu;

import java.util.Arrays;

public class InstructionsMenuFirstPage extends Menu {

    public InstructionsMenuFirstPage() {
        super(Arrays.asList("Quit to Main Menu"));
    }
    public boolean isSelectedQuitToMainMenu() {
        return isSelected(0);
    }
}
