package com.community.fo.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.community.fo.mybatis.vo.MemberVo;


@Mapper
public interface MemberMapper {
	
        /* 1. 모든 직원 불러오기 */
	
		public List<MemberVo> empList();
		
		public int getMemberById(String id);

		public int getMemberByNicknm(String nicknm);

}
