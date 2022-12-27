import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Scheduler {
    // private int capacity = 10;
    public ArrayList<Event> events = new ArrayList<>();
    // public Event [] events = new Event [100];
    // public int n = 0;
    private Scanner kb;
    public void processCommand() {
        kb = new Scanner(System.in);
        while(true) {
            System.out.print("$ ");
            String command = kb.next();

            if(command.equals("addevent")) {
                String type = kb.next();

                if(type.equalsIgnoreCase("oneday")) {
                    handleAddOneDayEvent();
                }
                else if(type.equalsIgnoreCase("duration")) {
                    handleAddDurationEvent();
                }
                else if(type.equalsIgnoreCase("deadline")) {
                    handleDeadlinedEvent();
                }
            }

            else if(command.equals("list")) {
                handleList();
            }

            else if(command.equals("show")) {
                handleShow();
            }

            else if(command.equals("sort")) {
                Collections.sort(events);
            }

            else if(command.equals("exit")) {
                break;
            }
        }
        kb.close();
    }

    private void handleShow() {
        String dateString = kb.next();
        MyDate theDate = parseDateString(dateString);
        for (int i=0; i<events.size(); i++) {
            if(events.get(i).isRelevant(theDate))
                System.out.println(events.get(i).toString());
        }
    }

    private void handleList() {
//        for (int i=0; i<events.size(); i++)
        for(Event ev : events)  // enhanced for loop
            System.out.println("    " + ev.toString());
    }

    private void handleDeadlinedEvent() {
        System.out.print("  until: ");
        String datestring = kb.next();
        System.out.print("  title: ");
        String title = kb.next();

        MyDate d = parseDateString(datestring);
        DeadlinedEvent ev = new DeadlinedEvent(title, d);
        addEvent(ev);
    }

    private void handleAddDurationEvent() {
        System.out.print("  begin: ");
        String begin = kb.next();
        System.out.print("  end: ");
        String end = kb.next();
        System.out.print("  title: ");
        String title = kb.next();

        MyDate b = parseDateString(begin);
        MyDate e = parseDateString(end);

        DurationEvent ev = new DurationEvent(title, b, e);
        addEvent(ev);
    }

    private void handleAddOneDayEvent() {
        System.out.print("  when: ");
        String dateString = kb.next();
        System.out.print("  title: ");
        String title = kb.next();

        MyDate date = parseDateString(dateString);
        OneDayEvent ev = new OneDayEvent(title, date);
        // System.out.println(ev.toString());
        addEvent(ev);
    }

    private void addEvent(Event ev) {
//        if(n>capacity)
//            reallocate();
        events.add(ev);
    }

    // 배열 재할당(Array Reallocation)
//    private void reallocate() {
//        Event [] tmp = new Event[capacity * 2];
//        for(int i=0; i<n; i++)
//            tmp[i] = events[i];
//        events = tmp;
//        capacity *= 2;
//    }

    private MyDate parseDateString(String dateString) {
        String [] tokens = dateString.split("/");

        int year = Integer.parseInt(tokens[0]);
        int month = Integer.parseInt(tokens[1]);
        int day = Integer.parseInt(tokens[2]);

        MyDate d = new MyDate(year, month, day);
        return d;
    }

    public static void main(String[] args) {
        Scheduler app = new Scheduler();
        app.processCommand();
    }
}
