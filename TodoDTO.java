package org.zerock.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TodoDTO {
  private String title;
  @DateTimeFormat(pattern="yyyy/MM/dd")  //여기서 /까지 이런 형식으로 치겠다 하면 됨
  private Date dueDate;  // java의 기본타입에 Date 는 존재 하지 않는다. 그러니까  datetime의 경우 어떻게 할것인가.

  
  public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Date getDueDate() {  
	return dueDate;
}

public void setDueDate(Date dueDate) {
	this.dueDate = dueDate;
}
@Override
public String toString() {
	return "TodoDTO [title=" + title + ", dueDate=" + dueDate + "]";
}

}
