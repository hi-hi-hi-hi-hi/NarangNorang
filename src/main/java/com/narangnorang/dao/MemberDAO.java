package com.narangnorang.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.narangnorang.dto.MemberDTO;

@Repository("memberDAO")
public class MemberDAO {

	@Autowired
	SqlSession sqlSession;

	// 로그인
	public MemberDTO selectMember(Map<String, String> map) throws Exception {
		return sqlSession.selectOne("com.config.MemberMapper.selectMember", map);
	}

	// 아이디 중복 체크
	public int checkId(String email) throws Exception {
		return sqlSession.selectOne("com.config.MemberMapper.checkId", email);
	}

	// 닉네임 중복 체크
	public int checkNickname(String nickname) throws Exception {
		return sqlSession.selectOne("com.config.MemberMapper.checkNickname", nickname);
	}

	// 일반회원가입
	public int generalSignUp(MemberDTO dto) throws Exception {
		return sqlSession.insert("com.config.MemberMapper.generalSignUp", dto);
	}

	// 상담사 회원가입
	public int counselorSignUp(MemberDTO dto) throws Exception {
		return sqlSession.insert("com.config.MemberMapper.counselorSignUp", dto);
	}

	// email로 회원찾기
	public MemberDTO selectByEmail(String email) throws Exception {
		return sqlSession.selectOne("com.config.MemberMapper.selectByEmail", email);
	}

	// 새 비밀번호 설정
	public int newPw(MemberDTO dto) throws Exception {
		return sqlSession.update("com.config.MemberMapper.newPw", dto);
	}

	// 일반회원 정보수정
	public int generalEdit(MemberDTO dto) throws Exception {
		return sqlSession.update("com.config.MemberMapper.generalEdit", dto);
	}

	// 상담사회원 정보수정
	public int counselorEdit(MemberDTO dto) throws Exception {
		return sqlSession.update("com.config.MemberMapper.counselorEdit", dto);
	}

	// 모든 회원
	public List<MemberDTO> selectAll() throws Exception {
		return sqlSession.selectList("com.config.MemberMapper.selectAll");
	}

	// 선택 계정 삭제
	public int delSelected(List<String> list) throws Exception {
		return sqlSession.delete("com.config.MemberMapper.delSelected", list);
	}

	// 미승인 상담사 회원
	public List<MemberDTO> selectByPrivileage2() throws Exception {
		return sqlSession.selectList("com.config.MemberMapper.selectByPrivileage2");
	}

	// 선택 상담사 승급
	public int privileageUp(List<String> list) throws Exception {
		return sqlSession.update("com.config.MemberMapper.privileageUp", list);
	}

	// 프로필 사진 업데이트
	public int photoUpdate(MemberDTO dto) throws Exception {
		return sqlSession.update("com.config.MemberMapper.photoUpdate", dto);
	}

	// 접속일시 업데이트
	public int updateDatetime(Map<String, String> map) throws Exception {
		return sqlSession.update("com.config.MemberMapper.updateDatetime", map);
	}

}
