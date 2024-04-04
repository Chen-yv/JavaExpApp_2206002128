package JavaExpApp_2206002128;
import java.util.Scanner;

public class Exp02_Gry {
    Scanner scan = new Scanner(System.in);
    public void menu_Gry(){
        while (true) {
            System.out.println("--------------------");
            System.out.println("-- 矩形类计算——1  --");
            System.out.println("-- 三角类计算——2  --");
            System.out.println("--  点类计算 ——3  --");
            System.out.println("--成绩管理系统——4  --");
            System.out.println("--    退出   ——0   --");
            System.out.print("请输入指令：");

            Exp02Init Exp02 = new Exp02Init();
            //初始化管理员
            Exp02ScoreManage_Gry scoreManage = new Exp02ScoreManage_Gry(new Exp02Admin_Gry("郭人源", "M001", 3, 5));
            int choise = scan.nextInt();
            System.out.println("--------------------");
            switch (choise) {
                case 0:
                    System.out.println("实验二已退出");
                    return;
                case 1:Exp02.RectangleInit();
                    break;
                case 2:Exp02.TriangleInit();
                    break;
                case 3:Exp02.PointInit_Gry();
                    break;
                    case 4:
                    scoreManage.menu_Gry();
                    break;
                default:
                    System.out.println("输入有误，请重新输入");
            }
        }
    }
}

class Exp02Init{
    Scanner scan = new Scanner(System.in);
    //初始化长方形
    public void RectangleInit() {
        int choise;
        System.out.print("请输入长方形的高：");
        double height = scan.nextDouble();
        System.out.print("请输入长方形的宽：");
        double width = scan.nextDouble();

        Exp02Rectangle_Gry Rectangle = new Exp02Rectangle_Gry(height, width);
        while (Rectangle.state) {
            System.out.println("--------------------");
            System.out.println("计算面积——1");
            System.out.println("计算周长——2");
            System.out.println("输出形状——3");
            System.out.println("退出——0");
            System.out.print("请输入指令：");
            choise = scan.nextInt();
            System.out.println("--------------------");
            switch (choise){
                case 0:return;
                case 1:System.out.println("面积："+Rectangle.getArea_Gry());break;
                case 2:System.out.println("周长；"+ Rectangle.getPerimerter_Gry());break;
                case 3:Rectangle.draw_Gry();break;
                default:System.out.println("输入错误！");break;
            }
        }
    }
    //初始化三角形
    public void TriangleInit(){
        int choise;
        System.out.print("请输入三角形的第一条边：");
        double side1 = scan.nextDouble();
        System.out.print("请输入三角形的第二条边：");
        double side2 = scan.nextDouble();
        System.out.print("请输入三角形的第三条边：");
        double side3 = scan.nextDouble();

        Exp02Triangle_Gry Triangle = new Exp02Triangle_Gry(side1, side2, side3);
        while (true) {
            System.out.println("--------------------");
            System.out.println("计算面积——1");
            System.out.println("退出——0");
            System.out.print("请输入指令：");
            choise = scan.nextInt();
            System.out.println("--------------------");
            switch (choise){
                case 0:return;
                case 1:System.out.println("面积："+Triangle.TriangleArea_Gry());break;
                default:System.out.println("输入错误！");break;
            }
        }
    }
    public void PointInit_Gry(){
        int choise;
        System.out.print("请输入第一个点的x坐标：");
        int x1 = scan.nextInt();
        System.out.print("请输入第一个点的y坐标：");
        int y1 = scan.nextInt();
        System.out.print("请输入第二个点的x坐标：");
        int x2 = scan.nextInt();
        System.out.print("请输入第二个点y的坐标：");
        int y2 = scan.nextInt();

        Exp02Point_Gry Point_gry = new Exp02Point_Gry(x1, y1, x2, y2);
        while (true) {
            System.out.println("--------------------");
            System.out.println("计算距离——1");
            System.out.println("绘制图形——2");
            System.out.println("退出——0");
            System.out.print("请输入指令：");
            choise = scan.nextInt();
            System.out.println("--------------------");
            switch (choise){
                case 0:return;
                case 1:System.out.println("距离："+Point_gry.distance_Gry());
                    break;
                case 2:Point_gry.draw_Gry();
                    break;
                default:System.out.println("输入错误！");
                    break;
            }
        }
    }

}

class Exp02Rectangle_Gry{
    private double height;
    private  double width;
    public boolean state = true;

    public Exp02Rectangle_Gry(double height, double width){
        if (height > 0 && height < 30 && width > 0 && width < 30) {
            this.height = height;
            this.width = width;
        }
        else {
            System.out.println("输入错误，长宽必须在0~30之间");
            state = false;
        }
    }

//    返回长方形面积1
    public double getArea_Gry(){
        return height * width;
    }
//    返回周长2
    public double getPerimerter_Gry(){
        return 2 * (height + width);
    }
//    输出形状3
    public void draw_Gry(){
        for(int i = 0; i < (int)height; i ++){
            for (int j = 0; j < (int)width; j ++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}

class Exp02Triangle_Gry{
    private double side1_Gry;
    private double side2_Gry;
    private double side3_Gry;

    public Exp02Triangle_Gry(double side1, double side2, double side3){
        if (side1 + side2 <= side3 || side2 + side3 <= side1 || side3 + side1 <= side2){
            System.out.println("不能构成三角形，将自动构造最小等边三角形");
            side1 = 1;
            side2 = 1;
            side3 = 1;
        }else System.out.println("构造成功！");
        this.side1_Gry = side1;
        this.side2_Gry = side2;
        this.side3_Gry = side3;
    }
    public double TriangleArea_Gry(){
        double p = (side1_Gry + side2_Gry + side3_Gry) / 2;
        return StrictMath.sqrt(p*(p - side1_Gry) * ( p - side2_Gry) * (p - side3_Gry));
    }
}

class Exp02Point_Gry{
    private int x1_Gry;
    private int y1_Gry;
    private int x2_Gry;
    private int y2_Gry;
    public Exp02Point_Gry(){
        x1_Gry = 0;
        y1_Gry = 0;
        x2_Gry = 0;
        y2_Gry = 0;
    }
    public Exp02Point_Gry(int x1, int y1, int x2, int y2){
        this.y1_Gry = y1;
        this.x1_Gry = x1;
        this.y2_Gry = y2;
        this.x2_Gry = x2;
    }

    public double distance_Gry(){
        int x = Math.abs(x1_Gry - x2_Gry);
        int y = Math.abs(y1_Gry - y2_Gry);
        return StrictMath.sqrt(x * x + y * y);
    }

    public void draw_Gry(){
        int side = (int)distance_Gry();
        for(int i = 0; i < side; i ++){
            for (int j = 0; j < side; j ++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}