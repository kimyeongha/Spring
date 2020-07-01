package org.zerock.domain;

import org.springframework.web.util.UriComponentsBuilder;

public class Criteria {
      private int pageNum; //사용자가  화면에서 몇번 페이지를 클릭했는지에 대한 값 을 저장하는 값
     
      private int amount; // 한페이지당 출력되는  리스트 개수.
      
      private String type;  //검색종류 (제목만, 내용만, 제목+내용)
      private String keyword;  //검색어
      
      public Criteria() {  //
    	  this(1,10);  //1페이지에 10개의 게시물 을 출력하는것이 초기값
      }
      public Criteria(int pageNum , int amount) {
    	  this.pageNum= pageNum;
    	  this.amount= amount;
      }
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
		
	
	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", type=" + type + ", keyword=" + keyword + "]";
	}
	
	public String[] getTypeArr() {
		
		return type==null? new String[] { }	: type.split(""); }
	
	public String getListLink() {
		UriComponentsBuilder builder =UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.getAmount())
				.queryParam("type", this.getType())
				.queryParam("keyword", this.getKeyword());
		return builder.toUriString();
				
	}
	
	
}
