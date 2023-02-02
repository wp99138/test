package chatting.service;

import java.sql.Connection;
import java.sql.SQLException;

import chatting.DAO.ChatDAO;
import chatting.VO.MessageVO;
import jdbc.JdbcUtil;
import jdbc.conn.ConnectionProvider;

//이서비스는 글 전송(MessageHandler)의 비지니스 로직(전송기능)을 제공
public class ChatService {
	//필드
	ChatDAO chatDAO = new ChatDAO();
	//생성자
	
	//메서드
	public void sendMsg(MessageVO msg) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			
			//chat 테이블의 insert 처리
			MessageVO msgVO = chatDAO.insert(conn, msg);
			if(msgVO==null) {
				throw new RuntimeException("chat테이블에 insert 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn);
		}
		
	
	}
	
	
	
	
}
