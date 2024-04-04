import java.util.Scanner;

import JavaExpApp_2206002128.Exp01_Gry;
import JavaExpApp_2206002128.Exp02_Gry;


public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("请选择实验(输入零退出):");
            switch (scan.nextInt()) {
                case 0:
                scan.close();
                    System.out.println("主菜单已退出！");
                    return;
                case 1:
                    Exp01_Gry test1 = new Exp01_Gry();
                    test1.menu_Gry();
                    break;
                case 2:
                    Exp02_Gry test2 = new Exp02_Gry();
                    test2.menu_Gry();
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }

        }
        
    }
}