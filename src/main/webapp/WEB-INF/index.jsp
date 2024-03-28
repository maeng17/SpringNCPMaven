<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>*** 메인화면 ***</h2>
<h3>
	<p><a href="/mini/user/writeForm">입력</a></p>
	<p><a href="/mini/user/list?pg=1">출력</a></p>
	<br>
	<p><a href="/mini/user/uploadForm">파일 업로드</a></p>
	<p><a href="/mini/user/uploadFormAjax">파일 업로드_AJax</a></p>
	<br>
	<p><a href="/mini/user/uploadList">이미지 출력</a></p>
</h3>
</body>
</html>

<%-- 
Spring Framework + Maven + MySQL + MyBatis(@Mapper 사용) + JSP

Project : Chapter06_Web (Dynamic Web Project)

Package : com.controller
Class   : MainController.java

Package : user.controller
Class   : UserController.java

Package   : user.service
Interface : UserService.java
			UserUploadService.java
			ObjectStorageService.java
			
Class     : UserServiceImpl.java
		UserUploadService.java
			NCPObjectStorageService.java

Package   : user.dao
Interface : UserDAO.java
			UserUploadDAO.java
Class     : UserDAOMyBatis.java ---> 제거
			UserUploadDAOMyBatis.java ---> 제거

Package   : user.bean
Class     : UserDTO.java
            UserPaging.java

Package : spring.conf
Class   : SpringConfiguration.java
		  NaverConfiguration.java

Folder : WEB-INF
File : index.jsp (메인화면)

Source Folder : src/main/resources
Folder : spring
File   : mybatis-config.xml
         db.properties
         naver.properties
         
Folder : WEB-INF/image

http://localhost:8080/Chapter06_Web/

 --%>