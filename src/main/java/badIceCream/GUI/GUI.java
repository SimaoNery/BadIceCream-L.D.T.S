package badIceCream.GUI;

import badIceCream.model.Position;

import java.io.IOException;


public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawIceCream(Position position);

    void drawStoneWall(Position position);
    void drawIceWall(Position position);

    void drawDefaultMonster(Position position);
    void drawRunnerMonster(Position position);
    void drawJumperMonster(Position position);
    void drawWallBreakerMonster(Position position);
    void drawAppleFruit(Position position);
    void drawBananaFruit(Position position);
    void drawPineappleFruit(Position position);
    void drawPepperFruit(Position position);
    void drawStrawberryFruit(Position position);


    void drawText(Position position, String text, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    enum ACTION {UP, RIGHT, DOWN, LEFT, SPACE, NONE, QUIT, SELECT, RESUME, PAUSE}
}
