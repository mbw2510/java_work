package example3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MemberFrame extends JFrame implements ActionListener{
	//맴버필드 정의하기
	JTextField inputNum, inputName, inputAddr;
	DefaultTableModel model;
	JButton saveBtn, deleteBtn, updateBtn;
	JTable table;
	
	List<Map<String, Object>> members;
	
	//생성자
	public MemberFrame(){
		initUI();
	}
	//메소드 
	public void initUI(){
		
		//레이아웃 설정
		setLayout(new BorderLayout());
		//상단 페널 객체 생성
		JPanel topPanel=new JPanel();
		
		//레이블 객체 생성
		JLabel label1=new JLabel("번호");
		JLabel label2=new JLabel("이름");
		JLabel label3=new JLabel("주소");
		
		//텍스트 필드 객체 생성
		inputNum=new JTextField(10);
		inputName=new JTextField(10);
		inputAddr=new JTextField(10);
		
		saveBtn=new JButton("저장");
		deleteBtn=new JButton("삭제");
		updateBtn=new JButton("수정");
		//버튼 리스너 등록 
		saveBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		
		//페널에 컴포넌트 추가 하기 
		topPanel.add(label1);
		topPanel.add(inputNum);
		topPanel.add(label2);
		topPanel.add(inputName);
		topPanel.add(label3);
		topPanel.add(inputAddr);
		topPanel.add(saveBtn);
		topPanel.add(deleteBtn);
		topPanel.add(updateBtn);
		
		//프레임의 상단에 페널 배치하기
		add(topPanel, BorderLayout.NORTH);		
		
		//테이블 칼럼명 
		String[] colNames={"번호", "이름", "주소"};
		//테이블에 연결할 모델 객체 
		model=new DefaultTableModel(colNames, 0);
		
		//테이블 객체 생성 
		table=new JTable();
		//테이블에 모델 연결
		table.setModel(model);
		
		//스크롤 할수 있는 UI 로 테이블을 감싼다. 
		JScrollPane tablePanel=new JScrollPane(table);
		
		add(tablePanel, BorderLayout.CENTER);
		
		//가로 세로 크기 지정하기 
		setSize(800, 500);
		//화면의 가운데 배치 되도록
		setLocationRelativeTo(null);
		setVisible(true);
		// 창 닫을때 프로세스 종료 되도록 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//파일에 있는 정보 로딩하기
		loadFromFile();
		//로딩된 정보 출력하기 
		displayMember();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//눌러진 버튼의 참조값을 비교해서 분기한다. 
		if(e.getSource() == saveBtn){
			//TextField 에 입력한 내용을 읽어온다.
			int num = Integer.parseInt(inputNum.getText());
			String name=inputName.getText();
			String addr=inputAddr.getText();
			//HashMap 객체에 회원의 정보 담기
			Map<String, Object> map=new HashMap<>();
			map.put("num", num);
			map.put("name", name);
			map.put("addr", addr);
			//ArrayList 객체에 회원 한명의 정보를 담고
			members.add(map);
			saveToFile();
			//알림창 띄우기
			JOptionPane.showMessageDialog(this, "저장했습니다.");
			inputNum.setText("");
			inputName.setText("");
			inputAddr.setText("");
		}else if(e.getSource() == deleteBtn){
			//선택된 table row 의 인덱스를 읽어온다.
			int selectedIndex=table.getSelectedRow();
			if(selectedIndex==-1){// 선택된 row 가 없다면
				JOptionPane.showMessageDialog
					(this, "삭제할 row 를 선택하세요");
				return; //메소드 끝내기 
			}
			//List 에서 해당 인덱스 삭제
			members.remove(selectedIndex);
			//MyMembers.dat 파일에도 반영
			saveToFile();
			JOptionPane.showMessageDialog(this, "삭제했습니다.");
			
		}else if(e.getSource() == updateBtn){
			int selectedIndex=table.getSelectedRow();
			if(selectedIndex==-1){
				JOptionPane.showMessageDialog(this, "수정할 row를 선택하세요");
			}
			//수정할 이름과 주소를 읽어온다.
			//table.getValueAt(row index, column index)
			String name=(String)table.getValueAt(selectedIndex, 1);
			String addr=(String)table.getValueAt(selectedIndex, 2);
			//List의 데이터를 수정한다.
			members.get(selectedIndex).put("name", name);
			members.get(selectedIndex).put("addr", addr);
			saveToFile();
			JOptionPane.showMessageDialog(this, "수정했습니다");
		}
		//파일에 있는 정보 로딩하기
		loadFromFile();
		//로딩된 정보 출력하기 
		displayMember();
	}
	
	//맴버필드의 List 에 담긴 내용을 파일에 저장하는 메소드 
	public void saveToFile(){
		
		//파일에 출력해서 영구 저장한다.		
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		try{
			fos=new FileOutputStream("c:/myFolder/MyMembers.dat");
			//객체 정보를 출력할수 있는 객체 생성하기 
			oos=new ObjectOutputStream(fos);
			//List 객체 출력하기 
			oos.writeObject(members);
			oos.flush();

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fos!=null)fos.close();
				if(oos!=null)oos.close();
			}catch(Exception e){}
		}
	}
	
	//파일에 저장된 회원 목록을 읽어들이는 메소드
	public void loadFromFile(){
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try{
			fis=new FileInputStream("c:/myFolder/MyMembers.dat");
			ois=new ObjectInputStream(fis);
			//원래 type 으로 casting 해서 필드에 저장한다. 
			members=(List)ois.readObject();
		}catch(FileNotFoundException fne){
			//파일을 만든적이 없다면 FileNotFoundException 발생
			members=new ArrayList<>();
			System.out.println("MyMembers.dat 파일이 없음");
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(fis!=null)fis.close();
				if(ois!=null)ois.close();
			}catch(Exception e){}
		}
	}
	//맴버필드에 있는 회원정보를 출력하는 메소드
	public void displayMember(){
		//table 에 출력된 내용 삭제 되도록
		model.setRowCount(0);
		
		for(Map<String, Object> tmp:members){
			int num=(int)tmp.get("num");
			String name=(String)tmp.get("name");
			String addr=(String)tmp.get("addr");
			//System.out.println(num+"/"+name+"/"+addr);
			//회원정보를 Object[] 에 순서대로 담은 다음
			Object[] row=new Object[3];
			row[0]=num;
			row[1]=name;
			row[2]=addr;
			//테이블에 연결된 모델에 전달한다. 
			model.addRow(row);
		}
	}
	
	public static void main(String[] args) {
		new MemberFrame();
	}
}











