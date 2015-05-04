package kr.co.bluezine.service;

import java.util.Map;

public interface SugangService {
	void courseList(Map<String, Object> map);
	void courseMyList(Map<String, Object> map);
	void deptList(Map<String, Object> map);
	void courseInsert(Map<String, Object> map);
	void courseDelete(Map<String, Object> map);
}
