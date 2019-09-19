public class Test {
    public static void main(String[] args) {
        SquareRoot squareroot1 = new SquareRoot() {
            @Override
            public double findSquareRoot(int a) {
                return Math.sqrt(a);
            }
        };
        double res = squareroot1.findSquareRoot(9);
        System.out.println(res);

        SquareRoot squareRoot2 = (a) -> (Math.sqrt(a));
        double res2 = squareRoot2.findSquareRoot(16);
        System.out.println(res2);

        squareroot1.display();
        squareRoot2.anotherDisplay();
        SquareRoot.show();
    }
}
