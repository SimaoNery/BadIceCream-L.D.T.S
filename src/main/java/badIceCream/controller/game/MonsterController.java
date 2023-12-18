package badIceCream.controller.game;

import badIceCream.Game;
import badIceCream.controller.game.monsters.RunnerMovementEnabled;
import badIceCream.controller.game.monsters.RunnerMovementDisabled;
import badIceCream.model.game.arena.Arena;
import badIceCream.model.game.elements.monsters.Monster;
import badIceCream.utils.Audio;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Random;

public class MonsterController {
    Monster monster;
    private StepMonsters step;
    private long lastMovement;
    private long lastChange;
    private final Arena arena;
    private Audio runner;
    boolean runnerOn;

    public MonsterController(Arena arena, StepMonsters step, Monster monster) {
        this.arena = arena;
        this.step = step;
        this.monster = monster;
        lastMovement = 0;
        lastChange = 0;
    }
    public MonsterController(Arena arena, StepMonsters step, Monster monster, Audio runner) {
        this.arena = arena;
        this.step = step;
        this.monster = monster;
        this.runner = runner;
    }
    public void setRunner(Audio runner) {
        this.runner = runner;
    }
    public void step(long time) throws IOException {
        long minValue = 5000L;
        long maxValue = 15000L;

        Random random = new Random();
        long randomLong = minValue + (long) (random.nextDouble() * (maxValue - minValue + 1));

        if (monster.getType() == 3 && time - lastChange >= randomLong) {
            runnerOn = !runnerOn;

            if (runnerOn) {
                runner.playOnce();
                monster.startRunning();
                this.step = new RunnerMovementEnabled();
            }
            else {
                monster.stopRunning();
                this.step = new RunnerMovementDisabled();
            }
            lastChange = time;
        }

        this.step.step(monster, arena, time, lastMovement);
        lastMovement = time;
    }
}
