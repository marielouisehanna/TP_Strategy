public class HomeTheaterClient {
    public static void main(String[] args) {
        // Creating subsystems (components of the home theater)
        Amplifier amp = new Amplifier("Top-O-Line Amplifier");
        Tuner tuner = new Tuner("Top-O-Line AM/FM Tuner", amp);
        DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
        CdPlayer cd = new CdPlayer("Top-O-Line CD Player", amp);
        Projector projector = new Projector("Top-O-Line Projector", dvd);
        TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
        Screen screen = new Screen("Theater Screen");
        PopcornPopper popper = new PopcornPopper("Popcorn Popper");

        // Creating the facade
        HomeTheaterFacade homeTheater = new HomeTheaterFacade(
                amp, tuner, dvd, cd, projector, screen, lights, popper
        );

        // Client using the facade to control the home theater
        homeTheater.watchMovie("Raiders of the Lost Ark");
        homeTheater.endMovie();

        homeTheater.listenToCd("Greatest Hits");
        homeTheater.endCd();

        homeTheater.listenToRadio(101.1);
        homeTheater.endRadio();
    }
}

/* Facade Pattern Example */
class HomeTheaterFacade {
    Amplifier amp;
    Tuner tuner;
    DvdPlayer dvd;
    CdPlayer cd;
    Projector projector;
    TheaterLights lights;
    Screen screen;
    PopcornPopper popper;

    public HomeTheaterFacade(
            Amplifier amp, Tuner tuner, DvdPlayer dvd, CdPlayer cd,
            Projector projector, Screen screen, TheaterLights lights, PopcornPopper popper) {
        this.amp = amp;
        this.tuner = tuner;
        this.dvd = dvd;
        this.cd = cd;
        this.projector = projector;
        this.screen = screen;
        this.lights = lights;
        this.popper = popper;
    }

    public void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        popper.on();
        popper.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvd);
        amp.setSurroundSound();
        amp.setVolume(5);
        dvd.on();
        dvd.play(movie);
    }

    public void endMovie() {
        System.out.println("Shutting movie theater down...");
        popper.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvd.stop();
        dvd.eject();
        dvd.off();
    }

    public void listenToCd(String cdTitle) {
        System.out.println("Get ready for an audiophile experience...");
        lights.on();
        amp.on();
        amp.setVolume(5);
        amp.setCd(cd);
        amp.setStereoSound();
        cd.on();
        cd.play(cdTitle);
    }

    public void endCd() {
        System.out.println("Shutting down CD...");
        amp.off();
        amp.setCd(cd);
        cd.eject();
        cd.off();
    }

    public void listenToRadio(double frequency) {
        System.out.println("Tuning in the airwaves...");
        tuner.on();
        tuner.setFrequency(frequency);
        amp.on();
        amp.setVolume(5);
        amp.setTuner(tuner);
    }

    public void endRadio() {
        System.out.println("Shutting down the tuner...");
        tuner.off();
        amp.off();
    }
}

// Other component classes

class Amplifier {
    String description;
    Tuner tuner;
    DvdPlayer dvd;
    CdPlayer cd;

    public Amplifier(String description) {
        this.description = description;
    }

    public void on() { System.out.println(description + " on"); }
    public void off() { System.out.println(description + " off"); }
    public void setDvd(DvdPlayer dvd) { this.dvd = dvd; System.out.println(description + " setting DVD player to " + dvd); }
    public void setCd(CdPlayer cd) { this.cd = cd; System.out.println(description + " setting CD player to " + cd); }
    public void setTuner(Tuner tuner) { this.tuner = tuner; System.out.println(description + " setting tuner to " + tuner); }
    public void setSurroundSound() { System.out.println(description + " surround sound on (5 speakers, 1 subwoofer)"); }
    public void setStereoSound() { System.out.println(description + " stereo mode on"); }
    public void setVolume(int level) { System.out.println(description + " setting volume to " + level); }
}

// Other subsystem classes follow a similar structure with relevant methods

class Tuner {
    String description;
    Amplifier amplifier;
    public Tuner(String description, Amplifier amplifier) {
        this.description = description;
        this.amplifier = amplifier;
    }
    public void on() { System.out.println(description + " on"); }
    public void off() { System.out.println(description + " off"); }
    public void setFrequency(double frequency) { System.out.println(description + " setting frequency to " + frequency); }
}

class DvdPlayer {
    String description;
    Amplifier amplifier;
    public DvdPlayer(String description, Amplifier amplifier) {
        this.description = description;
        this.amplifier = amplifier;
    }
    public void on() { System.out.println(description + " on"); }
    public void off() { System.out.println(description + " off"); }
    public void play(String movie) { System.out.println(description + " playing \"" + movie + "\""); }
    public void stop() { System.out.println(description + " stopped"); }
    public void eject() { System.out.println(description + " eject"); }
}

class CdPlayer {
    String description;
    Amplifier amplifier;
    public CdPlayer(String description, Amplifier amplifier) {
        this.description = description;
        this.amplifier = amplifier;
    }
    public void on() { System.out.println(description + " on"); }
    public void off() { System.out.println(description + " off"); }
    public void play(String title) { System.out.println(description + " playing \"" + title + "\""); }
    public void eject() { System.out.println(description + " eject"); }
}

class Projector {
    String description;
    DvdPlayer dvdPlayer;
    public Projector(String description, DvdPlayer dvdPlayer) {
        this.description = description;
        this.dvdPlayer = dvdPlayer;
    }
    public void on() { System.out.println(description + " on"); }
    public void off() { System.out.println(description + " off"); }
    public void wideScreenMode() { System.out.println(description + " in widescreen mode (16x9 aspect ratio)"); }
}

class TheaterLights {
    String description;
    public TheaterLights(String description) {
        this.description = description;
    }
    public void on() { System.out.println(description + " on"); }
    public void off() { System.out.println(description + " off"); }
    public void dim(int level) { System.out.println(description + " dimming to " + level + "%"); }
}

class Screen {
    String description;
    public Screen(String description) {
        this.description = description;
    }
    public void up() { System.out.println(description + " going up"); }
    public void down() { System.out.println(description + " going down"); }
}

class PopcornPopper {
    String description;
    public PopcornPopper(String description) {
        this.description = description;
    }
    public void on() { System.out.println(description + " on"); }
    public void off() { System.out.println(description + " off"); }
    public void pop() { System.out.println(description + " popping popcorn!"); }
}
