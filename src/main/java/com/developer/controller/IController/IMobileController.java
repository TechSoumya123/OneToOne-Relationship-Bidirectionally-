package com.developer.controller.IController;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.developer.model.Mobile;

public interface IMobileController {
	
	@GetMapping(path = "/allMobile")
	ResponseEntity<List<Mobile>> getAllMobile();
	
	@GetMapping(path = "/byId/{id}")
	public ResponseEntity<?> getMobileById(@PathVariable("id") Long mobileId);
}
