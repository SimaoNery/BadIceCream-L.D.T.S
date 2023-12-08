package badIceCream.model.menu;

import java.util.Arrays;
import java.util.List;

public class LevelCompletedMenu extends Menu {
    public LevelCompletedMenu() {
        super(Arrays.asList("NEXT LEVEL", "   MENU"));
    }
    public boolean isSelectedNextLevel() {
        return isSelected(0);
    }

    public boolean isSelectedQuitToMainMenu() {
        return isSelected(1);
    }
}