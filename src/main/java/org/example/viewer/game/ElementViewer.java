package org.example.viewer.game;

import org.example.GUI.GUI;
import org.example.model.game.elements.Element;
import org.example.viewer.Viewer;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
