package com.developer.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.developer.dto.responseDto.MobileResponse;
import com.developer.exception.NoMobileFoundException;
import com.developer.model.Mobile;
import com.developer.repository.MobileRepository;
import com.developer.service.Iservice.MobileService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MobileServiceImpl implements MobileService {

	private final MobileRepository mobileRepository;

	@Override
	public List<Mobile> getAllMobile() {
		return mobileRepository.findAll();
	}

	@Override
	public MobileResponse getMobileById(Long mobileId) {
		return mobileRepository.findById(mobileId)
				.map(mobile -> new MobileResponse(mobile.getId(), mobile.getMobileName(), mobile.getEmployee().getId(),
						mobile.getEmployee().getName()))
				.orElseThrow(() -> new NoMobileFoundException("No mobile found with this mobile id " + mobileId));
	}
	
	

}
