package kr.or.ddit.user.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.myBatis.MyBataisUtill;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao implements IuserDao {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDao.class);
	
	public static void main(String[] args) {
		
		
		/***Given***/
		
		IuserDao userDao= new UserDao();
		String userId= "brown";

		/***When***/
		List<UserVo> userList = userDao.userList();
		UserVo uservo  =userDao.getUser(userId);
		
		/***Then***/

		
		logger.debug("userList {} ",userList);
		logger.debug("userInfo {} ",uservo);
		
		
		
	}

	@Override
	public List<UserVo> userList() {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<UserVo> userList= sqlSession.selectList("user.userList");
		
		return userList;
	}

	@Override
	public UserVo getUser(String userId) {

		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		UserVo uservo = sqlSession.selectOne("user.userInfo",userId);
		
		return uservo;
	
	
	}

	
	
	@Override
	public List<UserVo> userPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		List<UserVo> userList = sqlSession.selectList("user.userPagingList",pageVo);
		sqlSession.close();
		return userList;
	}

	@Override
	public int usersCnt() {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int userCnt =(Integer)sqlSession.selectOne("user.usersCnt");
		sqlSession.close();
		return userCnt;
	}	
	
	
	@Override
	public int insertUser(UserVo userVo){
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int insertCnt=sqlSession.insert("user.insertUser",userVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int deleteUser(String userId) {
		
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int deleteCnt=sqlSession.insert("user.deleteUser",userId);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public int updateUser(UserVo userVo) {
		SqlSession sqlSession = MyBataisUtill.getSqlSession();
		int updateCnt=sqlSession.insert("user.updateUser",userVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

	
	
	
	
	/**
	 * Method : userListForPassEncrypt
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param sqlSession
	 * @return
	 * Method 설명 : 비밀번호 암호화 적용대상 사용자 전체 조회 
	 */
	@Override
	public List<UserVo> userListForPassEncrypt(SqlSession sqlSession) {
		// TODO Auto-generated method stub
		return  sqlSession.selectList("user.userListForPassEncrypt");
	}

	
	
	
	/**
	 * Method : userListForPassEncrypt
	 * 작성자 : PC02
	 * 변경이력 :
	 * @param sqlSession
	 * @return suserVo
	 * Method 설명 :  서용자비밀번호 암호화 적용
	 */

	
	@Override
	public int updateUserEncryptPass(SqlSession sqlSession, UserVo userVo) {
		return  sqlSession.update("user.updateUserEncryptPass",userVo);
	}
	
}
