package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
    //글쓰기 위한 비즈니스 인터페이스
	public void register(BoardVO board);
	//상세페이지를 위한 비즈니스 인터페이스
   public BoardVO get(int bno);
	//글수정 위한 비즈니스 인터페이스
   public boolean modify(BoardVO board);
	//글삭제 위한 비즈니스 인터페이스
   public boolean remove(int bno);
	//목록리스트를 위한 비즈니스 인터페이스  (페이징하기전)
   public List<BoardVO> getList();
   //목록리스트를 위한 비즈니스 인터페이스 페이징 있음(페이징한 후)
    public List<BoardVO>getList(Criteria cri);  
    
    public int getTotal(Criteria cri);
   

}
