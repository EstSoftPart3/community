package com.community.fo.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.community.fo.mybatis.dto.SampleDTO;
import com.community.fo.mybatis.vo.SampleVo;

@Mapper
public interface SampleMapper {
	

	public void insertSample(SampleDTO sampleDTO);
	public List<SampleVo> selectAllSamples ();
	public void updateSample(SampleDTO sampleDTO);
	public void deleteSample(SampleDTO sampleDTO);

	
	

}
