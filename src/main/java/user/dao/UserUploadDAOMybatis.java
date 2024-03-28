package user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import user.bean.UserImageDTO;

@Repository
@Transactional
public class UserUploadDAOMybatis implements UserUploadDAO {
	@Autowired
	private SqlSession sqlSession;

	/* for 사용
	@Override
	public void upload(UserImageDTO userImageDTO, List<String> fileNameList) {
		for( String fileName : fileNameList) {
			userImageDTO.setImage1(fileName);
			sqlSession.insert("userUploadSQL.upload", userImageDTO);
		}
		
	}
	
		@Override
	public void upload(List<UserImageDTO> userImageList) {
		for( UserImageDTO userImageDTO : userImageList) {
			sqlSession.insert("userUploadSQL.upload", userImageDTO);
		}
		
	}
	
	*/
	//XML안에서 <ForEach> 사용할 때
	@Override
	public void upload(List<UserImageDTO> userImageList) {
			sqlSession.insert("userUploadSQL.upload", userImageList);
	}

	@Override
	public List<UserImageDTO> getUploadList() {
		
		return sqlSession.selectList("userUploadSQL.getUploadList");
	}

	@Override
	public UserImageDTO getUploadImage(String seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImageFileName(int seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void uploadUpdate(UserImageDTO userImageDTO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uploadDelete(List<String> list) {
		// TODO Auto-generated method stub
		
	}

}
