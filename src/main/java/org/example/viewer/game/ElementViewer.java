package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
