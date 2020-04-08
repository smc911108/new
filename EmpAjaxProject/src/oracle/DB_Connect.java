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
			//System.out.println("����Ŭ ����̹� ����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("����Ŭ ����̹� ����:"+e.getMessage()); 
			//�ڸ������� ������Ʈ�� ���ų�. Ŭ���� �̸��� �ٸ��ų�(���縵�� ��ҹ��ڱ���). �ΰ��� ����
		}
		


	}
	
	//����Ŭ ���� �� connection�� ��ȯ�ϴ� �޼ҵ�

		public Connection getConnection() {

			Connection conn = null; //Ŀ�ؼ�.
			PreparedStatement pstmt = null; ////���.SQL ������ �����ϴ� ����
			ResultSet rs = null;//Statement ��ü �Ǵ� PreparedStatement ��ü�� 
			//SELECT���� ����Ͽ� ���� ���ڵ� ������ ���̺��� ���·� ���� �Ǵ� ��ü

			String sql = "";

			try {
				conn = DriverManager.getConnection(url,"angel","a1234");
				//System.out.println("����Ŭ ���Ἲ��");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("���� ����:"+ e.getMessage());
			}

			return conn; //���ϱ��� ����
		}
		
		//����pc����
				public Connection getGangsaConnection()
				{
					
					PreparedStatement pstmt = null;
					String gangsaurl = "jdbc:oracle:thin:@192.168.0.3:1521:xe";
					
					Connection conn=null;
					try {
						conn = DriverManager.getConnection(gangsaurl,"angel","a1234");
						//System.out.println("����Ŭ ���Ἲ��");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						System.out.println("���� ����:"+ e.getMessage());
					}

					return conn; //���ϱ��� ����
				}

		//sql �ڿ����� �ݴ� �޼ҵ�
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

		//resultset�� ���� ���
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
		
		//sql �ڿ����� �ݴ� �޼ҵ� Statement
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

				//resultset�� ���� ���, Statement
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
