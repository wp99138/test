package chatting.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import chatting.VO.MessageVO;
import chatting.service.ChatService;
import mvc.command.CommandHandler;

public class MessageHandler implements CommandHandler {
	private static final String FROM_VIEW = "/view/chatting/chatForm.jsp" ;
	
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return sendMsg(request, response);
	}
	
	public String sendMsg(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//컨트롤러 역활 4가지
		//1.파라미터 얻기
		String msg = request.getParameter("textMessage");		//chatForm에서 데이터 가지고 오기
		//2.비지니스 로직 수행 <-> Service <-> DAO <-> DB
		MessageVO messageVO = new MessageVO();
		ChatService chatService = new ChatService();
		messageVO.setContent(msg);
		chatService.sendMsg(messageVO);
		
		//3.Model 생성
		//4.View 
		
		
		return FROM_VIEW;
	}

}
