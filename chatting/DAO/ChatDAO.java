package chatting.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import chatting.VO.MessageVO;
import jdbc.JdbcUtil;

public class ChatDAO {
	
	public MessageVO insert(Connection conn, MessageVO msg) {
		PreparedStatement stmt = null;
		String sql = 
				"insert into chat(chat_content, chat_time) " + 
				"values(?, now())";
				
				
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, msg.getContent());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(stmt);
		}
		
		return msg;
	}
	
	
}
