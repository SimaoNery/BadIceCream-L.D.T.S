package badIceCream.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MenuTest {
    private Menu menu;
    private List<String> entries;

    @BeforeEach
    public void setUp() {
        entries = new ArrayList<>(List.of("test1", "test2", "test4", "test3", "test5"));
        menu = new Menu(entries);
    }
    @Test
    public void getEntry() {
        assertEquals("test3",menu.getEntry(3));
    }
    @Test
    public void getNumberEntries() {
        assertEquals(5, menu.getNumberEntries());
    }
    @Test
    public void nextEntryNotMoreThanNumEntries() {
        int expected = menu.currentEntry + 1;
        menu.nextEntry();
        assertEquals(expected,menu.currentEntry);
    }
    @Test
    public void nextEntryMoreThanNumEntries() {
        menu.currentEntry = entries.size() + 1;
        menu.nextEntry();
        assertEquals(0,menu.currentEntry);
    }
    @Test
    public void previousEntryPositive() {
        menu.currentEntry = 1;
        menu.previousEntry();
        assertEquals(0, menu.currentEntry);
    }
    @Test
    public void previousEntryNegative() {
        menu.previousEntry();
        assertEquals(entries.size() - 1, menu.currentEntry);
    }
    @Test
    public void isSelectedTrue() {
        assertTrue(menu.isSelected(0));
    }
    @Test
    public void isSelectedFalse() {
        assertFalse(menu.isSelected(1));
    }
}