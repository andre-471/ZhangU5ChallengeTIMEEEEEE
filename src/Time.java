/**
 * time class
 * it like calculates time in military hour and keeps track of it
 * <p>
 * (i think)
 *
 * @author Andrew Zhang
 */

public class Time {
    /** integer time in hours */
    private int hours;
    /** integer time in minutes */
    private int minutes;
    /** integer time in seconds */
    private int seconds;

    /**
     * instantiates a Time object
     * @param hours time in seconds
     * @param minutes time in minutes
     * @param seconds time in seconds
     */
    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    /**
     * returns the time in string format HH:MM:SS with leading zeros
     * @return a string of the time
     */
    public String info() {
        return convertInt(hours) + ":" +
                convertInt(minutes) + ":" +
                convertInt(seconds);
    }

    /**
     * adds a second to the time we are keeping track of
     */
    public void tick() {
        seconds++;
        fixTime();
    }

    /**
     * adds another time with the object's current time
     * <p>
     * PRECONDITION: newTime is in format HH:MM:SS
     * @param newTime another time in string
     */
    public void add(String newTime) {
        String[] splitTime = newTime.split(":");

        hours += Integer.parseInt(splitTime[0]);
        minutes += Integer.parseInt(splitTime[1]);
        seconds += Integer.parseInt(splitTime[2]);

        fixTime();
    }

    /**
     * adds another time with the object's current time
     * <p>
     * PRECONDITION: newTime is not null and is a Time object
     * @param newTime another Time object
     */
    public void add(Time newTime) {
        add(newTime.info());
    }


    /**
     * fixes time in case time is incorrect (EX: 25:67:90)
     */
    private void fixTime() {
        minutes += seconds / 60;
        seconds %= 60;

        hours += minutes / 60;
        minutes %= 60;

        hours %= 24;
    }

    /**
     * converts an integer into a string with a leading zero
     * @param integer any integer
     * @return a string with a leading zero
     */
    private String convertInt(int integer) {
        String string = "";

        if (integer < 10) {
            string += 0;
        }

        string += integer;

        return string;
    }
}
