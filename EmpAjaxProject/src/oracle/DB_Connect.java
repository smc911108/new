package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connect {
	String driver = "oracle.jdbc.driver.OracleDriver";

	String url ="jdbc:oracle:thin:@localhost:1521:xe";

	public DB_Connect() {
		try {
			Class.forName(driver);
			//System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 드라이버 실패:"+e.getMessage()); 
			//자르파일이 프로젝트에 없거나. 클래스 이름이 다르거나(스펠링에 대소문자까지). 두가지 경우뿐
		}
		


	}
	
	//오라클 연결 후 connection을 반환하는 메소드

		public Connection getConnection() {

			Connection conn = null; //커넥션.
			PreparedStatement pstmt = null; ////명령.SQL 구문을 실행하는 역할
			ResultSet rs = null;//Statement 객체 또는 PreparedStatement 객체로 
			//SELECT문을 사용하여 얻어온 레코드 값들을 테이블의 형태로 갖게 되는 객체

			String sql = "";

			try {
				conn = DriverManager.getConnection(url,"angel","a1234");
				//System.out.println("오라클 연결성공");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("연결 실패:"+ e.getMessage());
			}

			return conn; //리턴까지 하자
		}
		
		//강사pc연결
				public Connection getGangsaConnection()
				{
					
					PreparedStatement pstmt = null;
					String gangsaurl = "jdbc:oracle:thin:@192.168.0.3:1521:xe";
					
					Connection conn=null;
					try {
						conn = DriverManager.getConnection(gangsaurl,"angel","a1234");
						//System.out.println("오라클 연결성공");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("연결 실패:"+ e.getMessage());
					}

					return conn; //리턴까지 하자
				}

		//sql 자원들을 닫는 메소드
		public void dbclose(PreparedStatement pstmt,Connection conn)
		{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		//resultset이 있을 경우
		public void dbclose(ResultSet rs, PreparedStatement pstmt,Connection conn)
		{
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		//sql 자원들을 닫는 메소드 Statement
				public void dbclose(Statement stmt,Connection conn)
				{
					try {
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				//resultset이 있을 경우, Statement
				public void dbclose(ResultSet rs, Statement stmt,Connection conn)
				{
					try {
						rs.close();
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
}
