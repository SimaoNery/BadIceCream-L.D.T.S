package badIceCream.utils;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

import java.io.File;


public class Audio {
    private Clip sound;

    public boolean isPlaying(){
        return sound.isRunning();
    }

    public Audio(String sound) {
        this.sound = loadMusic(sound);
    }

    public Clip loadMusic(String sound) throws NullPointerException{
        try {
            String rootPath = new File(System.getProperty("user.dir")).getPath();
            String soundPath = rootPath + "/src/main/resources/Music/" + sound;
            File soundFile = new File(soundPath);
            AudioInputStream input = AudioSystem.getAudioInputStream(soundFile);
            Clip soundClip = AudioSystem.getClip();
            soundClip.open(input);

            FloatControl volumeController = (FloatControl) soundClip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeController.setValue(-20.0f); //sound volume

            return soundClip;
        } catch (Exception e) {
            System.out.println("Couldn't get the sound");
        }
        return null;
    }

    public void setSound(Clip sound) {
        this.sound = sound;
    }
    public Clip getSound() {return sound;}
    public void play() {
        sound.setMicrosecondPosition(0);
        sound.start();
        sound.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void playOnce() {
        sound.setMicrosecondPosition(0);
        sound.start();
    }

    public void stop() {
        sound.stop();
    }
}
