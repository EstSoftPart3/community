package com.community.fo.service;

import java.util.List;


import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.community.fo.mybatis.mapper.SampleFoMapper;
import com.community.fo.mybatis.vo.SampleVo;


@MapperScan("com.community.fo.mybatis.mapper")
@Service
public class SampleServiceImpl implements SampleService {
	
	@Autowired 
	SampleFoMapper sampleFoMapper;
	
	
	/*모든 직원 불러오기 */
	@Override
	public List<SampleVo> empListAll() {
		return sampleFoMapper.empListAll();
	}
	
	/* 이름으로 직원 한명 호출하기 
	 * param : string
	 * return 직원 상세정보 s
	 */

	@Override
	public List<SampleVo> empSearchByName(String name) {
		
		
		return sampleFoMapper.empSearchByName(name);
	}
	
	/* 3. 직원 추가하기 */ 
	@Override
	public int empInsert(SampleVo sampleVo) {
				
		return sampleFoMapper.empInsert(sampleVo);
	}

	/* 4. 직원 수정하기 */
	@Override
	public int empUpdate(SampleVo sampleVo) {
		
		return  sampleFoMapper.empUpdate(sampleVo);
	}

	/* 5.직원 지우기 */
	@Override
	public int empDelete(String st_num) {
		
		return sampleFoMapper.empDelete(st_num);
		
	}

	@Override
	public List<SampleVo> viewDetail(Integer id) {
		
		return  sampleFoMapper.viewDetail(id);
	}

	
}
