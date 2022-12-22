public class OrthoLine {
    public MyPoint2 u;
    public MyPoint2 v;

    public OrthoLine( MyPoint2 p, MyPoint2 q )
    {
        u = p;
        v = q;
        // u가 더 작은 쪽에 위치하도록 만들어준다.
        // 수직선일 땐 위쪽, 수평선일 땐 왼쪽
        if( p.x > q.x || p.x == q.x && p.y > q.y)
            swap();
    }

    public void swap() {
        MyPoint2 tmp = u;
        u = v;
        v = tmp;
    }
    public OrthoLine( int x1, int y1, int x2, int y2 )
    {
        u = new MyPoint2(x1, y1);
        v = new MyPoint2(x2, y2);
    }

    // 자신이 수직 성분인지 확인하는 함수
    public boolean isVertical()
    {
        return u.x == v.x;
    }

    // 한 선분이 자기 자신과 교차하는지 확인하는 함수
    public boolean intersects( OrthoLine other )
    {
        // 하난 수평선, 다른 하난 수직선이어야 하고
        // 다른 선분이 수직선일 땐 양끝 점이 자신의 위쪽, 아래쪽
        // 수평선일 땐 양끝 점이 자신의 왼쪽, 오른쪽에
        // 하나씩 존재해야 교차가 성립한다.
        if ( isVertical() && !other.isVertical()) {
            return( other.u.x < u.x && other.v.x > u.x && u.y < other.u.y && v.y > other.u.y);
        }
        else if( !isVertical() && other.isVertical()) {
            return (other.u.y < u.y && other.v.y > u.y && u.x < other.u.x && v.x > other.u.x);
        }
        else
            return false;
    }
}
