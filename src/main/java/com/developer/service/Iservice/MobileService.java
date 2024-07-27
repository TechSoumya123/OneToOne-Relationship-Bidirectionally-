package com.developer.service.Iservice;

import java.util.List;

import com.developer.dto.responseDto.MobileResponse;
import com.developer.model.Mobile;

public interface MobileService {

	List<Mobile> getAllMobile();

	MobileResponse getMobileById(Long mobileId);

//	MobileResponse getMobileByID(Long mobileId);
}
