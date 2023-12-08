package badIceCream.utils;

public class AudioController {
    private final Audio audio;

    public AudioController(Audio audio){
        this.audio = audio;
    }
    public void play() {
        audio.play();
    }
    public void stop() {
        audio.stop();
    }
}
