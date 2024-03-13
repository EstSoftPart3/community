package com.community.fo.service;

import java.util.List;

import com.community.fo.mybatis.dto.SampleDTO;
import com.community.fo.mybatis.vo.SampleVo;

public interface SampleService {
	public void insertSample(SampleDTO sampleDTO);
	public List<SampleVo> selectAllSamples();
	public void updateSample(SampleDTO sampleDTO);
	public void deleteSample(SampleDTO sampleDTO);

}
