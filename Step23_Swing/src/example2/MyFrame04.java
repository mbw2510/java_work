package example2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame04 extends JFrame implements ActionListener{//MyFrame02을 ActionListener 타입으로 만들어 버린것
	//버튼의 참조값을 담을 멤버필드
	JButton saveBtn, deleteBtn;
	
	//생성자
	public MyFrame04(){
		initUI();
	}
	//ui초기화 메소드
	public void initUI() {
		//레이아웃 설정
		setLayout(new BorderLayout());
		//패널객체 생성하기
		JPanel panel=new JPanel();
		//버튼객체 생성하기
		saveBtn=new JButton("저장");
		deleteBtn=new JButton("삭제");
		
		saveBtn.addActionListener(this);//addActionListener 인터페이스 타입
		//this - MyFrame02 가 ActionListener 가 되었기 때문
		deleteBtn.addActionListener(this);
		
		//버튼을 패널에 추가하기
		panel.add(saveBtn);
		panel.add(deleteBtn);
		//패널을 프레임의 북쪽에 추가하기
		this.add(panel, BorderLayout.NORTH);
		
		setBounds(200,200,300,300);
		setTitle("이것은 프레임이다.");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame04();
	}
	//ActionListener 인터페이스 때문에 강제 구현된 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 참조값을 얻어온다.
		Object obj = e.getSource();
		//button,button2 가 지역변수라 불러낼수가없다. 해결 -> 필드에 선언하면 참조가능
		if(obj == this.saveBtn){//저장버튼을 눌렀을때
			System.out.println("저장합니다.");
		}else if(obj == this.deleteBtn){//삭제버튼을 눌렀을때
			System.out.println("삭제합니다.");
		}
	}
}
