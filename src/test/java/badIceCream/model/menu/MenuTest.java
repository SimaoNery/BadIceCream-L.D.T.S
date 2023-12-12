package badIceCream.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class MenuTest {
    private Menu menu;
    @Mock
    private List<String> entries;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(entries.size()).thenReturn(5);
        when(entries.get(3)).thenReturn("test");
        menu = new Menu(entries);
    }
    @Test
    public void getEntry() {
        assertEquals(entries.get(3),menu.getEntry(3));
    }
    @Test
    public void getNumberEntries() {
        assertEquals(entries.size(), menu.getNumberEntries());
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
