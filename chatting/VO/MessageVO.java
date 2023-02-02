package chatting.VO;

import java.util.Date;

//이 클래스는 chat테이블의 정보를 관리하는 클래스 
public class MessageVO {
	//필드
	String content;			//chat_content
	
	
	//생성자
	public MessageVO() {
	
	}
	
	public MessageVO(String content) {
		super();
		this.content = content;
	}

	//메서드
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	
	
	
	
	
	
}
