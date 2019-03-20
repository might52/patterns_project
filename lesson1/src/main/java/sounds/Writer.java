package sounds;

public class Writer {

    private Auditory auditory;
    private String name;

    public Auditory getAuditory() {
        return auditory;
    }

    public void setAuditory(Auditory auditory) {
        this.auditory = auditory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Writer(String name) {
        this.name = name;
    }
    public void write() {
        System.out.println(
                String.format(
                        "Writer name: %s  write the speach. Class name: %s",
                        getName(),
                        Writer.class.getName()
                )
        );
    }
}
