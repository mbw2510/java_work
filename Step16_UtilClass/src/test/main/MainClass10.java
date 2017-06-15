package test.main;

import java.util.Random;

/*
 *  실행 했을때 
 *  
 *  로또 번호 6개를 무작위로 콘솔창에 출력하는 코드를 작성 해 보세요.
 *  
 *  로또번호 : 1~45 범위의 숫자중에서 중복되지 않는 6개의 숫자 
 */
public class MainClass10 {
	public static void main(String[] args) {
		//Random 객체 생성해서 참조값을 변수에 담기 
		Random ran=new Random();
		
		//int 를 저장할수 있는 방 6개짜리 배열객체 생성
		int[] nums=new int[6];
		
		for(int i=0; i<6; i++){
			//1~45 사이의 랜덤한 정수값을 얻어내서 
			int ranNum=ran.nextInt(45)+1;
			//배열에 순서대로 저장한다.
			nums[i]=ranNum;
			//배열에 ranNum 과 같은 숫자가 있는지 체크한다.
			for(int j=0; j<i; j++ ){
				if(nums[j]==ranNum){//이미 숫자가 존재하면 
					//현재 i번째 방의 숫자를 다시 추출하도록 i 를 1감소
					i--;
					break; //가장 가까운 반복문 탈출 
				}
			}

		}
		
		//출력하기
		for(int i=0; i<6; i++){
			System.out.print(nums[i]+" | ");
		}
		
	}
}


























