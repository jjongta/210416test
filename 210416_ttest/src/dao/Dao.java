package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import db.DBClose;
import db.DBConnection;
import dto.Dto;

public class Dao {
	Scanner sc = new Scanner(System.in);
	private static Dao dao = new Dao();
	private Dao() {
		DBConnection.initConnection();
	}
	public static Dao getInstance() {
		return dao;
	}
	/* 사원을 추가해 봅시다.*/
	public boolean insert() {
		
		String sql = " INSERT INTO JTC(EMPNO, EMPNAME, EMPSAL, EMPDEPT)"
				+ " VALUES (EMPNO_SEQ.NEXTVAL, ?, ?, ?) ";
		int count = 0;
		System.out.println("사원 이름?");
		String name = sc.next();
		System.out.println("사원 급여?");
		int sal = sc.nextInt();
		System.out.println("사원 부서번호?");
		int deptno = sc.nextInt();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 insert success");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/3 insert success");
			
			psmt.setString(1, name);
			psmt.setInt(2, sal);
			psmt.setInt(3, deptno);
			
			count = psmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("insert fail");
			e.printStackTrace();
		}
		
		return count>0?true:false;
		
	}
	
	/* 사원을 삭제해 봅시다*/
	public boolean delete() {
		
		String sql = " DELETE FROM JTC WHERE EMPNO=?";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		System.out.println("삭제하고 싶은 사원번호? : ");
		
		int num = sc.nextInt();
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/3 delete success");
			
			psmt = conn.prepareStatement(sql);
			System.out.println("2/3 delete success");
			
			psmt.setInt(1, num);
			
			count = psmt.executeUpdate();
			System.out.println("3/3 delete success");
			
		} catch (SQLException e) {
			System.out.println("delete fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		return count>0?true:false;
		
	}
	
	/* 사원을 출력해 봅시다*/
	public String allprint() {
		String sql = "SELECT EMPNO, EMPNAME, EMPSAL, EMPDEPT FROM JTC";
		
		List<Dto> list = new ArrayList<Dto>();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
				
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/4 allprint success");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/4 allprint success");
			rs = psmt.executeQuery();
			System.out.println("3/4 allprint success");
			while(rs.next()) {
				Dto dto = new Dto(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getInt(4)
						);
				list.add(dto);
			}
			System.out.println("4/4 allprint success");
			System.out.println(list + "\n");
			
		} catch (SQLException e) {
			System.out.println("allprint fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, rs);
		}
		return list.toString();
	}
	
	/* 사원을 검색해 봅시다*/
	public String select() {
		System.out.println("검색할 사원 이름");
		
		String name = sc.next();
		
		String sql = " SELECT EMPNO, EMPNAME, EMPSAL, EMPDEPT FROM JTC "
					+ " WHERE EMPNAME LIKE '%" + name + "%'";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		Dto dto = null;
		
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/4 select go");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/4 select go");

			System.out.println("3/4 select go");
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				dto = new Dto(
							rs.getInt(1),
							rs.getString(2),
							rs.getInt(3),
							rs.getInt(4)
						);
			}
			System.out.println("4/4 select go");
			System.out.println(dto.toString());
		} catch (SQLException e) {
			System.out.println("select fail");
			e.printStackTrace();
		}
		
		return dto.toString();
		
	}
	
	/* 사원을 수정해 봅시다*/
	public boolean update() {
		String sql = " UPDATE JTC"
					+ " SET EMPNAME =?, EMPSAL=?, EMPDEPT=? "
					+ " WHERE EMPNO=? ";
		System.out.println("수정할 사원 번호?");
		int num = sc.nextInt();
		System.out.println("수정할 이름");
		String name = sc.next();
		System.out.println("수정할 급여");
		int sal = sc.nextInt();
		System.out.println("수정할 부서");
		int dept = sc.nextInt();
		
		Connection conn = null;
		PreparedStatement psmt = null;
		int count = 0;
		
		
		try {
			conn = DBConnection.getConnection();
			System.out.println("1/4 update go");
			psmt = conn.prepareStatement(sql);
			System.out.println("2/4 update go");
			psmt.setString(1, name);
			psmt.setInt(2, sal);
			psmt.setInt(3, dept);
			psmt.setInt(4, num);
			System.out.println("3/4 update go");
			count = psmt.executeUpdate();
			System.out.println("4/4 update go");
			System.out.println("사원정보 수정성공");
		} catch (SQLException e) {
			System.out.println("update fail");
			e.printStackTrace();
		} finally {
			DBClose.close(conn, psmt, null);
		}
		return count>0?true:false;
	
	}

}






















