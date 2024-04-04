package JavaExpApp_2206002128;

import java.util.Scanner;

import static java.lang.Math.sin;
public class Exp01_Gry {
    Scanner sc = new Scanner(System.in);

    //    1、控制台菜单
    public void menu_Gry() {


        while (true) {
            System.out.println("------------------------------");
            System.out.println("---   结束     --- 0");
            System.out.println("--- 面积和周长  --- 1");
            System.out.println("--- 成绩和等级  --- 2");
            System.out.println("---  求近似值   --- 3");
            System.out.println("---  公式计算   --- 4");
            System.out.println("------------------------------");
            System.out.print("请输入选项：");


            int choise = sc.nextInt();
            System.out.println("------------------------------\n");
            switch (choise) {
                case 0:
                    System.out.println("实验一已退出！");
                    System.out.println("------------------------------");
                    return;
                case 1:
                    arePerimeter_Gry();
                    break;
                case 2:
                    grade_Gry();
                    break;
                case 3:
                    approximate_Gry();
                    break;
                case 4:
                    double t = sc.nextDouble();
                    System.out.println("if计算的结果是" + formulaIF_x(t));
                    System.out.println("switch计算的结果是" + formulaSwitch_x((int) t));
                    break;
                default:
                    System.out.println("输入错误，请重新输入：\n");
                    break;
            }
            System.out.println("\n");
        }
    }


    //    2、面积和周长
    void arePerimeter_Gry() {
        System.out.print("请输入side_1:");
        int side_1 = sc.nextInt();
        System.out.print("请输入side_2:");
        int side_2 = sc.nextInt();

        if ((side_1 > 0 && side_1 <= 30) || (side_2 > 0 && side_2 <= 30)) {
            if (side_1 > 0 && side_1 <= 30 && side_2 > 0 && side_2 <= 30) {
                System.out.println("矩形面积是：" + side_1 * side_2);
                System.out.println("矩形周长是：" + (side_1 + side_2) * 2);
            } else if (side_1 > 0 && side_1 <= 30) {
                System.out.println("side_2圆的面积是:" + 3.14 * side_2 * side_2);
                System.out.println("side_1圆的周长是:" + 2 * 3.14 * side_1);
            } else if (side_2 > 0 && side_2 <= 30) {
                System.out.println("side_2圆的面积是:" + 3.14 * side_2 * side_2);
                System.out.println("side_2圆的周长是:" + 2 * 3.14 * side_2);
            } else {
                System.out.println("第一个if出错");
            }
        } else if ((side_1 <= 0 || side_1 > 30) && (side_2 <= 0 || side_2 > 30)) {
            System.out.println("输入数据无效");
        } else {
            System.out.println("其他错误");
        }
    }

    //    3、成绩和等级
    void grade_Gry() {
        System.out.println("请依次输入Java、数据库、英语的成绩：");
        int Grade_Java = sc.nextInt();
        int Grade_DataBase = sc.nextInt();
        int Grade_English = sc.nextInt();

        System.out.println("科目\t 分数\t 等级");

        System.out.println("Java：\t" + Grade_Java + "\t" + Grade_return(Grade_Java));
        System.out.println("数据库：\t" + Grade_DataBase + "\t" + Grade_return(Grade_DataBase));
        System.out.println("英语：\t" + Grade_English + "\t" + Grade_return(Grade_English));
    }

    String Grade_return(int score) {
        String grade;
        if (score >= 90) {
            grade = "优秀";
        } else if (score >= 80) {
            grade = "良";
        } else if (score >= 70) {
            grade = "中";
        } else if (score >= 60) {
            grade = "及格";
        } else {
            grade = "不及格";
        }
        return grade;
    }

    //    4、求近似值
    void approximate_Gry() {
        double Value_E = 1;
        int t = 1;
        double Sum = 1;
        while (1 / Sum > 0.00001) {
            Sum = 1;
            for (int i = 1; i <= t; i++) {
                Sum = Sum * i;
            }
            t++;
            Value_E += 1 / Sum;
        }
        System.out.println("e = " + Value_E);
    }

    //    5、公式计算
    double formulaIF_x(double t) {

//        double t = sc.nextDouble();
        if(t < 1 && t >= 0){
            return t * t - 1;
        } else if (t >= 1 && t < 3) {
            return t*t*t - 2*t - 2;
        } else if (t >= 3 && t <5) {
            return t * t - t * sin(t);
        } else if (t >= 5 && t < 7) {
            return t + 1;
        } else {
            return t - 1;
        }
    }
    double formulaSwitch_x(int t){
        switch (t){
            case 0:return t * t - 1;
            case 1:
            case 2: return t*t*t - 2*t - 2;
            case 3:
            case 4: return t * t - t * sin(t);
            case 5:
            case 6: return t + 1;
            default: return t - 1;
        }
    }
}

