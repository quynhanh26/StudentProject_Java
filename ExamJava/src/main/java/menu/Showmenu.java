package menu;

import java.util.*;

import bao.StudentBao;
import helper.Regex;
import helper.Validation;

public class Showmenu {
	public static void callMenu() {
		StudentBao stu = new StudentBao();
		String repeat = null;
		Scanner sc = new Scanner(System.in);
		boolean check = true;
		do {
			System.out.println("1.Hiển thị thông tin sinh viên");
			System.out.println("2.Thêm sinh viên");
			System.out.println("3.Tìm kiếm thông tin sinh viên theo id");
			System.out.println("4.tìm kiếm thông tin sinh viên theo tên");
			System.out.println("5.sort DESC");
			System.out.println("6.Xóa sinh viên");
			System.out.println("7.Thay đổi thông tin sinh viên");
			System.out.println("8.Tính tuổi cho sinh viên");
			System.out.println("9.thông tin sinh viên trong tháng");

			int option = Integer.parseInt(Validation.checkRegex(Regex.NUM, "enter choose"));
			switch (option) {
			case 1 -> stu.selectStudent();

			case 2 -> stu.stuInsert();

			case 3 -> stu.stuSearchById();

			case 4 -> stu.stuSearchByName();

			case 5 -> stu.stuSortDESC();

			case 6 -> stu.stuDelete();

			case 7 -> stu.stuUpdate();
			
			case 8 -> stu.age();
			
			case 9 -> stu.getMonth();
			}
			System.out.println("Ban co muon tiep tuc khong ? yes / no ");
			repeat = sc.nextLine();
		} while (repeat.equals("yes") == true);
	}
}
