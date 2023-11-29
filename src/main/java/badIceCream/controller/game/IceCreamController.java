package badIceCream.controller.game;

import badIceCream.Game;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.Position;
import badIceCream.GUI.GUI;

;
public class IceCreamController extends GameController {

        private GUI.ACTION lastMovement;
        public IceCreamController(Arena arena) {
            super(arena);
        }

        public void moveIceCreamLeft() {
            moveIceCream(getModel().getIceCream().getPosition().getLeft(), GUI.ACTION.LEFT);
        }

        public void moveIceCreamRight() {
            moveIceCream(getModel().getIceCream().getPosition().getRight(), GUI.ACTION.RIGHT);
        }

        public void moveIceCreamUp() {
            moveIceCream(getModel().getIceCream().getPosition().getUp(), GUI.ACTION.UP);
        }

        public void moveIceCreamDown() {
            moveIceCream(getModel().getIceCream().getPosition().getDown(), GUI.ACTION.DOWN);
        }

        private void moveIceCream(Position position, GUI.ACTION last) {
            if (getModel().isEmpty(position)) {
                getModel().getIceCream().setPosition(position);
                int type = getModel().eatFruit(position);
                if (type != -1) {
                    // Type of fruit TO DO
                }
                lastMovement = last;
                if (getModel().isMonster(position)) getModel().getIceCream().changeAlive();
            }
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

