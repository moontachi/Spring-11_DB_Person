package com.spring.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spring.ex.dto.PDto;

public class PDao {
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String user = "jspid";
	private String pw = "jsppw";
	
	Connection conn= null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	private static PDao dao;
	
	public static PDao getInstance() {
		if(dao == null) {
			dao = new PDao();
		}
		return dao;
	}
	
	private PDao() {
		System.out.println("PDao() 생성");
		try {
			Class.forName(driver);
			System.out.println("드라이버 로드 완료");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url,user,pw);
			System.out.println("접속성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("접속실패");
			e.printStackTrace();
		}

	}
	
	
	public void write(String id,String name,String age) {
		getConnection();
		String sql = "insert into person values(person_seq.nextval,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, Integer.parseInt(age));
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(Exception e) {
				
			}
		}
	}
	
	public ArrayList<PDto> list(){
		getConnection();
		String sql = "select * from person order by num asc";
		ArrayList<PDto> lists = new ArrayList<PDto>();
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");	
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");	
				
				PDto dto = new PDto();
				dto.setNum(num);
				dto.setId(id);
				dto.setName(name);
				dto.setAge(age);
				
				lists.add(dto);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(Exception e) {
				
			}
		}
		
		return lists;
		
	}
	
	
	public PDto oneSelect(String num) {
		getConnection();
		String sql = "select * from person where num = ?";
		PDto dto = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(num));
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int num2 = rs.getInt("num");	
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");	
				dto = new PDto();
				dto.setNum(num2);
				dto.setId(id);
				dto.setName(name);
				dto.setAge(age);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(Exception e) {
				
			}
		}
		return dto;
	}
	
	
	public void updateData(String num,String id,String name,String age) {
		getConnection();
		String sql = "update person set id = ?,name = ?,age = ? where num = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, Integer.parseInt(age));
			pstmt.setInt(4, Integer.parseInt(num));
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(Exception e) {
				
			}
		}
	}
	
	
	public void deleteData(String num) {
		getConnection();
		String sql = "delete from person where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Integer.parseInt(num));
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
			}catch(Exception e) {
				
			}
		}
	}
	
	
}
