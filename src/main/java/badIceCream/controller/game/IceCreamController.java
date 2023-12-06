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

        private void moveIceCreamLeft() {
            moveIceCream(getModel().getIceCream().getPosition().getLeft(), GUI.ACTION.LEFT, System.currentTimeMillis());
        }

        private void moveIceCreamRight() {
            moveIceCream(getModel().getIceCream().getPosition().getRight(), GUI.ACTION.RIGHT, System.currentTimeMillis());
        }

        private void moveIceCreamUp() {
            moveIceCream(getModel().getIceCream().getPosition().getUp(), GUI.ACTION.UP, System.currentTimeMillis());
        }

        private void moveIceCreamDown() {
            moveIceCream(getModel().getIceCream().getPosition().getDown(), GUI.ACTION.DOWN, System.currentTimeMillis());
        }

        public int eatFruit() {
            return getModel().eatFruit(getModel().getIceCream().getPosition());
        }

        public void moveIceCream(Position position, GUI.ACTION last, long time) {

            if (getModel().isEmpty(position) && time - lastTime >= 15) {
                getModel().getIceCream().setPosition(position);

                if (!getModel().getIceCream().isStrawberryActive() && getModel().hasMonster(position) != null) getModel().getIceCream().changeAlive();
            }
            getModel().getIceCream().setLastMovement(last);
            lastMovement = last;
        }

        private void powerIceCream() {
            getModel().powerIceCream(lastMovement);
        }

        @Override
        public void step(Game game, GUI.ACTION action, long time) {
            if (action == GUI.ACTION.UP) moveIceCreamUp();
            if (action == GUI.ACTION.RIGHT) moveIceCreamRight();
            if (action == GUI.ACTION.DOWN) this.moveIceCream(getModel().getIceCream().getPosition().getDown(), GUI.ACTION.DOWN, System.currentTimeMillis());
            if (action == GUI.ACTION.LEFT) moveIceCreamLeft();
            if (action == GUI.ACTION.SPACE) powerIceCream();
        }
}

