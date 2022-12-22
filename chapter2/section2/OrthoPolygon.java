// 직교 다각형을 표현하는 클래스
public class OrthoPolygon {
    public int n;
    public MyPoint2 [] vertices;

    public OrthoPolygon(int k) {
        // n은 입력된 꼭짓점의 개수
        n = 0;
        // k는 다각형의 꼭짓점의 개수
        vertices = new MyPoint2 [k];
    }

    public void addVertex( int x, int y )
    {
        vertices[n++] = new MyPoint2(x, y);
    }

    // 다각형의 가장 큰 x값을 구하는 함수
    public int maxX()
    {
        int max = vertices[0].x;
        for (int i=0; i<n; i++) {
            if (vertices[i].x > max)
                max = vertices[i].x;
        }
        return max;
    }
    public boolean contains(MyPoint2 p) {
        // 점 P에서 긋는 수평선을 (무한으로 할 필요 없이) 다각형의 가장 큰 x보다 큰 값으로 정해준다.
        OrthoLine arrow = new OrthoLine(p, new MyPoint2( maxX()+1, p.y ));
        int count = 0;
        for (int i=0; i<n; i++) {
            // 마지막 꼭짓점은 처음 꼭짓점과 연결되므로 나머지 연산
            OrthoLine edge = new OrthoLine(vertices[i], vertices[(i+1) % n]);
            // 교차하는지 검사하고 count하기
            if( arrow.intersects(edge))
                count++;
        }
        return (count % 2 == 1);
    }
}
