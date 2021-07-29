package com.app.shop.domain.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.app.shop.vo.MemberVo;

@Repository
public interface MemberRepository {
	
//	public Optional<MemberVo> idConfirm(String userid);
	
	public MemberVo idConfirm(String userid);


}
