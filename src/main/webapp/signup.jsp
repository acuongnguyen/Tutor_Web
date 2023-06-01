<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Đăng ký tài khoản</title>
    <link rel="stylesheet" type="text/css" href="css/signup.css" />
  </head>
  <body>
    <h1>Tạo Tài Khoản của bạn!</h1>
    <p1>Học tập và giao lưu với hàng triệu học viên trên mọi miền đất nước!</p1>
    <div class="login">
      <h2>Người dùng đăng ký</h2>
      <form action="SignUpServlet" method="post">
      	<div class="alert-danger" role="alert">${mess}</div>
        <label for="username">Tài Khoản:</label>
        <input type="text" id="username" placeholder="Tài Khoản" name="username" required /><br />
        <label for="password">Mật Khẩu:</label>
        <input type="password" id="password" placeholder="Mật Khẩu" name="password" required /><br />
        <label for="repass">Nhập lại Mật Khẩu:</label>
        <input type="password" id="repass" placeholder="Nhập lại mật khẩu" name="repass" required /><br />
        <input type="checkbox" id="giasu" name="position" value="giasu" />
        <label for="giasu">Gia Sư</label>
        <input type="checkbox" id="hocsinh" name="position" value="hocsinh" />
        <label for="hocsinh">Học sinh</label>
        <br /><br />
        <input type="submit" id="submit" value="Signup" />
      </form>
    </div>
  </body>
</html>