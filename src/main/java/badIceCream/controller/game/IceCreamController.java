package badIceCream.controller.game;

import badIceCream.Game;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.Position;
import badIceCream.GUI.GUI;


public class IceCreamController extends GameController {

        private GUI.ACTION lastMovement;
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

        public int eatFruit() {
            return getModel().eatFruit(getModel().getIceCream().getPosition());
        }

        private void moveIceCream(Position position, GUI.ACTION last, long time) {

            if (getModel().isEmpty(position) && time - lastTime >= 15) {
                getModel().getIceCream().setPosition(position);

                if (!getModel().getIceCream().isStrawberryActive() && getModel().isMonster(position)) getModel().getIceCream().changeAlive();
            }
            getModel().getIceCream().setLastMovement(last);
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
}

