package com.himedia.shop.util;

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
	
	private void calPaging() {
		endPage = ( (int)(Math.ceil(page / (double)displayPage)) ) * displayPage; 
		beginPage = endPage - (displayPage -1);
		int totalPage = (int)Math.ceil(totalCount/(double)displayRow);
		if(totalPage < endPage) {
			endPage = totalPage; 		next = false;
		} else {
			next = true;
		}
		prev = (beginPage == 1)? false : true; 
		startNum = (page-1) * displayRow+1;
		endNum = page * displayRow; 
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
