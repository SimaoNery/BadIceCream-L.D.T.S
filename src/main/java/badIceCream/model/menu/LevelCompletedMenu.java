package badIceCream.model.menu;

import java.util.Arrays;
import java.util.List;

public class LevelCompletedMenu extends Menu {
    public LevelCompletedMenu() {
        super(Arrays.asList("Next Level", "Quit to Main Menu"));
    }
    public boolean isSelectedNextLevel() {
        return isSelected(0);
    }

    public boolean isSelectedQuitToMainMenu() {
        return isSelected(1);
    }
}
