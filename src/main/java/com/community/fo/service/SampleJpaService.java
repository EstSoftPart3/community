package com.community.fo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.community.fo.jpa.entity.SampleEntity;
import com.community.fo.jpa.repository.SampleRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SampleJpaService {
//	처음에 에러 발생 lombok이 주입되있더라도 sts에 인스톨 해줘야 에러가 사라짐. 
	@Autowired
	private final SampleRepository sampleJpaRepository;

	// 리스트 형태인 조회 실행 findAll sort는 정렬 , Direction은 어떻게 정렬할것인지 ?
	// DESC 내림 차순 정렬 pk로
	public List<SampleEntity> SampleEntitylist() {
		return sampleJpaRepository.findAll(Sort.by(Sort.Direction.DESC, "visitorSq"));

	}

	// pk로 상세 조회 .
	public SampleEntity Detail(int visitorSq) {
		return sampleJpaRepository.findById(visitorSq).orElse(null);

	}

	// 객체로 visitor 테이블에 행 insert
	public void SampleEntityInsert(SampleEntity sampleJpaEntity) {
		sampleJpaRepository.save(sampleJpaEntity);

	}

	// 단일이아닌 한행을 업데이트.
	public void Update(SampleEntity sampleJpaEntity) {
		sampleJpaRepository.save(sampleJpaEntity);
	}

	// pk로 해당 행 삭제
	public void delete(int visitorSq) {
		sampleJpaRepository.deleteById(visitorSq);
	}

}
