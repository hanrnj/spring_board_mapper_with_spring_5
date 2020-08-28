package edu.bit.board.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import edu.bit.board.vo.userVO;

public interface loginMapper {
	
	@Select("select * from users where username = #{username} and password = #{password}")
	public userVO logInUser(@Param("username") String username, @Param("password") String password);

}
