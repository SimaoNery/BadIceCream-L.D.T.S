package badIceCream.viewer.game;

import badIceCream.GUI.GUI;
import badIceCream.GUI.GameGraphics;
import badIceCream.GUI.Graphics;
import badIceCream.model.game.elements.fruits.Fruit;

public class FruitViewer implements ElementViewer<Fruit>{
    @Override
    public void draw(Fruit fruit, Graphics gui){
        switch(fruit.getType()){
            case 1: gui.drawAppleFruit(fruit.getPosition());
                break;
            case 2: gui.drawBananaFruit(fruit.getPosition());
                break;
            case 3: gui.drawPepperFruit(fruit.getPosition());
                break;
            case 4: gui.drawPineappleFruit(fruit.getPosition());
                break;
            case 5: gui.drawStrawberryFruit(fruit.getPosition());
                break;
        }
    }
}
