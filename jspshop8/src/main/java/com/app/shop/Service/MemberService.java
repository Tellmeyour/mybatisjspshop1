package com.app.shop.Service;

import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shop.domain.repository.MemberRepository;
import com.app.shop.vo.MemberVo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {
	
	private MemberRepository memberRepository;
//	
//	public Optional<MemberVo> idCheck(String userid) {
//		
//		return memberRepository.idConfirm(userid);
//	
//	}
	
	@Transactional
	public MemberVo idcheck(String userid) {
		
		return memberRepository.idConfirm(userid);
	
	}
	
	

	public boolean pswdCheck(String pswd) {
		
//		String pattern1 = "^[a-z0-9][A-Za-z0-9]$";
//		String pattern2 = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,26}$\n";
		
		String pattern1 = "^(?=.*\\d)(?=.*[~`!@#$%\\^&*()-])(?=.*[a-z0-9])(?=.*[A-Za-z0-9]).{8,26}$";
		String pattern2 = "^(?=.*[a-z0-9])(?=.*[A-Za-z0-9~`!@#$%\\^&*()-]).{8,26}$";

		
//		String pattern = "^[a-z0-9][A-Za-z0-9`\-=\\\[\];',\./~!@#\$%\^&\*\(\)_\+|\{\}:"<>\?]{8,26}$/';
		return Pattern.matches(pattern2, pswd);
	}
	
}
