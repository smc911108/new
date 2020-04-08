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
	
	//추가용 메소드
	public void insertEmp(emp_dto dto)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into emp (num,name,age,gender,pay,ipsaday) values "
					+"(seq_mini.nextval,?,?,?,?,sysdate";
		
		//pc연결
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAge());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getPay());
			//실행
			pstmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(pstmt, conn);
		}
	}//insert
	
	
	//num 기준 목록 출력 메소드 // 다른 칼럼 기준은 if문을 써보자
	public List<emp_dto> getAllDatas()
	{	
		emp_dto dto=new emp_dto(); //dto 선언
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//벡터 선언
		List<emp_dto> list=new Vector<emp_dto>();
		String sql="select * from emp order by num desc";
		
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) 
			{
				
				dto.setNum(rs.getString("num"));//값 얻기
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setGender(rs.getString("gender"));
				dto.setPay(rs.getString("pay"));
				dto.setIpsaday(rs.getTimestamp("ipsaday"));
				
				//list에 추가
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
	
	//num 에 해당하는 데이터 dto를 반환하는 메소드
	
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
			//바인딩
			pstmt.setString(1, num);
			//실행
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(rs.getString("num"));//값 얻기
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
	
	
	//num을 받아서 삭제하는 메소드
	public void deleteEmp(String num)
	{
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="delete from emp where num=?";
		
		//pc연결
		conn=db.getConnection();
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, num);
			//실행
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbclose(pstmt, conn);
		}
	}//delete
	
	
}
