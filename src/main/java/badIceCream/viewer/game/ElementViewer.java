package badIceCream.viewer.game;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.GUI.Graphics;
import badIceCream.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, Graphics gui);
}
