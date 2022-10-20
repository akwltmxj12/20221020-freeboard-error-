package pend.aurrius.freeboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import pend.aurrius.freeboard.dto.BoardDto;

public class BoardDao {
		

	static String driverName = "com.mysql.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/serverdb";
	static String user = "root";
	static String pass = "12345";
	
	
	public void write(String bname, String btitle, String bcontent, String bdate, int hit) {
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO freeboard(bname, btitle, bcontent, bhit) "
				+ "VALUES ('"+bname+"','"+btitle+"','"+bcontent+"',0)";
		try {
			Class.forName(driverName); 		// jdbc 드라이버 로딩
			conn = DriverManager.getConnection(url, user, pass);		// db연동 커넥션 생성
			pstmt = conn.prepareStatement(sql);		// sql 객체 생성
			
			pstmt.executeUpdate();		// sql 실행
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();	
				}				
				if(conn != null) {
					conn.close();
				} 
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}	
	}
	
	public ArrayList<BoardDto> list() {		// 글 목록 가져오기
		
		String sql = "SELCET * FROM freeboard ;";
		
		ArrayList<BoardDto> dtos = new ArrayList<BoardDto>(); // 여러개의 자료구조형 배열만듬		
																						// while문이돌아가면 ArrayList에 하나씩 차례대 뒤로 글을넣는다.
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;	// <-- select일때 필요한 클래스
		
		try {
			Class.forName(driverName); 		// jdbc 드라이버 로딩
			conn = DriverManager.getConnection(url, user, pass);		// db연동 커넥션 생성
			pstmt = conn.prepareStatement(sql);		// sql 객체 생성
			
			rs = pstmt.executeQuery();		// sql 실행
			
			while(rs.next()) {		// while문이 돌아갈때마다 한개씩 적은 순서대로 가져온다.
			int bid = rs.getInt("bid");
			String bname = rs.getString("bname");
			String btitle = rs.getString("btitle");
			String bcontent = rs.getString("bcontent");
			String bdate = rs.getString("bdate");
			int bhit = rs.getInt("bhit");
			
			BoardDto dto = new BoardDto(bid, bname, btitle, bcontent, bdate, bhit);
			
			dtos.add(dto);
//			dto.setBid(bid);
//			dto.setBname(bname);
//			dto.setBtitle(btitle);
//			dto.setBcontent(bcontent);
//			dto.setBdate(bdate);
//			dto.setBhit(bhit);
//			
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();	
				}				
				if(conn != null) {
					conn.close();
				} 
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}				
		return dtos;
				
	}
	
}