package edu.bit.board.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class gradeVO {
	
	private int kor;
	private int eng;
	private int math;
	
	public int gradeSum(int kor,int eng, int math) {
		return kor + eng + math;
	}
	
}
