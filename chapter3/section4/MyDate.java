public class MyDate {
    public int year;
    public int month;
    public int day;

    public MyDate(int y, int m, int d) {
        year = y;
        month = m;
        day = d;
    }

    // show 날짜 command에서 그 날짜에 걸쳐있는 일정들을 찾기 위해선 비교함수가 필요하다.
    public int compareTo( MyDate other ) {
        // 내 날짜가 먼저일 때
        if (year < other.year || year == other.year && month < other.month
                || year == other.year && month == other.month && day == other.day)
            return -1;
        // 내 날짜가 나중일 때
        else if (year > other.year || year == other.year && month > other.month
                || year == other.year && month == other.month && day > other.day)
            return 1;
        // 날짜가 같을 때
        else
            return 0;
    }
    public String toString() {
        return year + "/" + month + "/" + day;
    }
}
