public class OneDayEvent extends Event{
    public MyDate date;

    public OneDayEvent(String title, MyDate date) {
        super(title);
        this.date = date;
    }

    public boolean isRelevant(MyDate date) {
        return this.date.compareTo(date) == 0;
    }

    public String toString() {
        return title + ", " + date.toString();
    }
}
