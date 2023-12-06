package badIceCream.model.menu;

import java.util.Arrays;
import java.util.List;

public class InstructionsMenuSecondPage extends Menu {
    public InstructionsMenuSecondPage() {
        super(Arrays.asList("Quit to Main Menu"));
    }

    public boolean isSelectedQuitToMainMenu() {
        return isSelected(0);
    }
}
