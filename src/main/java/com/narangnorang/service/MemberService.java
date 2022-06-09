package com.narangnorang.service;

import java.util.List;
import java.util.Map;

import com.narangnorang.dto.MemberDTO;

public interface MemberService {

	// 로그인
	public MemberDTO selectMember(Map<String, String> map) throws Exception;

	// 아이디 중복 체크
	public int checkId(String email) throws Exception;

	// 닉네임 중복 체크
	public int checkNickname(String nickname) throws Exception;

	// 일반회원가입
	public int generalSignUp(MemberDTO dto) throws Exception;

	// 상담사 회원가입
	public int counselorSignUp(MemberDTO dto) throws Exception;

	// email로 회원 찾기
	public MemberDTO selectByEmail(String email) throws Exception;

	// 새 비밀번호 설정
	public int newPw(MemberDTO dto) throws Exception;

	// 일반회원 정보수정
	public int generalEdit(MemberDTO dto) throws Exception;

	// 상담사회원 정보수정
	public int counselorEdit(MemberDTO dto) throws Exception;

	// 모든 회원
	public List<MemberDTO> selectAll() throws Exception;

	// 선택 계정 삭제
	public int delSelected(List<String> list) throws Exception;

	// 미승인 상담사 회원
	public List<MemberDTO> selectByPrivileage2() throws Exception;

	// 선택 상담사 승급
	public int privileageUp(List<String> list) throws Exception;

	// 프로필 사진 업데이트
	public int photoUpdate(MemberDTO dto) throws Exception;


}
