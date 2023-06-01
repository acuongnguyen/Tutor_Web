<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Thêm thông tin gia sư</title>
    <style>
        /* CSS cho trang addGiaSu.jsp */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        
        .container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
        }
        
        h2 {
            text-align: center;
        }
        
        .form-group {
            margin-bottom: 20px;
        }
        
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        
        .form-group input[type="text"],
        .form-group input[type="tel"],
        .form-group input[type="email"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        
        .form-group input[type="radio"] {
            margin-right: 5px;
        }
        
        .form-group input[type="submit"] {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Thêm thông tin gia sư</h2>
        <form action="updateGiaSu" method="POST">
            <div class="form-group">
                <label for="tenGS">Tên gia sư:</label>
                <input type="text" id="tenGS" name="tenGS" required>
            </div>
            <div class="form-group">
                <label for="gioiTinh">Giới tính:</label>
                <input type="radio" id="gioiTinhNam" name="gioiTinh" value="Nam" checked>
                <label for="gioiTinhNam">Nam</label>
                <input type="radio" id="gioiTinhNu" name="gioiTinh" value="Nữ">
                <label for="gioiTinhNu">Nữ</label>
            </div>
            <div class="form-group">
                <label for="diaChi">Địa chỉ:</label>
                <input type="text" id="diaChi" name="diaChi" required>
            </div>
            <div class="form-group">
                <label for="soDienThoai">Số điện thoại:</label>
                <input type="tel" id="soDienThoai" name="soDienThoai" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <a href="/Web_Tutor1/profileGS"><input type="submit" value="Save"></a>
            </div>
        </form>
    </div>
</body>
</html>