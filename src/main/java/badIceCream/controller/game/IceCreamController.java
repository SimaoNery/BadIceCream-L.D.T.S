package badIceCream.controller.game;

import badIceCream.Game;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.Position;
import badIceCream.GUI.GUI;

;import java.io.IOException;

public class IceCreamController extends GameController {

        private GUI.ACTION lastMovement;
        long stawberryTime;
        long lastTime = 0;
        public IceCreamController(Arena arena) {
            super(arena);
        }

        public void moveIceCreamLeft() {
            moveIceCream(getModel().getIceCream().getPosition().getLeft(), GUI.ACTION.LEFT, System.currentTimeMillis());
        }

        public void moveIceCreamRight() {
            moveIceCream(getModel().getIceCream().getPosition().getRight(), GUI.ACTION.RIGHT, System.currentTimeMillis());
        }

        public void moveIceCreamUp() {
            moveIceCream(getModel().getIceCream().getPosition().getUp(), GUI.ACTION.UP, System.currentTimeMillis());
        }

        public void moveIceCreamDown() {
            moveIceCream(getModel().getIceCream().getPosition().getDown(), GUI.ACTION.DOWN, System.currentTimeMillis());
        }

        private void moveIceCream(Position position, GUI.ACTION last, long time) {

            if (getModel().getIceCream().isStrawberryActive() && stawberryTime - time >= 30000) {
                // Strawberry active for 30 s
                getModel().getIceCream().setStrawberry(false);
            }

            if (getModel().isEmpty(position) && time - lastTime >= 15) {
                getModel().getIceCream().setPosition(position);
                int type = getModel().eatFruit(position);
                if (type != 5) {
                    // Strawberry Active
                    getModel().getIceCream().setStrawberry(true);
                    stawberryTime = time;
                }
                if (getModel().isMonster(position)) getModel().getIceCream().changeAlive();
            }
            lastMovement = last;
        }

        public void powerIceCream() {
            getModel().powerIceCream(lastMovement);
        }

        @Override
        public void step(Game game, GUI.ACTION action, long time) {
            if (action == GUI.ACTION.UP) moveIceCreamUp();
            if (action == GUI.ACTION.RIGHT) moveIceCreamRight();
            if (action == GUI.ACTION.DOWN) moveIceCreamDown();
            if (action == GUI.ACTION.LEFT) moveIceCreamLeft();
            if (action == GUI.ACTION.SPACE) powerIceCream();
        }

    @Override // Ver com o stor
    public void stepMonsters(long time) throws IOException {

    }
}

