package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import common.ConnectDB;
import entity.Student;
import helper.Regex;
import helper.Validation;

public class Studentdao {
	private List<Student> list = new ArrayList<Student>();

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}

//select student
	public List<Student> getStudent() {
		try (var connect = ConnectDB.getConnection();
				var cs = connect.prepareCall("{ call selectStudent}");
				var rs = cs.executeQuery();) {
			while (rs.next()) {
				var stu = new Student();
				stu.setStuId(rs.getInt("stuId"));
				stu.setFullName(rs.getString("fullName"));
				stu.setGender(rs.getBoolean("gender"));
				stu.setEmail(rs.getString("email"));
				stu.setBirthday(LocalDate.parse(rs.getString("birthday"), DateTimeFormatter.ofPattern("[yyyy-MM-dd]")));
				list.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//insert student
	public void insertStudent(Studentdao stu) {
		try (var connect = ConnectDB.getConnection();
				var cs = connect.prepareCall("{call insertStudent(?,?,?,?,?)}");) {
			connect.setAutoCommit(false);
			int i = Integer.parseInt(Validation.checkRegex(Regex.NUM, "nhập số lượng cần insert"));
			for (int j = 0; j < i; j++) {
				cs.setInt(1, Integer.parseInt(Validation.checkRegex(Regex.STUID, "enter stuId")));
				cs.setString(2, Validation.checkRegex(Regex.NAME, "enter fullName"));
				cs.setBoolean(3,
						Validation.checkRegex(Regex.GENDER, "enter Male or Female").equals("Male") ? true : false);
				cs.setString(4, Validation.checkRegex(Regex.DATE, "enter Birthday:"));
				cs.setString(5, Validation.checkRegex(Regex.EMAIL, "enter Email"));
			}
			cs.addBatch();
			cs.executeBatch();
			connect.commit();
			System.out.println("Number of records affected " + i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//delete student
	public void deleteStudent() {
		try (var connect = ConnectDB.getConnection();
				var cs = connect.prepareCall("{call deleteStudent(?)}")) {
			cs.setInt(1, Integer.parseInt(Validation.checkRegex(Regex.NUM, "Enter student id: ")));
			int i = cs.executeUpdate();
			System.out.println("Number of records affected " + i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//update student
		public void updateStudent(Studentdao student) {

			try (var connect = ConnectDB.getConnection();
				var cs = connect.prepareCall("{call updateStudent(?,?,?,?,?)}");) 
			{
				cs.setInt(1, Integer.parseInt(Validation.checkRegex(Regex.STUID, "enter stuId")));
				cs.setString(2, Validation.checkRegex(Regex.NAME, "enter fullName"));
				cs.setBoolean(3, Validation.checkRegex(Regex.GENDER, "enter Male or Female").equals("Male") ? true : false);
				cs.setString(4, Validation.checkRegex(Regex.DATE, "enter Birthday:"));
				cs.setString(5, Validation.checkRegex(Regex.EMAIL, "enter Email"));
				var rs = cs.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
//tìm kiếm sinh viên theo id
	public CallableStatement createCS(Connection connect, String stored) throws Exception {
		var cs = connect.prepareCall(stored);
		cs.setInt(1, Integer.parseInt(Validation.checkRegex(Regex.STUID, "nhập id cần xóa")));
		return cs;
	}
	
	public List<Student> findStudentById() {
		try (var connect = ConnectDB.getConnection(); 
			var cs = createCS(connect, "{ call findStudentById(?)}");
			var rs = cs.executeQuery();)
		{
			while (rs.next()) {
				var stu = new Student();
				stu.setStuId(rs.getInt("stuId"));
				stu.setFullName(rs.getString("fullName"));
				stu.setGender(rs.getBoolean("gender"));
				stu.setEmail(rs.getString("email"));
				stu.setBirthday(LocalDate.parse(rs.getString("birthday"), DateTimeFormatter.ofPattern("[yyyy-MM-dd]")));
				list.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//tìm kiếm sinh viên theo name
	public CallableStatement createCS1(Connection connect, String stored) throws Exception {
		var cs = connect.prepareCall(stored);
		cs.setString(1, Validation.checkRegex(Regex.NAME, "Enter fullname (3 to 50)"));
		return cs;
	}
	
	public List<Student> findStudentByName() {
		try (var connect = ConnectDB.getConnection();
			 var cs = createCS1(connect, "{ call findStudentByName(?)}");
			 var rs = cs.executeQuery();) 
		{
			while (rs.next()) {
				var stu = new Student();
				stu.setStuId(rs.getInt("stuId"));
				stu.setFullName(rs.getString("fullName"));
				stu.setGender(rs.getBoolean("gender"));
				stu.setEmail(rs.getString("email"));
				stu.setBirthday(LocalDate.parse(rs.getString("birthday"), DateTimeFormatter.ofPattern("[yyyy-MM-dd]")));
				list.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//	sắp xếp sinh viên theo thứ tự giảm dần
	public List<Student> sortListStudentDSEC() {
		List<Student> list = new ArrayList<Student>();
		try (var connect = ConnectDB.getConnection();
			 var cs = connect.prepareCall("{ call selectStudent}");
			 var rs = cs.executeQuery();) 
		{
			while (rs.next()) {
				var stu = new Student();
				stu.setStuId(rs.getInt("stuId"));
				stu.setFullName(rs.getString("fullName"));
				stu.setGender(rs.getBoolean("gender"));
				stu.setEmail(rs.getString("email"));
				stu.setBirthday(LocalDate.parse(rs.getString("birthday"), DateTimeFormatter.ofPattern("[yyyy-MM-dd]")));
				;
				list.add(stu);
			}
			Collections.sort(list, Collections.reverseOrder(Comparator.comparing(Student::getStuId)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
//calculation Age
	public CallableStatement createCS2(Connection connect, String stored) throws Exception {
		var cs = connect.prepareCall(stored);
		cs.setInt(1, Integer.parseInt(Validation.checkRegex(Regex.STUID, "nhập id cần tính tuổi")));
		return cs;
	}
	
	public void calculationAge() {
		try (var connect = ConnectDB.getConnection(); 
			var cs = createCS2(connect, "{ call selectAgeById(?)}");
				var rs = cs.executeQuery();)
		{
			while (rs.next()) {
				System.out.println("Thông tin sinh viên");
				System.out.println("Tên sinh viên: " + rs.getString("fullName"));
				System.out.println("Tuổi sinh viên: " + rs.getInt("age"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

//	select student by Month
	public void selectMonth() {
		try (var connect = ConnectDB.getConnection(); 
			var cs = connect.prepareCall("{ call selectMonth}");
			var rs = cs.executeQuery();)
		{
			while (rs.next()) {
				System.out.println("Sinh viên sinh trong tháng " + rs.getInt("month") + ": " + rs.getInt("countStudent"));
				System.out.println("  ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
