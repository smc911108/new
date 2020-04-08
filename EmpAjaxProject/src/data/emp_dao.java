package data;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import oracle.DB_Connect;

public class emp_dao {
	
	DB_Connect db = new DB_Connect();
	
	//�߰��� �޼ҵ�
	public void insertEmp(emp_dto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into emp (num,name,age,gender,pay,ipsaday) values "
					+"(seq_mini.nextval,?,?,?,?,sysdate";
		
		//pc����
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAge());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getPay());
			//����
			pstmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(pstmt, conn);
		}
	}//insert
	
	
	//num ���� ��� ��� �޼ҵ� // �ٸ� Į�� ������ if���� �Ẹ��
	public List<emp_dto> getAllDatas()
	{	
		emp_dto dto=new emp_dto(); //dto ����
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//���� ����
		List<emp_dto> list=new Vector<emp_dto>();
		String sql="select * from emp order by num desc";
		
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) 
			{
				
				dto.setNum(rs.getString("num"));//�� ���
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setGender(rs.getString("gender"));
				dto.setPay(rs.getString("pay"));
				dto.setIpsaday(rs.getTimestamp("ipsaday"));
				
				//list�� �߰�
				list.add(dto);
				
						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbclose(rs, pstmt, conn);
		}
		 return list;
	}//num
	
	//num �� �ش��ϴ� ������ dto�� ��ȯ�ϴ� �޼ҵ�
	
	public emp_dto getData(String num)
	{
		emp_dto dto = new emp_dto();
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql=" select * from emp where num=?";	
		
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, num);
			//����
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(rs.getString("num"));//�� ���
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setGender(rs.getString("gender"));
				dto.setPay(rs.getString("pay"));
				dto.setIpsaday(rs.getTimestamp("ipsaday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			db.dbclose(rs, pstmt, conn);
		}
		
		
		
		return dto;
	}//getData
	
	
	//num�� �޾Ƽ� �����ϴ� �޼ҵ�
	public void deleteEmp(String num)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from emp where num=?";
		
		//pc����
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			//���ε�
			pstmt.setString(1, num);
			//����
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(pstmt, conn);
		}
	}//delete
	
	
}
