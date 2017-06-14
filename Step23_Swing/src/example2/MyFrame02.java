package example2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame02 extends JFrame{

	//익명의 inner class 를 이용해서 인터페이스 type의 참조값
	//얻어내기
	ActionListener listener = new ActionListener(){
		
		//이 ActionListener 객체를 등록한 버튼을 누르면 호출되는 메소드
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("버튼을 눌렀구만?!");
			//버튼을 누르면 메인쓰레드의 순서가 이쪽으로 들어온다
		}
	};
	
	//생성자
	public MyFrame02(){
		initUI();
	}
	//ui초기화 메소드
	public void initUI() {
		//레이아웃 설정
		setLayout(new BorderLayout());
		//패널객체 생성하기
		JPanel panel=new JPanel();
		//버튼객체 생성하기
		JButton button=new JButton("누질러보셈");
		JButton button2=new JButton("누질러보셈2");
		
		button.addActionListener(listener);//addActionListener 인터페이스 타입
		
		
		//버튼을 패널에 추가하기
		panel.add(button);
		panel.add(button2);
		//패널을 프레임의 북쪽에 추가하기
		this.add(panel, BorderLayout.SOUTH);
		
		setBounds(200,200,300,300);
		setTitle("이것은 프레임이다.");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame02();
	}
}
