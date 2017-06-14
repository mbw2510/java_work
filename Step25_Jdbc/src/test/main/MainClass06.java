package test.main;

import test.dto.MemberDto;

public class MainClass06 {
	public static void main(String[] args) {
		//회원 한명의 정보를 MemberDto객체에 담기
		MemberDto dto1=new MemberDto(1,"김구라","노량진");
		
		//또 한명의 회원정보를 MemberDto 객체에 담기
		MemberDto dto2=new MemberDto();
		dto2.setNum(2);
		dto2.setName("해골");
		dto2.setAddr("행신동");
		
	}
}
