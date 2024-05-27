package com.himedia.board.util;

public class Paging {
	private int page=1; //현재 화면에 보여질 페이지
	private int totalCount; //전체 게시물의 갯수(레코드 갯수)
	private int displayRow=10; //한 화면에 보여질 게시물 갯수
	private int displayPage=10; //한 화면에 보여질 페이지 갯수
	private int beginPage; //현재 화면에 표시될 페이지의 시작번호
	private int endPage; //현재 화면에 표시될 페이지의 끝번호
	
	private boolean prev; //prev 버튼이 보일건지 안보일건지(true/false)
	private boolean next; //next 버튼이 보일건지 안보일건지(true/false)
	
	private int startNum; //현재 페이지에 표시될 게시물(레코드)번호의 시작 번호
	private int endNum; //현재 페이지에 표시될 게시물(레코드)번호의 끝 번호
	
	//페이지 표시 예
	//[1] 2 3 4 5 6 7 8 9 10 [next] - 1페이지부터 표시 prev 없음 게시물 100개 이상인 경우 (next 사용전)
	//[◀] 11 12 13 14 [15] 16 17 18 19 20 [▶] - 게시물 갯수가 200개 이상인경우
	//[◀] 21 22 23 24 [25] 26 27 28 29 30 [▶] - 게시물 갯수가 300개 이상인경우
	//[◀] 11 12 13 14  - next없음, 게시물 갯수가 141~149개인경우
	//본 클래스는 하나의 게시판에 객체하나를 할당해서 전체 개시물 수에 따라 계산된 페이지의 각 요소들을
	//각 멤버 변수에 저장하고 화면에 표시할 내용을 사용하는 클래스 입니다...
	
	//각 멤버변수들의 값들을 계산하는 메서드. totalCount 변수가 결정되고서 나머지 값들이 계산돼야 하므로
	//setTotalCount 메서드에서 호출됩니다.
	public void calPaging() {
		//1.beginPage와 endPage 계산 - page(현재페이지)와 displayPage 값을 이용해서 계산
		double temp = page/(double)displayPage;
		// 1/10 -> 0.1   9/10 -> 0.9  15/10 -> 1.5   25/10 -> 2.5
		
		//위 계산의 결과에 소수점을 올림 연산한다.
		temp = Math.ceil(temp); // 0.1 -> 1.0   0.9 -> 1.0  1.5 -> 2.0   2.5 -> 3.0
		
		//위 계산결과에 displayPage을 곱하면 endPage가 계산됨
		endPage = (int)(temp * displayPage); // 1.0 -> 10  2.0 -> 20  3.0 -> 30
		
		endPage = ( (int)(Math.ceil(page / (double)displayPage))) * displayPage; // 1.0 -> 10  2.0 -> 20  3.0 -> 30
		beginPage = endPage - (displayPage -1);
		//endPage가 10이면 beginPage가 1
		//endPage가 20이면 beginPage가 11
		//endPage가 30이면 beginPage가 21
		
		//2. totalPage 계산
		//총게시물수(totalCount)를 한개에 화면에 표시될 게시물수(displayRow)로 나누고, 소수점자리 올림해서 계산
		int totalPage = (int)Math.ceil(totalCount/(double)displayRow);
		// 108 / 10 -> 10.8 -> 11.0 -> 11 : 총 게시물이 108개이면 필요한 총페이지수는 11페이지까지 필요
		// 75 / 10 -> 7.5 -> 8.0 -> 8 : 총 게시물이 75개이면 필요한 총페이지수는 8페이지까지 필요
		// next/prev를 위해서 계산합니다.
		
		//3. next, prev 계산
		if(totalPage < endPage) {
			endPage = totalPage;
			next = false;
		} else {
			next = true;
		}
		
		prev = (beginPage == 1)? false : true; //시작페이지가 1인 경우만 표시안함
		
		//4. startNum, endNum
		startNum = (page-1) * displayRow+1;
		//현재 화면의 시작 게시물 번호 1page : 1, 2page : 11, 3page:21, 4page:31
		endNum = page * displayRow; // MySQL에서는 필요없는 항목. 오라클에서만 필요
		//현재 화면의 끝 게시물 번호 10, 20, 30, 40
		
		System.out.println(beginPage + " " + endPage + " " + startNum + " " + endNum);
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calPaging();
	}
	public int getDisplayRow() {
		return displayRow;
	}
	public void setDisplayRow(int displayRow) {
		this.displayRow = displayRow;
	}
	public int getDisplayPage() {
		return displayPage;
	}
	public void setDisplayPage(int displayPage) {
		this.displayPage = displayPage;
	}
	public int getBeginPage() {
		return beginPage;
	}
	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
}
