package model;

public class UserProcessDetails {
private String userId;
private String memberId;
private String bookId;
private String bookTakenDate;
private String bookReturnDate;
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getMemberId() {
	return memberId;
}
public void setMemberId(String memberId) {
	this.memberId = memberId;
}
public String getBookId() {
	return bookId;
}
public void setBookId(String bookId) {
	this.bookId = bookId;
}
public String getBookTakenDate() {
	return bookTakenDate;
}
public void setBookTakenDate(String bookTakenDate) {
	this.bookTakenDate = bookTakenDate;
}
public String getBookReturnDate() {
	return bookReturnDate;
}
public void setBookReturnDate(String bookReturnDate) {
	this.bookReturnDate = bookReturnDate;
}
public String getBookStatus() {
	return bookStatus;
}
public void setBookStatus(String bookStatus) {
	this.bookStatus = bookStatus;
}
private String bookStatus;

}
