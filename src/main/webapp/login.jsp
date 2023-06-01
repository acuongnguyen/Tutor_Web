<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Đăng Nhập</title>
    <link rel="stylesheet" type="text/css" href="css/login.css" />
  </head>
  <body>
    <hr size="0px" width="0px" />
    <p1
      >Học tập và giao lưu với hàng triệu học viên trên khắp mọi miền đất
      nước</p1
    >
    <div class="login">
      <button class="dang_nhap_fb">Dang Nhap</button>
      <button class="dang_nhap_google">Dang Nhap</button>
      <button class="dang_nhap_yahoo">Dang Nhap</button>
      <button class="dang_nhap_apple">Dang Nhap</button>
      <p>Chọn Phương thức đăng nhập vào tài khoản của bạn!</p>
      <hr size="0px" width="0px" />

      <form action="TaiKhoanServlet" method="post">
      	<div class="alert alert-danger" role="alert">${mess}</div>
        <label for="username">Tài Khoản:</label>
        <input type="text" id="username" name="username" required /><br />
        <label for="password">Mật Khẩu:</label>
        <input type="password" id="password" name="password" required /><br />
        <input class="dangnhap" type="submit" value="Đăng nhập" />
        <a href="signup.jsp"><input class="dangki" type="button" value="Đăng kí" /></a>
      </form>
      <button class="quen_mk">Quên Mật Khẩu?</button>
    </div>
  </body>
</html>