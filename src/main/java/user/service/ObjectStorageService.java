package user.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface ObjectStorageService {

	public String uploadFile(String buketName, String directoryPath, MultipartFile img);

	public void deleteFile(String bucketName, String string, String imageFileName);

	public void deleteFile(String bucketName, String string, List<String> list);

}
