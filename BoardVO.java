package org.zerock.domain;

import java.util.Date;

public class BoardVO {
   private int bno;
   private String title;
   private String content;
   private String writer;
   private Date regdate;  //Date 타입이 없기때문에 일단 import
   private Date updateDate;

   
   public int getBno() {
	return bno;
}
public void setBno(int bno) {
	this.bno = bno;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
public Date getRegdate() {
	return regdate;
}
public void setRegdate(Date regdate) {
	this.regdate = regdate;
}
public Date getUpdateDate() {
	return updateDate;
}
public void setUpdateDate(Date updateDate) {
	this.updateDate = updateDate;
}
  //제대로 들어갓는지 알수가 없다. 그래서 toString 오버라이딩하자.
@Override
public String toString() {
	return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regdate="
			+ regdate + ", updateDate=" + updateDate + "]";
}


}
