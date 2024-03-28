package user.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserImageDTO;
import user.dao.UserUploadDAO;

@Service
public class UserUploadServiceImple implements UserUploadService {
	@Autowired
	private UserUploadDAO userUploadDAO;

	@Autowired
	private ObjectStorageService objectStorageService;
	
	@Autowired
	private HttpSession session;
	
	private String bucketName = "bitcamp-6th-bucket-108";
	
	
	@Override
	public void upload(List<UserImageDTO> userImageList) {
		userUploadDAO.upload(userImageList);
		
	}

	@Override
	public List<UserImageDTO> getUploadList() {
		return userUploadDAO.getUploadList();
		
	}

	@Override
	public UserImageDTO getUploadImage(String seq) {
		return userUploadDAO.getUploadImage(seq);
	}

	@Override
	public void uploadUpdate(UserImageDTO userImageDTO, MultipartFile img) {
		//실제폴더
		String filePath = session.getServletContext().getRealPath("WEB-INF/storage");
		System.out.println("살제폴더 = " + filePath);
		
		// --> Object Storage(NCP)는 이미지를 덮어쓰지 못함.
		//DB에서 seq에 해당하는 imageFileName 꺼내와서 Object Storage(NCP)의 이미지를 삭제하고 새로운 이미지가 올라간다.
		String imageFileName = userUploadDAO.getImageFileName(userImageDTO.getSeq());
		System.out.println("imageFileName = " + imageFileName);
		
		// Object Storage(NCP의) 이미지 삭제
		objectStorageService.deleteFile(bucketName, "storage/", imageFileName);
		
		//Object Storage(NCP)에 새로운 이미지 올리기
		System.out.println("img = " + img);
		imageFileName = objectStorageService.uploadFile(bucketName, "storage/", img);
		
		System.out.println(filePath + ", " +imageFileName);
		File file = new File(filePath, imageFileName);
		
		try {
			img.transferTo(file);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		userImageDTO.setImageFileName(imageFileName);
		userImageDTO.setImageOriginalName(img.getOriginalFilename());
		
		//DB
		userUploadDAO.uploadUpdate(userImageDTO);
	
	}

	@Override
	public void uploadDelete(String[] check) {
		List<String> list = new ArrayList<>();
		
		//DB에서 seq에 해당하는 imageFileName 꺼내와서 List에 담는다. => userUploadMapper.xml에서 <foreach>사용하기 위해서
		for(String c : check) {
			String imageFileName = userUploadDAO.getImageFileName(Integer.parseInt(c));
			list.add(imageFileName);
		}

		//Object Storage(NCP) 삭제
		objectStorageService.deleteFile(bucketName, "storage/", list);
		
		//DB 삭제
		userUploadDAO.uploadDelete(list);
	}

}
