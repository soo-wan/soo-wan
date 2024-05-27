package com.himedia.board;

import com.himedia.board.controller.action.Action;
import com.himedia.board.controller.action.board.BoardViewAction;
import com.himedia.board.controller.action.board.BoardViewWithoutCntAction;
import com.himedia.board.controller.action.board.DeleteBoardAction;
import com.himedia.board.controller.action.board.DeleteReplyAction;
import com.himedia.board.controller.action.board.InsertBoardAction;
import com.himedia.board.controller.action.board.InsertBoardFormAction;
import com.himedia.board.controller.action.board.InsertReplyAction;
import com.himedia.board.controller.action.board.MainAction;
import com.himedia.board.controller.action.board.UpdateBoardAction;
import com.himedia.board.controller.action.board.UpdateBoardFormAction;
import com.himedia.board.controller.action.member.DeleteMemberAction;
import com.himedia.board.controller.action.member.IdcheckAction;
import com.himedia.board.controller.action.member.JoinAction;
import com.himedia.board.controller.action.member.JoinFormAction;
import com.himedia.board.controller.action.member.LoginAction;
import com.himedia.board.controller.action.member.LoginFormAction;
import com.himedia.board.controller.action.member.LogoutAction;
import com.himedia.board.controller.action.member.UpdateMemberAction;
import com.himedia.board.controller.action.member.UpdateMemberFormAction;

public class ActionFactory {
	//싱글톤 클래스
	private ActionFactory() { }
	private static ActionFactory itc = new ActionFactory();
	public static ActionFactory getInstance() {return itc;}
	
	//command 값에 따라 해당 클래스의 인스턴스를 Action 참조변수에 조립하는 역할 
	public Action getAction(String command) {
		Action ac = null;
		
		//member
		if(command.equals("loginForm")) { ac = new LoginFormAction(); }
		else if(command.equals("login")) { ac = new LoginAction(); }
		else if(command.equals("joinForm")) ac = new JoinFormAction();
		else if(command.equals("idcheck")) ac = new IdcheckAction();
		else if(command.equals("join")) ac = new JoinAction();
		else if(command.equals("logout")) ac = new LogoutAction();
		else if(command.equals("updateMemberForm")) ac = new UpdateMemberFormAction();
		else if(command.equals("updateMember")) ac = new UpdateMemberAction();
		else if(command.equals("deleteMember")) ac = new DeleteMemberAction();
		
		//board
		else if(command.equals("main")) ac = new MainAction();
		else if(command.equals("insertBoardForm")) ac = new InsertBoardFormAction();
		else if(command.equals("insertBoard")) ac = new InsertBoardAction();
		else if(command.equals("boardView")) ac = new BoardViewAction();
		else if(command.equals("updateBoardForm")) ac = new UpdateBoardFormAction();
		else if(command.equals("updateBoard")) ac = new UpdateBoardAction();
		else if(command.equals("boardViewWithoutCnt")) ac = new BoardViewWithoutCntAction();
		else if(command.equals("deleteBoard")) ac = new DeleteBoardAction();
		else if(command.equals("insertReply")) ac = new InsertReplyAction();
		else if(command.equals("deleteReply")) ac = new DeleteReplyAction();
		
		return ac;
	}
}

