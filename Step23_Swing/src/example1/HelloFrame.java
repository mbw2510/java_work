package example1;

/*
 * GUI와 좀 연관
 */

import javax.swing.JFrame;

public class HelloFrame extends JFrame{
	//JFrame을 상속받은 클래스를 정의하고 생성자를 실행하면 실행순서는 생성자 아래로
	//new HelloFrame();
	
	//생성자
	public HelloFrame() {
		//setBounds(x, y, width, height)
		this.setBounds(100,100,200,200);
		//close버튼을 클릭했을때 프로세스가 종료되도록 설정
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//화면에 보이도록 설정
		this.setVisible(true);
	}
	//메인스레드가 시작되는 메인메소드
	public static void main(String[] args) {
		//HelloFrame 클래스를 이용해서 객체 생성하기
		new HelloFrame();
	}
}
