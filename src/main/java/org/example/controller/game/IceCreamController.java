package org.example.controller.game;

import org.example.Game;
import org.example.model.game.arena.Arena;
import org.example.model.Position;
import org.example.GUI.GUI;


public class IceCreamController extends GameController {
        public IceCreamController(Arena arena) {
            super(arena);
        }

        public void moveIceCreamLeft() {
            moveIceCream(getModel().getIceCream().getPosition().getLeft());
        }

        public void moveIceCreamRight() {
            moveIceCream(getModel().getIceCream().getPosition().getRight());
        }

        public void moveIceCreamUp() {
            moveIceCream(getModel().getIceCream().getPosition().getUp());
        }

        public void moveIceCreamDown() {
            moveIceCream(getModel().getIceCream().getPosition().getDown());
        }

        private void moveIceCream(Position position) {
            if (getModel().isEmpty(position)) {
                getModel().getIceCream().setPosition(position);
                if (getModel().isMonster(position)) getModel().getIceCream();
            }
        }

        @Override
        public void step(Game game, GUI.ACTION action, long time) {
            if (action == GUI.ACTION.UP) moveIceCreamUp();
            if (action == GUI.ACTION.RIGHT) moveIceCreamRight();
            if (action == GUI.ACTION.DOWN) moveIceCreamDown();
            if (action == GUI.ACTION.LEFT) moveIceCreamLeft();
        }
}

