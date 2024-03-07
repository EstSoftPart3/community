package com.community.fo.service;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.stereotype.Service;
import com.community.fo.jpa.entity.CommentEntity;
import com.community.fo.jpa.repository.CommentRepository;
import com.community.fo.mybatis.mapper.CommentMapper;

import lombok.RequiredArgsConstructor;

@MapperScan("com.community.fo.mybatis.mapper")
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService  {

	@Autowired
	private final CommentRepository cr;
	@Autowired
	private final CommentMapper cm;

	public List<CommentEntity> commentList(){ 
		
		List<CommentEntity>	commentList = cr.findAll();
	
			return commentList;
	}
	
	public CommentEntity commentDetail(int commentSq) {
		
		CommentEntity commentDetail = cr.findById(commentSq).orElse(null);
		
		return commentDetail;
	}
	
	public CommentEntity CommentInsert(CommentEntity commentEntity) {
		
		return cr.save(commentEntity);
	}
	public void CommentUptate(CommentEntity commentEntity) {
		
		cr.save(commentEntity);
	}
	public void CommentDelete(int commentSq) {
		
		cr.deleteById(commentSq);
	}
	
	
	
}
