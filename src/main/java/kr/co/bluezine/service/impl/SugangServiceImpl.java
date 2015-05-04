package kr.co.bluezine.service.impl;

import java.util.Map;

import kr.co.bluezine.repository.SugangRepository;
import kr.co.bluezine.service.SugangService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("SugangServiceImpl")
public class SugangServiceImpl implements SugangService {

	@Autowired
	@Qualifier("SugangRepository")
	private SugangRepository sugangRepository;
	
	@Override
	public void courseList(Map<String, Object> map) {
		sugangRepository.courseList(map);
	}

	@Override
	public void courseMyList(Map<String, Object> map) {
		sugangRepository.courseMyList(map);
	}

	@Override
	public void deptList(Map<String, Object> map) {
		sugangRepository.deptList(map);
	}

	@Override
	public void courseInsert(Map<String, Object> map) {
		sugangRepository.courseInsert(map);
	}

	@Override
	public void courseDelete(Map<String, Object> map) {
		sugangRepository.courseDelete(map);
	}
}
