package JavaExpApp_2206002128;

import java.util.Scanner;

class Exp02ScoreManage_Gry {
    Scanner scan = new Scanner(System.in);

    // 创建成绩管理系统对象
    public Exp02Score_Gry Score_Manage;

    // 创建管理员对象
    public Exp02ScoreManage_Gry(Exp02Admin_Gry admin_obj) {
        // 创建成绩管理系统对象
        Score_Manage = new Exp02Score_Gry(admin_obj);
    }

    public void menu_Gry() {
        while (true) {
            System.out.println("**********************************************");
            System.out.println("*                                            *");
            System.out.println("*                  成绩管理系统               *");
            System.out.println("*                                            *");
            System.out.println("**********************************************");
            System.out.println("*                                            *");
            System.out.println("*                  1.管理员登录               *");
            System.out.println("*                                            *");
            System.out.println("*                  2.教师登录                 *");
            System.out.println("*                                            *");
            System.out.println("*                  3.学生登录                 *");
            System.out.println("*                                            *");
            System.out.println("*                  4.退出                    *");
            System.out.println("*                                            *");
            System.out.println("**********************************************");
            switch (scan.nextInt()) {
                case 1:
                    System.out.println("请输入管理员密码：");
                    String admin_password = scan.next();
                    Score_Manage.admin_root.login(admin_password);
                    break;
                case 2:
                    System.out.println("请输入教师工号：");
                    String teacher_id = scan.next();
                    System.out.println("请输入教师密码：");
                    String teacher_password = scan.next();
                    break;
                case 3:
                    System.out.println("请输入学生学号：");
                    String student_id = scan.next();
                    System.out.println("请输入学生密码：");
                    String student_password = scan.next();
                    break;
                case 4:
                    System.out.println("已退出成绩管理系统");
                    return;
                default:
                    break;
            }
        }
    }
}
