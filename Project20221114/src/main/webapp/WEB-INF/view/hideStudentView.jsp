<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <title>학생 정보 조회(성적, 평가 제외)</title>
</head>
<body>
이름: ${student.name}<br />
이메일: ${student.email}<br />
<br />
<a href="/student/${student.id}">자세한 학생 정보 조회</a>
<a href="/student/${student.id}/modify">정보 수정</a><br />
</body>
</html>