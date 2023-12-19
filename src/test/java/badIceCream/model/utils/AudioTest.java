package badIceCream.model.utils;

import badIceCream.utils.Audio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AudioTest {
    @Mock
    private Clip sound;
    private Audio audio;
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        audio = new Audio(sound);
    }
    @Test
    public void play() {
        audio.play();
        verify(sound, times(1)).setMicrosecondPosition(0);
        verify(sound, times(1)).start();
        verify(sound, times(1)).loop(Clip.LOOP_CONTINUOUSLY);
    }
    @Test
    public void playOnce() {
        audio.playOnce();
        verify(sound, times(1)).setMicrosecondPosition(0);
        verify(sound, times(1)).start();
    }
    @Test
    public void stop() {
        audio.stop();
        verify(sound,times(1)).stop();
    }
    @Test
    public void loadMusicNull() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        assertNull(Audio.loadMusic("test.wav"));
    }
    @Test
    void loadMusicNotNull() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        assertNotNull(Audio.loadMusic("BreakWallSound.wav"));
        assertNotNull(Audio.loadMusic("BuildWallSound.wav"));
        assertNotNull(Audio.loadMusic("GameOverMenuSound.wav"));
        assertNotNull(Audio.loadMusic("LevelCompleteMenuSound.wav"));
        assertNotNull(Audio.loadMusic("LevelMusic.wav"));
        assertNotNull(Audio.loadMusic("MainMenuMusic.wav"));
        assertNotNull(Audio.loadMusic("RunnerMonsterSound.wav"));
    }
}
