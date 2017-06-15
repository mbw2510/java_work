package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		int[] nums={10,20,30,40,50};
		
		
		//반복문 for를 이용해서 nums 배열에 저장된 int value 를
		//순서대로 콘솔창에 출력해보세요.
		for(int i=0; i<nums.length; i++){
			int tmp=nums[i];
			System.out.println(tmp);
		}
		
		String[] names={"김구라","해골","원숭이"};
		for(int i=0; i<names.length; i++){
			String tmp=names[i];
		}
		
	}
}
