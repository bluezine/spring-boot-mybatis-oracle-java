package kr.co.bluezine.repository;

import java.util.Map;

import kr.co.bluezine.mapper.SugangMapper;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("SugangRepository")
public class SugangRepository {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private SugangMapper getMapper() {
		return sqlSessionTemplate.getMapper(SugangMapper.class);
	}
	
	public void courseList(Map<String, Object> map) {
		getMapper().courseList(map);
	}
	
	public void deptList(Map<String, Object> map) {
		getMapper().deptList(map);
	}
	
	public void courseInsert(Map<String, Object> map) {
		getMapper().courseInsert(map);
	}
	
	public void courseDelete(Map<String, Object> map) {
		getMapper().courseDelete(map);
	}
	
	public void courseMyList(Map<String, Object> map) {
		getMapper().courseMyList(map);
	}
}
