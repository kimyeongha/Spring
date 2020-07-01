package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;
//interface +annotation 조합으로 mapper를 만들어 보려고 한다.
public interface TimeMapper {
   @Select("select sysdate()")
   public String getTime();

   public String getTime2();
}
