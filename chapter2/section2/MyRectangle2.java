/*
    직사각형의 표현 방법을
    왼쪽-위쪽 꼭짓점의 좌표, 너비, 높이에서
    왼쪽-위쪽 꼭짓점의 좌표, 오른쪽-아래쪽 꼭짓점의 좌표로 바꾼다 했을 때,
    MyRectangle2 클래스를 제외한 클래스들은 수정할 필요가 없다.

    => 관련된 데이터와 함수들을 한 클래스에 모아놓아
       응집도는 높아지고 다른 클래스에 의존하는 결합도는 낮아졌기 때문이다.
 */
public class MyRectangle2 {
    public MyPoint2 lu;
    public int width;
    public int height;

    public MyRectangle2(int x, int y, int w, int h) {
        lu = new MyPoint2(x, y);
        width = w;
        height = h;
    }

    public MyRectangle2(MyPoint2 p, int w, int h) {
        lu = p;
        width = w;
        height = h;
    }

    public int calcArea() {
        return width * height;
    }

    public String toString()
    {
        return "(" + lu.x + " " + lu.y + ")" + width + " " + height;
    }
}
