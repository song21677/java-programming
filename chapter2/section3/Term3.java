public class Term3 {
    private int coef;
    private int expo;

    public Term3(int c, int e) {
        coef = c;
        expo = e;
    }

    public int getExpo()
    {
        return expo;
    }

    public int calcTerm(int x) {
        return (int) (coef * Math.pow(x, expo));
    }

    public void printTerm() {
        System.out.print(coef + "x^" + expo);
    }

    public int getCoef() {  // getter, accessor
        return coef;
    }

    public void setCoef(int coef) { // setter, mutator
        this.coef = coef;
    }
}
