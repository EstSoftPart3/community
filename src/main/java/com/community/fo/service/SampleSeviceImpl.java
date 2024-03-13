package com.community.fo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.community.fo.jpa.entity.SampleEntity;
import com.community.fo.jpa.repository.SampleRepository;
import com.community.fo.mybatis.dto.SampleDTO;
import com.community.fo.mybatis.mapper.SampleMapper;
import com.community.fo.mybatis.vo.SampleVo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Repository
public class SampleSeviceImpl implements SampleService {
	
	@Autowired
	private final SampleRepository sampleRepository;

	@Autowired
	private final SampleMapper sampleMapper;
	

	public void insertSample(SampleDTO sampleDTO) {
		sampleMapper.insertSample(sampleDTO);
	}
	
	public List<SampleVo> selectAllSamples(){
		
		return sampleMapper.selectAllSamples();
	}

	public void updateSample(SampleDTO sampleDTO) {
		sampleMapper.updateSample(sampleDTO);
		
		
	}

	public void deleteSample(SampleDTO sampleDTO) {
		sampleMapper.deleteSample(sampleDTO);
		
	}
	
	
	
	
	
	//mybatis CRUD end
	
	//jpa CRUD 
	public Long save(SampleEntity sampleEntity) {
		SampleEntity saveEntity =sampleRepository.save(sampleEntity);
		return saveEntity.getId();
	}
	
	public List<SampleEntity> list(){
		return sampleRepository.findAll(Sort.by(Sort.Direction.DESC,"id"));
	}
	
	public SampleEntity detail(Long id) {
		return sampleRepository.findById(id).orElse(null);
	}
	
	public void update(SampleEntity sampleEntity) {
		sampleRepository.save(sampleEntity);
	}
	
	public void delete(Long id) {
		sampleRepository.deleteById(id);
	}
	//jpa CRUD end
	
	
	
	
	
	

}
