package JDBC;

import java.util.ArrayList;

public class Board_Select {
	public static void main(String[] args) {
		BoardDao rdao = BoardDao.getInstance();
		ArrayList<BoardDto> list = rdao.selectBoard();
		
		System.out.printf("게시판번호\t작성자\t\t이름\t\t제목\t\t\t내용\t\t이메일\t\t\t\t\t작성일자\t\t\t\t\t조회수\n");
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(BoardDto bdto : list) {
			System.out.printf("%s\t\t%s\t\t%s\t\t%s\t\t\t%s\t\t%s\t\t%s\t\t\t%s\n",
					bdto.getBoardnum(), bdto.getWriter(), bdto.getName(),bdto.getSubject(), bdto.getContent(), bdto.getEmail(),
					bdto.getWritedate(), bdto.getReadcount());
		}
	}
}
