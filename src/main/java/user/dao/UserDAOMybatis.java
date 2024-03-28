package user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserDTO;

@Repository
@Transactional
public class UserDAOMybatis implements UserDAO {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public UserDTO isExistId(String id) {
		return sqlSession.selectOne("userSQL.isExistId", id);
	}

	@Override
	public void write(UserDTO userDTO) {
		sqlSession.insert("userSQL.write", userDTO);
		
	}

	@Override
	public List<UserDTO> getUserList(int startNum) {
		return sqlSession.selectList("userSQL.getUserList", startNum);
	}

	@Override
	public int getTotalA() {
		return sqlSession.selectOne("userSQL.getTotalA");
	}

	@Override
	public UserDTO getUser(String id) {
		return sqlSession.selectOne("userSQL.getUser", id);
	}

	@Override
	public void update(UserDTO userDTO) {
		sqlSession.update("userSQL.update", userDTO);
		
	}

	@Override
	public void delete(String id) {
		sqlSession.delete("userSQL.delete",id);
		
	}



}
