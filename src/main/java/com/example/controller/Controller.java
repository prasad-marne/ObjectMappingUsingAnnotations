package com.example.controller;

import com.example.bean.Dest;
import com.example.service.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

	@Autowired
	Service service;

	@PostMapping(value = "/data",consumes = MediaType.APPLICATION_JSON_VALUE)
	public void post(@RequestBody Dest dest) {
		service.create(dest);
	}
}
