package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
 //annotation+interface 로 할까 xml로 할까 둘중 하나로 골라야 함 밑에는 xml로 할꺼니까 일단 주석 처리 
	//@Select("select* from tbl_board where bno>0")
	//목록 리스트 select
  public List<BoardVO> getList();  //추상메소드 interface는 추상매소드만 쓸수잇잖어
  
  public void insertR(BoardVO board);
  
  public void insertKey(BoardVO board);
//제목을 클릭했을때 한건의 대한 select
  public BoardVO read(int num);
  //데이터 삭제후 몇건을 삭제했는지 알려고 하기때문에 return 타입으로 int!
  public int delete(long bno);
  
  public int update(BoardVO board);

public List<BoardVO> getListWithPaging(Criteria cri); //Criteria 에 있는 1,10 초기값을 넘겨준다.

//전체게시물을 구하여 페이지 처리를 하기위한 select 문
public int getTotalCount(Criteria crl);

}
