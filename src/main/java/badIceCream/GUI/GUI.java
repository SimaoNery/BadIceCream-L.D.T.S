package badIceCream.GUI;

import badIceCream.model.Position;

import java.io.IOException;


public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, SPACE, NONE, QUIT, SELECT, RESUME, PAUSE}
}
