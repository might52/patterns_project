package sounds;

import java.util.List;

public class Auditory {

    private Speaker speaker;
    private List<Writer> writers;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    private boolean isSounded;

    private int number;

    public Speaker getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }

    public List<Writer> getWriters() {
        return writers;
    }

    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }

    public Auditory(int number) {
        this.number = number;
    }

    public void sendSpeach() {
        isSounded = !isSounded;
        if (isSounded) {
            writers.forEach(el -> el.write());
        }
    }

}
