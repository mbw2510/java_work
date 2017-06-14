package test.dto;

/*
 * Data Transfer Object (Dto)
 */

public class MemberDto {
	//저장소를 필드로 정의한다.
	private int num;
	private String name;
	private String addr;
	
	//디폴트 생성자
	public MemberDto(){}

	//생성자의 인자로 전달해주는 값을 필드에 저장하는 생성자
	public MemberDto(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
	

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
}
