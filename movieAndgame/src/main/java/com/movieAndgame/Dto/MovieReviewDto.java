package com.movieAndgame.Dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MovieReviewDto {
	private int review_Id;
	
	@NotBlank(message="제목을 꼭 입력하세요")
	private String title;
	
	private String writer;
	
	@Size(min=10,max=300, message="최소 10자 이상 작성하세요")
	private String content;
	private LocalDateTime weite_date;
}
