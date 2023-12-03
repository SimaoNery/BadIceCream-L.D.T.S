package badIceCream.utils;

public class AudioController {
    Audio mainMenuMusic, levelMusic, breakWallSound, buildWallSound, eatFruitSound, gameOverMenuSound, levelCompleteMenuSound, winSound,
            runnerMonsterSound, monsterCollisionSound;

    public AudioController(){
        mainMenuMusic = new Audio("MainMenuMusic.wav");
        levelMusic = new Audio("LevelMusic.wav");
        breakWallSound = new Audio("BreakWallSound.wav");
        buildWallSound = new Audio("BuildWallSound.wav");
        eatFruitSound = new Audio("EatFruitSound.wav");
        gameOverMenuSound = new Audio("GameOverSound.wav");
        levelCompleteMenuSound = new Audio("LevelCompleteMenuSound.wav");
        winSound = new Audio("WinSound.wav");
        runnerMonsterSound = new Audio("RunnerMonsterSound.wav");
        monsterCollisionSound = new Audio("MonsterCollisionSound.wav");
    }
    public Audio getWinSound() {
        return winSound;
    }

    public Audio getRunnerMonsterSound() {
        return runnerMonsterSound;
    }

    public Audio getMonsterCollisionSound() {
        return monsterCollisionSound;
    }

    public Audio getMainMenuMusic() {
        return mainMenuMusic;
    }

    public Audio getLevelMusic() {
        return levelMusic;
    }

    public Audio getLevelCompleteMenuSound() {
        return levelCompleteMenuSound;
    }

    public Audio getGameOverMenuSound() {
        return gameOverMenuSound;
    }

    public Audio getEatFruitSound() {
        return eatFruitSound;
    }

    public Audio getBuildWallSound() {
        return buildWallSound;
    }

    public Audio getBreakWallSound() {
        return breakWallSound;
    }
}
