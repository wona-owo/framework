<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src ="/resource/js/sweetalert.min.js"></script>
</head>
<body>
	<script>
		const title = '${title}';
		const text = '${text}';
		const icon = '${icon}';
		const loc = '${loc}';
		
		
		swal({
			title : title,
			text : text,
			icon : icon
		}).then(function(){
			if(loc != '' && loc != null){
				location.href = loc;
			}
		});
		
	</script>
</body>
</html>