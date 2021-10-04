package bao;

import dao.Studentdao;

public class StudentBao {
	public void stuInsert() {
		var student = new Studentdao();
		student.insertStudent(student);
	}

	public void stuDelete() {
		var student = new Studentdao();
		student.deleteStudent();
		System.out.println("Delete success");
	}

	public void stuSortDESC() {
		var student = new Studentdao();
		student.sortListStudentDSEC().forEach(stu -> {
			System.out.println("Thông tin sinh viên: " + stu.getStuId());
			System.out.println("Tên sinh viên: " + stu.getFullName());
			System.out.println("Ngày sinh: " + stu.getBirthday());
			System.out.println("Giới Tính: " + stu.getGender());
			System.out.println("Email: " + stu.getEmail());
			System.out.println("  ");
		});
	}

	public void stuUpdate() {
		var student = new Studentdao();
		student.updateStudent(student);
		System.out.println("Update success");
	}

	public void stuSearchById() {
		var student = new Studentdao();
		student.findStudentById().forEach((stu -> {
			System.out.println("Thông tin sinh viên: " + stu.getStuId());
			System.out.println("Tên sinh viên: " + stu.getFullName());
			System.out.println("Ngày sinh: " + stu.getBirthday());
			System.out.println("Giới Tính: " + stu.getGender());
			System.out.println("Email: " + stu.getEmail());
		}));
	}

	public void stuSearchByName() {
		var student = new Studentdao();
		student.findStudentByName().forEach((stu -> {
			System.out.println("Thông tin sinh viên: " + stu.getStuId());
			System.out.println("Tên sinh viên: " + stu.getFullName());
			System.out.println("Ngày sinh: " + stu.getBirthday());
			System.out.println("Giới Tính: " + stu.getGender());
			System.out.println("Email: " + stu.getEmail());
		}));
	}

	public void selectStudent() {
		var student = new Studentdao();
		student.getStudent().forEach((stu ->{
			System.out.println("Thông tin sinh viên: " + stu.getStuId());
			System.out.println("Tên sinh viên: " + stu.getFullName());
			System.out.println("Ngày sinh: " + stu.getBirthday());
			System.out.println(stu.getGender() ? "Giới tính: Male" : "Giới tính: Female");
			System.out.println("Email: " + stu.getEmail());
			System.out.println("    ");
		})
				);
	}

	public void age() {
		var student = new Studentdao();
		student.calculationAge();
	};

	public void getMonth() {
		var student = new Studentdao();
		student.selectMonth();
	};
}
