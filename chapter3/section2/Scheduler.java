/*
    Program
    : 스케쥴러 프로그램

    1) 일회성 이벤트
       - 생일, 식사약속, 회의 등
    2) 기간이 지정된 이벤트
       - 시험기간, 축제기간
    3) 데드라인이 있는 이벤트
       - 시작일은 없고 데드라인이 있는 일
       - 제출기한이 있는 과제, 종료일이 있는 프로젝트 등
    4) 주기적 이벤트
       - 수업시간(3월 초에서 6월 말까지 매주 월, 목 등)

    $ addevent oneday
        when: 2017/1/15
        title: K's birthday
    $ addevent duration
        begin: 2017/1/10
        end: 2017/1/31
        title: Winter Festival
    $ addevent deadline
        until: 2017/2/10
        title: Submitting term paper
    $ addevent oneday
        when: 2017/2/2
        title: Project meeting
    $ list
        K's birthday, 2017/1/15
        Winter Festival, 2017/1/10 ~ 2017/1/31
        Submitting term paper, 2017/2/10
        Project meeting, 2018/2/2
    $ show 2017/1/15
        K's birthday, 2017/1/15
        Winter Festival, 2017/1/10 ~ 2017/1/31
        Submitting term paper, 2017/2/10
    $ exit
 */

/*
    OneDayEvent, DurationEvent, DeadlinedEvent 는 서로 IS-A 관계가 아니다.
    하지만, title, date 와 같은 공통점이 있다. 이 공통점들을 뽑아내 한 클래스를 만들고,
    OneDayEvent, DurationEvent, DeadlinedEvent 가 그 클래스를 상속받는 클래스로 만들어 프로그래밍한다.

    다형성으로 서로 다른 type의 데이터들을 하나의 배열에 저장할 수 있다.
    (Generic Programming의 일종)
 */
import java.util.Scanner;

public class Scheduler {
    private int capacity = 10;
    public Event [] events = new Event [100];
    public int n = 0;
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

            else if(command.equals("exit")) {
                break;
            }
        }
        kb.close();
    }

    private void handleShow() {
        String dateString = kb.next();
        MyDate theDate = parseDateString(dateString);
        for(int i=0; i<n; i++) {
            if(events[i].isRelevant(theDate))
                System.out.println(events[i].toString());
        }
    }

    private void handleList() {
        for (int i=0; i<n; i++)
            System.out.println("    " + events[i].toString());
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


    // 다형성 적용된 부분. OneDayEvent/DurationEvent/DeadlinedEvent type을 Event type의 ev에 저장.
    private void addEvent(Event ev) {
        if(n>capacity)
            reallocate();
        events[n++] = ev;
    }

    // 배열 재할당(Array Reallocation)
    private void reallocate() {
        Event [] tmp = new Event[capacity * 2];
        for(int i=0; i<n; i++)
            tmp[i] = events[i];
        events = tmp;
        capacity *= 2;
    }

    private MyDate parseDateString(String dateString) {
          /*
            Splitting(Tokenizing) a String
            1) 구분자(delimiter)를 기준으로 split 방법
            ...
         */
        String [] tokens = dateString.split("/");
        /*
            regular expression

            1) meta character
            - []: 공백 문자
            - \s: 공백 문자를 포함한 모든 white space
            - .
            ...

            2) escape character
            - \
            - 메타 문자를 escape 해준다.
            - 예시) String [] tokens = str.split("\\.");
         */

        // tokens[0]은 "2017" 문자열로 정수형으로 바꿔주는 과정이다.
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
