package com.booknest.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Library {
	private Long id;
	private String name;
	private String place;
	private String state;
	private String country;

}
