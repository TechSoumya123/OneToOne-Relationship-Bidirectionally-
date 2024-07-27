package com.developer.controller.controllerImpl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.developer.controller.IController.IMobileController;
import com.developer.dto.responseDto.MobileResponse;
import com.developer.exception.NoMobileFoundException;
import com.developer.model.Mobile;
import com.developer.service.Iservice.MobileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MobileController implements IMobileController {

	private final MobileService mobileService;

	@Override
	public ResponseEntity<List<Mobile>> getAllMobile() {
		var allMobile = mobileService.getAllMobile();
		return allMobile.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok().body(allMobile);
	}

	@Override
	public ResponseEntity<?> getMobileById(Long mobileId) {
		try {
			MobileResponse mobile = mobileService.getMobileById(mobileId);
			return ResponseEntity.status(HttpStatus.OK).body(mobile);
		} catch (NoMobileFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}
	}

}
