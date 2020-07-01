package org.zerock.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

@Service
public class BoardServiceImpl  implements BoardService {     //이건 그냥Class가 아니라 비즈니스계층이야 하는 annotation
	  private final Logger logger = LoggerFactory.getLogger(this.getClass());
@Autowired
	private BoardMapper mapper;
@Override
	public void register(BoardVO board) {  //구현부가 있는 메소드 
	
		logger.info("register....."+board);
      mapper.insertR(board);		
}
@Override
public BoardVO get(int bno) {
	  logger.info("get......."+bno);
	return mapper.read(bno);
}
@Override
public boolean modify(BoardVO board) {
         logger.info("modify.............."+board);
	return mapper.update(board)==1;
}
@Override
public boolean remove(int bno) {
        mapper.delete(bno);
	return mapper.delete(bno)==1;
}
@Override
public List<BoardVO> getList() {
	
	return mapper.getList();
}
@Override
public List<BoardVO> getList(Criteria cri) {
	// TODO Auto-generated method stub
	return mapper.getListWithPaging(cri);
}
@Override
public int getTotal(Criteria cri) {
	// TODO Auto-generated method stub
	return mapper.getTotalCount(cri);
}

}
