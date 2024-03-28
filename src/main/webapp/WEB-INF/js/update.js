$(function(){
	//id에 해당하는 데이터 가져오기
	$.ajax({
		type: 'post',
		url: '/mini/user/getUser',
		data: 'id=' + $('#id').val(),
		dataType: 'json',
		success: function(data){
			console.log(JSON.stringify(data));
			
			$('#name').val(data.name);
			$('#pwd').val(data.pwd);
			
		},
		error: function(e){
					console.log(e);
		}
	});
});

//취소버튼
$('#resetBtn').click(function(){
	location.reload();
});

//수정버튼
$('#updateBtn').click(function(){
	//div영역 초기화
	$('#nameDiv').empty();
	$('#pwdDiv').empty();
	
	if($('#name').val() == '')
			$('#nameDiv').text('이름 입력');
	else if($('#id').val() == '')
		$('#idDiv').text('아이디 입력');
	else if($('#pwd').val() == '')
		$('#pwdDiv').text('비밀번호 입력');
	else {
		$.ajax({
			type: 'post',
			url: '/mini/user/update',
			data: $('#updateForm').serialize(),
			success: function(data){
				alert('회원 정보 수정 완료');
				location.href='/mini/user/list?pg=' + $('#pg').val();
			},
			error: function(e){
						console.log(e);
			}
		});//ajax
	}//else
	
});