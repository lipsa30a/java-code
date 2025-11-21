import java.util.Scanner;

class Square {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    public double perimeter() {
        return 4 * side;
    }
}

 class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose shape: 1. Square  2. Circle  3. Triangle");
        System.out.println("1"); // user selects Square
        System.out.print("Enter side of square: ");
        double s = sc.nextDouble();

        Square sq = new Square(s);
        System.out.println("Area: " + sq.area());
        System.out.println("Perimeter: " + sq.perimeter());

        sc.close();
    }
}
