public class Time {
    private int hours;
    private int minutes;
    private int seconds;

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String info() {
        return convertInt(hours) + ":" +
                convertInt(minutes) + ":" +
                convertInt(seconds);
    }

    public void tick() {
        seconds++;
        fixTime();
    }

    public void add(String newTime) {
        String[] splitTime = newTime.split(":");

        hours += Integer.parseInt(splitTime[0]);
        minutes += Integer.parseInt(splitTime[1]);
        seconds += Integer.parseInt(splitTime[2]);

        fixTime();
    }

    public void add(Time newTime) {
        add(newTime.info());
    }

    private void fixTime() {
        minutes += seconds / 60;
        seconds %= 60;

        hours += minutes / 60;
        minutes %= 60;

        hours %= 24;
    }

    private String convertInt(int integer) {
        String string = "";

        if (integer < 10) {
            string += 0;
        }

        string += integer;

        return string;
    }
}
