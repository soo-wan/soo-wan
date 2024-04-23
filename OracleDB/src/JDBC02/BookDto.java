package JDBC02;

//DTO : Data Transfer Object
public class BookDto {
	
	private int booknum;
	private String subject;
	private int makeyear;
	private int inprice;
	private int rentprice;
	private String grade;
	
	public int getBooknum() {
		return booknum;
	}
	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getMakeyear() {
		return makeyear;
	}
	public void setMakeyear(int makeyear) {
		this.makeyear = makeyear;
	}
	public int getInprice() {
		return inprice;
	}
	public void setInprice(int inprice) {
		this.inprice = inprice;
	}
	public int getRentprice() {
		return rentprice;
	}
	public void setRentprice(int rentprice) {
		this.rentprice = rentprice;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
