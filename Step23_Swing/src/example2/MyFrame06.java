package example2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame06 extends JFrame implements ActionListener{
	//멤버필드 만들기
	JTextArea textArea;
	JTextField inputText;
	ActionListener listener = new ActionListener(){
		//인터페이스는 단독 객체 생성이 안되기 때문에 익명의 innerClass를 사용한다.
		//익명의 innerClass는 implements ActionListener 를 하고있다.
		//override가 강제된다.
		@Override
		public void actionPerformed(ActionEvent e) {
						
		}		
	};
	//생성자
	public MyFrame06(){
		initUI();
	}
	//ui초기화 메소드
	public void initUI() {
		//레이아웃 설정
		setLayout(new BorderLayout());
		//패널객체 생성하기
		JPanel panel=new JPanel();
		this.inputText=new JTextField(10);
		JButton sendBtn = new JButton("전송");
		JScrollBar scroll = new JScrollBar();		
		panel.add(inputText);
		panel.add(sendBtn);
		
		//new JTextArea(row, column)
		textArea=new JTextArea(10,10);
		add(panel, BorderLayout.NORTH);
		add(textArea, BorderLayout.CENTER);
		add(scroll, BorderLayout.EAST);
				
		sendBtn.addActionListener(this);
//		sendBtn.addActionListener(listener);
		//필드를 등록을 하면 버튼을 눌렀을때 실행순서가 
		//listener 필드로 들어간다.
		
//		textArea.setText("Hello !!!");
//		textArea.append("one\r\n");
//		textArea.append("two\r\n");
//		textArea.append("Three\r\n");
		
		setBounds(200,200,500,500);
		setTitle("이것은 프레임이다.");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame06();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//1.입력한 문자열을 읽어온다.
		String bb = inputText.getText();
		//2.JTextArea에 추가하기
		textArea.append(bb+"\r\n");
		//3.입력창 지우기
		inputText.setText(null);
		
	}
}
