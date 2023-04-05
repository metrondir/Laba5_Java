import java.util.Scanner;
public class  Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть ширину основи прямокутного паралелепіпеда в см:");
        double c = scan.nextDouble();
        System.out.println("Введіть довжину прямокутного паралелепіпеда в см:");
        double d = scan.nextDouble();
        System.out.println("Введіть висоту прямокутного паралелепіпеда в см:");
        double h = scan.nextDouble();
        System.out.println("Введіть довжину ребра куба см:");
        double a = scan.nextDouble();

        RectSolid rectsolid,rectsolid_1,rectsolid_2;
        rectsolid = new RectSolid(c, d,h);
        rectsolid_1=new RectSolid(4,5,7);
        rectsolid_2=new RectSolid();
        Cube cube,cube_1,cube_2;
        cube = new Cube(a);
        cube_1=new Cube(8);
        cube_2=new Cube();

        rectsolid_2.setC(scan.nextDouble());
        rectsolid_2.setD(scan.nextDouble());
        rectsolid_2.setH(scan.nextDouble());

        cube_2.setA(scan.nextDouble());


        System.out.println("Volume of RectSolid: " + rectsolid_1.Volume());
        System.out.println("Volume of RectSolid: " + rectsolid_1.Perimeter());
        System.out.println("Volume of RectSolid: " + rectsolid_1.Square());
        System.out.println("Volume of RectSolid: " + rectsolid_1.Diagonal());

        System.out.println("Volume of RectSolid: " + rectsolid_2.Volume());
        System.out.println("Volume of RectSolid: " + rectsolid_2.Perimeter());
        System.out.println("Volume of RectSolid: " + rectsolid_2.Square());
        System.out.println("Volume of RectSolid: " + rectsolid_2.Diagonal());



        System.out.println("Volume of RectSolid: " + rectsolid.Volume());
        RectSolid.draw();
        System.out.println("Perimeter of RectSolid: " + rectsolid.Perimeter());
        System.out.println("Square of RectSolid: " + rectsolid.Square());
        System.out.println("Diagonal of RectSolid: " + rectsolid.Diagonal());

        System.out.println("Volume of Cube: " + cube_1.Volume());
        System.out.println("Perimeter of RectSolid: " + cube_1.Perimeter());
        System.out.println("Square of RectSolid: " + cube_1.Square());
        System.out.println("Diagonal of RectSolid: " + cube_1.Diagonal());
        System.out.println("Volume of Cube: " + cube_1.Volume());

        System.out.println("Volume of Cube: " + cube_2.Volume());
        System.out.println("Perimeter of RectSolid: " + cube_2.Perimeter());
        System.out.println("Square of RectSolid: " + cube_2.Square());
        System.out.println("Diagonal of RectSolid: " + cube_2.Diagonal());

        Cube.draw();
        System.out.println("Perimeter of RectSolid: " + cube.Perimeter());
        System.out.println("Square of RectSolid: " + cube.Square());
        System.out.println("Diagonal of RectSolid: " + cube.Diagonal());

        System.out.println(cube.getName());
        System.out.println(cube_1.getSurfaceArea());
        System.out.println("---------------------------------------------------------");
        System.out.println(rectsolid.getSurfaceArea());
        System.out.println(rectsolid_1.getName());
        System.out.println(cube.ObjectEquals(cube_1));
    }
}

abstract class Solid  {
    protected boolean bulge_sign;
    abstract double Volume();
    abstract double Perimeter();
    abstract double Square();
    abstract double Diagonal();
}
class RectSolid extends Solid  implements ShapeInterface  {
    private double C;
    private double D;
    private double H;
    static public double Radius_inscribed_circle;

    {
        C=12;
        D=4;
        H=2;
        Radius_inscribed_circle=2;
    }
    public RectSolid()
    {
        C+=5;
        D-=4;
        H-=2;
    }
    public RectSolid(double C, double D,double H) {
        this.C = C;
        this.D =D;
        this.H = H;
    }
    public double getC()
    {
        return C;
    }
    void setC(double value)
    {
        C=value;
    }
    double getD()
    {
        return D;
    }
    void setD(double value)
    {
        D=value;
    }
    double getH()
    {
        return H;
    }
    void setH(double value)
    {
        H=value;
    }


    static void draw(){
        System.out.println("Виклик методу draw()класу RectSolid");
    }
    @Override
    double Perimeter(){
        return 4*(D+C+H);
    }
    @Override
    double Square()
    {
        return 2*(C*D+D*H+C*H);
    }
    @Override
    double Diagonal()
    {
        return Math.sqrt(C*C+D*D+H*H);
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
    @Override
    public double getSurfaceArea() {
        return 2*C*D+C*H+D*H;
    }
    @Override
    double Volume() {
        return C*D*H;
    }
}

class Cube extends Solid  implements ShapeInterface  {
    private double A;
    double getA()
    {
        return A;
    }
    Cube()
    {
        A=12;
    }
    public Cube(double A) {
        this.A = A;
    }

    void setA(double value)
    {
        A=value;
    }
    static void draw()
    {
        System.out.println("Виклик методу draw()класу Cube");
    }
    @Override
    double Perimeter(){
        return 12*A;
    }
    @Override
    double Square()
    {
        return 6*(A*A);
    }
    @Override
    double Diagonal()
    {
        return Math.sqrt(3)*A;
    }

    boolean ObjectEquals(Cube obj)
    {
        if (A==obj.A)
        {
            bulge_sign=true;
        }
        return bulge_sign;
    }


    @Override
    double Volume() {
        return A*A*A;
    }
    @Override
    public String getName() {
        return "Cube";
    }
    @Override
    public double getSurfaceArea() {
        return 6*A*A;
    }

}
interface ShapeInterface {
    double getSurfaceArea();

    String getName();
}