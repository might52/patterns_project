package sounds;

public class Speaker {
    private Auditory auditory;

    public Auditory getAuditory() {
        return auditory;
    }

    public void setAuditory(Auditory auditory) {
        this.auditory = auditory;
    }

    public Speaker() {
    }

    public void makeSound() {
        System.out.println(
                String.format(
                        "Maksing sound by Speaker Class anme: %s",
                        Speaker.class.getName()
                )
        );
        auditory.sendSpeach();
    }
}
