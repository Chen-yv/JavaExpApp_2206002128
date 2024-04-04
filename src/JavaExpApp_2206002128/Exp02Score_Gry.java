package JavaExpApp_2206002128;

import java.util.Scanner;

public class Exp02Score_Gry {

    public Exp02Admin_Gry admin_root;
    // 老师名单
    public Exp02Teacher_Gry[] teacher;
    // 学生名单
    public Exp02Student_Gry[] student;

    public Exp02Score_Gry(Exp02Admin_Gry admin) {
        // 创建一个管理员对象
        admin_root = admin;
    }
}

// 定义成绩类
class Course_Score {
    public String Course;
    public int score;
}

/*
 * 类名：people类
 * 类描述：姓名、编号、性别、年龄
 * 成员变量：姓名、编号、性别、年龄
 * 成员方法：获取姓名、获取编号、获取性别、获取年龄
 * 构造方法：无参构造方法、有参构造方法
 */
class Exp02People_Gry {
    public String name;
    public String id;
    public String gender;
    public int age;
    public String password;

    // 构造方法
    public Exp02People_Gry(String name, String id,String gender, int age) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.password = id;
    }
}

/*
 * 类名：学生类
 * 类描述：学生姓名、学生编号、学生性别、学生年龄、学生英语成绩、学生数学成绩、学生Java成绩
 * 成员变量：姓名、编号、性别、年龄、英语成绩、数学成绩、Java成绩、密码
 * 成员方法：获取学生编号、获取学生姓名、获取学生性别、获取学生年龄、获取学生英语成绩、获取学生数学成绩、获取学生Java成绩
 * 构造方法：有参构造方法
 */

class Exp02Student_Gry extends Exp02People_Gry {
    public Course_Score[] score;

    // 构造方法
    public Exp02Student_Gry(String name, String id, String gender, int age, int Score_Count) {
        super(name, id, gender, age);
        score = new Course_Score[Score_Count];
        this.password = id;
    }

    // 构造方法
    public Exp02Student_Gry() {
        super("NULL", "NULL", "NULL", 0);
    }

    // 获取学生编号
    public String Get_Student_Id_Gry() {
        return id;
    }

    // 获取学生姓名
    public String Get_Student_Name_Gry() {
        return name;
    }

    // 获取学生性别
    public String Get_Student_Gender_Gry() {
        return gender;
    }

    // 获取学生年龄
    public int Get_Student_Age_Gry() {
        return age;
    }

    // 学生端输出学生成绩
    public void Get_Score_Gry() {
        int Score_Total = 0;
        System.out.println("学生姓名：" + name);
        System.out.println("学生编号：" + id);
        for (int i = 0; i < score.length; i++) {
            if (score[i] != null) {
                Score_Total += score[i].score;
                System.out.println(score[i].Course + "成绩：" + score[i].score);
            } else {
                if (i == 0) {
                    System.out.println(score[i].Course + "成绩：未录入");
                } else {
                    System.out.println("总成绩：" + Score_Total);
                    System.out.println("平均分：" + Score_Total / i);
                }
            }
        }
    }

    // 学生更改密码
    public void Change_Password_Gry(String new_password) {
        this.password = new_password;
    }

}

/*
 * 类名：教师类
 * 类描述：教师姓名、教师编号、教师性别、教师年龄
 * 成员变量：姓名、编号、性别、年龄、负责课程、学生名单、密码
 * 成员方法：获取教师编号、获取教师姓名、获取教师性别、获取教师年龄
 * 构造方法：无参构造方法、有参构造方法
 */

class Exp02Teacher_Gry extends Exp02People_Gry {

    public String Course;
    public Exp02Student_Gry[] student;
    public int student_count;

    // 无参构造
    public Exp02Teacher_Gry() {
        super("NULL", "NULL", "NULL", 0);
    }

    // 构造方法
    public Exp02Teacher_Gry(String name, String id, String gender, int age, String Course, int student_count) {
        super(name, id, gender, age);
        this.Course = Course;
        student = new Exp02Student_Gry[student_count];
        this.password = id;

    }

    // 获取教师编号
    public String Get_Teacher_id_Gry() {
        return id;
    }

    // 获取教师姓名
    public String Get_Teacher_Name_Gry() {
        return name;
    }

    // 获取教师性别
    public String Get_Teacher_Gender_Gry() {
        return gender;
    }

    // 获取教师年龄
    public int Get_Teacher_Age_Gry() {
        return age;
    }

    // 查找学生信息
    public Exp02Student_Gry Find_Student_Info_Gry(String id) {
        for (int i = 0; i < student.length; i++) {
            if (student[i] != null) {
                if (student[i].Get_Student_Id_Gry() == id) {
                    return student[i];
                }
            } else {
                System.out.println("未找到该学生");
                return null;
            }
        }
        System.out.println("未找到该学生");
        return null;
    }
    // // 统计学生成绩：返回该教师所负责学科的学生姓名、ID、成绩以及排序，平均分（待完善）
    // public int Get_Student_Score_Gry(int id) {
    // for(int i = 0; i < student.length; i++){
    // if(student[i] != null){
    // if(student[i].Get_Student_Id_Gry() == id){
    // return student[i].Get_Score_Gry();
    // }
    // }
    // }
    // }

}

/*
 * 类名：管理员
 * 类描述：管理员姓名、管理员编号、教师名单、学生名单
 * 成员变量：姓名、编号、教师名单、学生名单、密码
 * 成员方法：获取管理员姓名、获取管理员编号、获取教师名单、获取学生名单
 * 构造方法：无参构造方法、有参构造方法
 */

class Exp02Admin_Gry extends Exp02People_Gry {

    public Exp02Teacher_Gry[] teacher;
    public Exp02Student_Gry[] student;
    public int teacher_count;
    public int student_count;

    // 构造方法
    public Exp02Admin_Gry(String name, String id, int teacher_count, int student_count) {
        super(name, id, "NULL", 0);
        this.teacher_count = teacher_count;
        this.student_count = student_count;
        this.teacher = new Exp02Teacher_Gry[teacher_count];
        this.student = new Exp02Student_Gry[student_count];
    }

    public void login(String password) {
        //不知道为什么密码判断不正确，暂时 输入任何密码都正确，下面还有一段注释的死代码
        // if (password == this.password) {
            if (true) {
            System.out.println("登录成功");
            while (true) {
                System.out.println("请输入您要进行的操作：");
                System.out.println("1.查看所有学生信息");
                System.out.println("2.查看所有教师信息");
                System.out.println("3.添加学生信息");
                System.out.println("4.添加教师信息");
                System.out.println("5.退出");

                Scanner scan = new Scanner(System.in);

                int choice = scan.nextInt();
                switch (choice) {
                    
                    case 1:
                        System.out.println("学生信息如下：");
                        Get_Student_List_Gry();
                        break;
                        
                    case 2:
                        System.out.println("教师信息如下：");
                        Get_Teacher_List_Gry();
                        break;
                        
                    case 3:
                        System.out.println("请输入学生姓名：");
                            String name = scan.next();
                            System.out.println("请输入学生编号：");
                            String id = scan.next();
                            System.out.println("请输入学生性别：");
                            String gender = scan.next();
                            System.out.println("请输入学生年龄：");
                            int age = scan.nextInt();
                            Exp02Student_Gry student = new Exp02Student_Gry(name, id, gender, age, 3);
                            Add_Student_Gry(student);
                            break;
                    case 4:
                        System.out.println("请输入教师姓名：");
                            String name_teacher = scan.next();
                            System.out.println("请输入教师编号：");
                            String id_teacher = scan.next();
                            System.out.println("请输入教师性别：");
                            String gender_teacher = scan.next();
                            System.out.println("请输入教师年龄：");
                            int age_teacher = scan.nextInt();
                            System.out.println("请输入教师负责课程：");
                            String Course_teacher = scan.next();
                            System.out.println("请输入教师负责学生人数：");
                            int student_count_teacher = scan.nextInt();
                            Exp02Teacher_Gry teacher = new Exp02Teacher_Gry(name_teacher, id_teacher, gender_teacher, age_teacher, Course_teacher, student_count_teacher);
                            Add_Teacher_Gry(teacher);
                            break;
                            
                    case 5:
                        System.out.println("退出");
                        System.exit(0);
                        break;
                        
                    default:
                        System.out.println("输入错误，请重新输入"); 
                        break;

                }
            }
            
        }
        // else {
        //     System.out.println("密码错误，请重新输入");
        // }
    }

    // 构造方法
    public Exp02Admin_Gry() {
        super("NULL", "NULL", "NULL", 0);
    }

    // 获取管理员姓名
    public String Get_Admin_Name_Gry() {
        return name;
    }

    // 获取管理员编号
    public String Get_Admin_Id_Gry() {
        return id;
    }

    // 获取所有教师名单
    public void Get_Teacher_List_Gry() {
        if (this.teacher == null) {
            System.out.println("教师名单为空");
            return;
        }
        for (int i = 0; i < this.teacher.length; i++) {
            if (this.teacher[i] != null) {
                System.out.print("教师姓名---" + this.teacher[i].name);
                System.out.print("，教师编号---" + this.teacher[i].id);
                System.out.print("，教师性别---" + this.teacher[i].gender);
                System.out.print("，教师年龄---" + this.teacher[i].age);
                System.out.println();
            }
        }
    }

    // 添加学生
    public void Add_Student_Gry(Exp02Student_Gry student) {
        for (int i = 0; i < this.student.length; i++) {
            if (this.student[i] == null) {
                this.student[i] = student;
                return;
            } else {
                System.out.println("学生已满");
            }
        }
    }

    // 获取所有学生名单
    public void Get_Student_List_Gry() {
        if (this.student == null) {
            System.out.println("学生名单为空");
            return;
        }
        for (int i = 0; i < this.student.length; i++) {
            if (this.student[i] != null) {
                System.out.print("学生姓名---" + this.student[i].name);
                System.out.print("，学生编号---" + this.student[i].id);
                System.out.print("，学生性别---" + this.student[i].gender);
                System.out.print("，学生年龄---" + this.student[i].age);
                System.out.println();
            } 
        }

    }

    // 添加教师
    public void Add_Teacher_Gry(Exp02Teacher_Gry teacher) {
        for (int i = 0; i < this.teacher.length; i++) {
            if (this.teacher[i] == null) {
                this.teacher[i] = teacher;
                return;
            } else {
                System.out.println("教师已满");
            }
        }
    }

}