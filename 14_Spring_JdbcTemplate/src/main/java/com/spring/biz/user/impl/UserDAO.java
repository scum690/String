package com.spring.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.biz.common.JDBCUtil;
import com.spring.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	//JDBC 관련 변수
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//SQL 명령어
	private final String USER_GET 
		= "SELECT * FROM USERS WHERE ID = ? AND PASSWORD = ?";
	private final String USER_LIST = "SELECT * FROM USERS ORDER BY USERID";
	
	private final String USER_INSERT = "INSERT INTO USERS VALUES (?, ?, ?, ?)";
	private final String USER_UPDATE = "UPDATE USERS SET PASSWORD = ? WHERE ID = ?";
	private final String USER_DELETE = "DELETE FROM USERS WHERE ID = ? ";
	
	
	//CRUD 기능 메소드
	//회원정보 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC로 getUser() 기능 처리");
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if (rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		
		return user;
	}

	public void insertUser(UserVO vo) {
		
	}
	
	public void updateUser(UserVO vo) {
		
	}
	public void deleteUser(UserVO vo) {
		
	}
	
	public List<UserVO> getUserList(UserVO vo) {
		List<UserVO> list = null;
		
		return list;
	}
}
