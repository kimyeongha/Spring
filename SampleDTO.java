package org.zerock.domain;



public class SampleDTO {

	  private String name;
	  private int age;
	
	  // getter , setter를 생성해준다.
	  public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "SampleDTO [name=" + name + ", age=" + age + "]";
		//이걸 하면 주소 되신 문자열이 리턴 됨 
	}
	
}
