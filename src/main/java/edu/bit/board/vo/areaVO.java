package edu.bit.board.vo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class areaVO {
	
	private int width;
	private int height;
	
	public int getArea(int width, int height) {
		return width * height;
	}
	
}
