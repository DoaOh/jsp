package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IuserDao {
	

List<UserVo> userList();
	
	
 UserVo getUser(String userId);	
 
 
 List<UserVo> userPagingList(PageVo pageVo);
 
 int usersCnt();
 																												
 
int insertUser(UserVo userVo);
 
int deleteUser(String userId);


int updateUser(UserVo userVo);

/**
 * Method : userListForPassEncrypt
 * 작성자 : PC02
 * 변경이력 :
 * @param sqlSession
 * @return
 * Method 설명 : 비밀번호 암호화 적용대상 사용자 전체 조회 
 */
List<UserVo> userListForPassEncrypt(SqlSession sqlSession);


/**
 * Method : userListForPassEncrypt
 * 작성자 : PC02
 * 변경이력 :
 * @param sqlSession
 * @return suserVo
 * Method 설명 :  서용자비밀번호 암호화 적용
 */

int updateUserEncryptPass(SqlSession sqlSession, UserVo userVo); 
 
}
