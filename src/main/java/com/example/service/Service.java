package com.example.service;

import com.example.bean.Dest;
import com.example.bean.Source;
import com.example.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	Mapper mapperFacade;

	public void create(Dest dest){
		Source source = mapperFacade.map(dest, Source.class);
		System.out.println(source);
	}
}
