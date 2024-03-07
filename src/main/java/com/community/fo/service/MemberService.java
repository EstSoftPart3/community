package com.community.fo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.community.fo.jpa.entity.MemberEntity;
import com.community.fo.mybatis.vo.MemberVo;

@Service
public interface MemberService {
	
	public List<MemberEntity> showAllList();
	
	public void registerMember(MemberEntity memberEntity);
	
	public int delMember(int mbrSq );

	public int updateMember(int id, MemberEntity memberEntity);
	
	public  List<MemberVo> empList();

	public int getOneMemberById(String id);

	public int getOneMemberByNicknm(String nicknm);
	
	
	
}
	
	
