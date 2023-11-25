package badIceCream.Viewer;

import badIceCream.GUI.GUI;
import badIceCream.model.game.elements.fruits.*;
import badIceCream.viewer.game.FruitViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FruitViewerTest {
    private List<Fruit> fruits;
    private FruitViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        fruits = Arrays.asList(
                new AppleFruit(2, 3), new AppleFruit(2, 4),
                new BananaFruit(2, 5), new BananaFruit(2, 6),
                new PepperFruit(2, 7), new PepperFruit(2, 8),
                new PineappleFruit(3, 4), new PineappleFruit(3, 5),
                new StrawberryFruit(3, 6), new StrawberryFruit(3, 7));

        viewer = new FruitViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawWalls() throws IOException {
        for(Fruit fruta : fruits){
            viewer.draw(fruta, gui);

            switch (fruta.getType()){
                case 1: Mockito.verify(gui, Mockito.times(1)).drawAppleFruit(fruta.getPosition());
                    break;
                case 2: Mockito.verify(gui, Mockito.times(1)).drawBananaFruit(fruta.getPosition());
                    break;
                case 3: Mockito.verify(gui, Mockito.times(1)).drawPepperFruit(fruta.getPosition());
                    break;
                case 4:Mockito.verify(gui, Mockito.times(1)).drawPineappleFruit(fruta.getPosition());
                    break;
                case 5: Mockito.verify(gui, Mockito.times(1)).drawStrawberryFruit(fruta.getPosition());
            }

        }
    }
}
