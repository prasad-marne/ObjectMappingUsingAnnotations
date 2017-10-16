package com.example.bean;

import com.example.annotation.Dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Dto(destination = Dest.class)
public class Source {
	private int age;
	private String name;
}
