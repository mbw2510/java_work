package test.mypac;
/*
 *  
 */
public class CountThread extends Thread{
	//맴버필드 정의하기
	private String name;
	private int count;
	
	//생성자
	public CountThread(String name, int count){
		this.name=name;
		this.count=count;
	}
	
	//스레드가 시작되었을때 호출되는 메소드
	@Override
	public void run() {
		System.out.println(this.name+" 스레드 시작");
		//맴버필드에 저장된 count 만큼 반복 작업하는 부분
		for(int i=0; i<this.count; i++){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
			System.out.println(this.name+" 스레드가 "+i+
					"번째 작업중...");
		}
		System.out.println(this.name+" 스레드가 종료 됩니다.");
	}
}










