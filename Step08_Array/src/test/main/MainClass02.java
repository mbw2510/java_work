package test.main;

public class MainClass02 {
	public static void main(String[] args) {
	
		//3개의 방의 갯수를 가지고 있는 int배열 객체를 생성
		int[] nums=new int[3];

		int a=nums.length;//배열의 크기인 3이 참조된다.
		
		//각각의 방에 11, 12, 13을 저장해보세요.
		nums[0]=11;
		nums[1]=12;
		nums[2]=13;
		
		//각각의 방에 저장된 값을 a1, a2, a3라는 변수에 담아보세요.
		int a1=nums[0];
		int a2=nums[1];
		int a3=nums[2];
		
		//int a4=nums[3];
		
		//↑위를 실행하면 아래와 같은것이 나오는데
		//이것을 런타입익셉션이라 한다.
		//ArrayIndexOutofBoundsException 발생
		
//		Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
//		at test.main.MainClass02.main(MainClass02.java:11)
		int[] nums2=null;
		//NullPointerException 발생
		//nums2에는 참조값이 없다.				
		int b=nums2.length;
	}
}
