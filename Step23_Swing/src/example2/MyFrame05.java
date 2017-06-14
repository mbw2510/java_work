package example2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
/*
 * 전송버튼을 눌렀을때 JTextField 에 입력한 내용을 읽어와서
 * 콘솔창에 출력해보세요.
 */
public class MyFrame05 extends JFrame implements ActionListener{//MyFrame02을 ActionListener 타입으로 만들어 버린것
	//버튼의 참조값을 담을 멤버필드
	JButton sendBtn,clearBtn;
	JTextField inputText, resultText;
	//생성자
	public MyFrame05(){
		initUI();
	}
	//ui초기화 메소드
	public void initUI() {
		//레이아웃 설정
		setLayout(new BorderLayout());

		JPanel topPanel=new JPanel();
		JPanel bottomPanel=new JPanel();
		inputText = new JTextField(10);
		resultText = new JTextField(10);
		sendBtn = new JButton("전송");
		clearBtn = new JButton("clear");
		//버튼의 리스너 등록하기
		topPanel.add(inputText);
		topPanel.add(sendBtn);
		topPanel.add(clearBtn);
		
		bottomPanel.add(resultText);
		
		
		
		add(topPanel, BorderLayout.NORTH);
		add(bottomPanel, BorderLayout.SOUTH);
		
		sendBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		
		setBounds(200,200,300,300);
		setTitle("이것은 프레임이다.");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MyFrame05();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼 이벤트 객체의 참조값을 얻어온다.
		Object obj=e.getSource();
		if(obj == this.sendBtn){//전송버튼을 눌렀을때.
			System.out.println("전송 버튼 클릭");
			// 1.JTextField 에 입력한 문자열 읽어오기
			String bb = inputText.getText();
			// 2.콘솔에 출력하기
			System.out.println(bb);
			//3.JTextField 에 문자열 출력하기
			resultText.setText(bb);
			//4.입력한 내용 삭제
			inputText.setText("");
		}else if(obj==this.clearBtn){//클리어 버튼 눌렀을때
			System.out.println("클리어 버튼 누름");
			resultText.setText(null);
			inputText.setText(null);			
		}

	}

}
