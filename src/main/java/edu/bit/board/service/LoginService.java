package edu.bit.board.service;


import org.springframework.stereotype.Service;
import edu.bit.board.mapper.loginMapper;
import edu.bit.board.vo.userVO;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginService{
	
	loginMapper logInMapper;
	
	public userVO loginUser(String id, String pw) {
		return logInMapper.logInUser(id, pw);
				
	}
	
}
