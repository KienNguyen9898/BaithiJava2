import dao.StudentDAO;
import model.Student;

import java.util.List;
import java.util.Scanner;

public class App {

    private static StudentDAO studentDAO = new StudentDAO();

    public static void mainMenu(){
        System.out.println("--- QUAN LY SINH VIEN ---");
        System.out.println("1. Danh sach sinh vien");
        System.out.println("2. Nhap sinh vien moi");
        System.out.println("3. Xoa sinh vien theo ma");
        System.out.println("4. Cap nhat thong tin sinh vien");
        System.out.println("5. Tim sinh vien theo ho ten hoac ma ");
        System.out.println("6. sap xep sinh vien theo gpa tang dan");
        System.out.println("7. In ra tat ca sinh vien nu o Ha Noi co GPA tren 2.5");
        System.out.println("8. Sap xep sinh vien theo ho ten");
    }
    private static void option1() {
        List<Student> studentList = studentDAO.getAll();
        System.out.printf("%-20s %-20s %-20s %-20s", "Ma sinh vien", "Ho ten", "Gioi tinh", "Dia chi");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            System.out.printf("%-20s %-20s %-20s %-20s\n", s.getId(), s.getFullname(), s.getGender(), s.getAddress());
        }
    }
    private static void option2(Scanner in){
        Student s = new Student();
        System.out.print("Nhập ID Sinh Viên : ");
        s.setId(in.nextLine());
        System.out.print("Nhập Họ Và Tên : ");
        s.setFullname(in.nextLine());
        System.out.print("Nhập Giới Tính : ");
        s.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("Nhập Ngày Sinh : ");
        s.setDate(in.nextLine());
        System.out.print("Nhập Địa Chỉ : ");
        s.setAddress(in.nextLine());
        System.out.print("Nhập Phone Number : ");
        s.setPhone(in.nextLine());
        System.out.print("Nhập Email : ");
        s.setEmail(in.nextLine());
        System.out.print("Nhập Điểm GPA : ");
        s.setGpa(Double.parseDouble(in.nextLine()));
        studentDAO.insert(s);
    }

    private static void option3(Scanner in){
        System.out.print("\tNhap id sinh vien xoa: ");
        String id= in.nextLine();
        studentDAO.delete(id);
    }

    private static void option4(Scanner in){
        Student s = new Student();
        System.out.print("Nhap id sinh vien can cap nhat: ");
        String id = in.nextLine();
        System.out.print("Nhập Họ Và Tên : ");
        s.setFullname(in.nextLine());
        System.out.print("Nhập Giới Tính : ");
        s.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("Nhập Ngày Sinh : ");
        s.setDate(in.nextLine());
        System.out.print("Nhập Địa Chỉ : ");
        s.setAddress(in.nextLine());
        System.out.print("Nhập Phone Number : ");
        s.setPhone(in.nextLine());
        System.out.print("Nhập Email : ");
        s.setEmail(in.nextLine());
        System.out.print("Nhập Điểm GPA : ");
        s.setGpa(Double.parseDouble(in.nextLine()));
        in.close();
        studentDAO.update(s, id);

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int option = -1;

        do {
            mainMenu();
            System.out.print("Nhập lựa chọn: ");
            try {
                option = Integer.parseInt(in.nextLine());

            } catch (Exception exception) {
                System.out.println("Nhap sai dinh dang");
                continue;

            }
            if (option < 1 || option > 8) {
                System.out.println("Vui lòng nhập lại!");
                continue;
            }
            switch (option) {
                case 1:
                    option1();
                    break;
                case 2:
                    option2(in);

                    break;
                case 3:
                    option3(in);

                    break;
                case 4:
                    option4(in);

                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:

                    break;
                case 8:

                    break;

            }

        }
        while (option != 0);
        in.close();
    }
}
