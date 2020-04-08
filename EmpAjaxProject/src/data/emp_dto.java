package data;

import java.sql.Timestamp;

public class emp_dto {

	private String num;
	private String name;
	private String age;
	private String gender;
 	private String pay;
	private Timestamp ipsaday;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public Timestamp getIpsaday() {
		return ipsaday;
	}
	public void setIpsaday(Timestamp ipsaday) {
		this.ipsaday = ipsaday;
	}
	
	
	
	
}
