package com.community.fo.mybatis.mapper;

import java.util.List;


import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


import com.community.fo.mybatis.vo.SampleVo;

@Mapper
public interface SampleFoMapper {
	
	
	    /* 1. 모든 직원 불러오기 */
	
		public List<SampleVo> empListAll();
		
		/* 2. 이름으로 직원 한명 호출하기 */
		
		public List<SampleVo> empSearchByName(String name);
		
		/* 3. 직원 추가하기 */ 
		
		public int empInsert(SampleVo sampleVo);
		
		/* 4. 직원 수정하기 */
		
		public int empUpdate(SampleVo sampleVo);
		
		/* 5.직원 지우기 */
		
		public int empDelete(String st_num);

		public List<SampleVo> viewDetail(Integer id);
	
	

}
