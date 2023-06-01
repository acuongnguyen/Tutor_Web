<%@page import="java.util.List"%>
<%@ page import="Service.LopHocService" %>
<%@ page import="Model.UserGS" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />	
    <title>Trang chủ</title>
    <link rel="stylesheet" href="css/home.css">
    <script src="https://kit.fontawesome.com/b7bb3a4b72.js" crossorigin="anonymous"></script>
</head>
<body>
	<!-- Phần đầu -->
    <div id="toanbotrang">
        <div id="phandau">
            <div class="baobocitemphandau">
                <div class="menucackhoahoc">
                    <div class="vungkichhoatmenu">
                        <i class="fa-solid fa-bars"></i>
                        <span class="motabieutuong" style="padding-right: 5px; color: white;">Các khóa học</span>
                    </div>
                </div>
                <div id="timkiem">
                    <input type="text" class="input" placeholder="Tìm kiếm khóa học">
                    <button type="submit" class="nuttimkiem"><i class="fa fa-search"></i></button>

                </div>

                <img class="anhiconlogo" src="logo." alt="">
          		<div class="thongtinnguoidung">
            		<button class="subdangnhap" type="submit">
              			<a href="/Web_Tutor1/TaiKhoanServlet">Đăng Nhập</a>
            		</button>
            		<button class="subdangki" type="submit">
              			<a href="/Web_Tutor1/signup.jsp">Đăng Kí</a>
            		</button>
          		</div>
            </div>
        </div>
        <div id="khoahoc-content">
            <div class="wrapper-khoahoc">
                <div class="duongdan"></div>
                <div class="conten-wrapper"></div>
            </div>
        </div>
    </div>
    <div class="container_border_banner">
        <div class="stack container_border_cac_khoa_hoc">
            <ul class="menu_khoa_hoc">
                <p>Các khóa học</p>
                <li class="has_submenu">Đại học - Cao đẳng
                    <div class="container_menu_child">
                        <ul class="menu_khoa_hoc_child">
                            <li>Toán Cao Cấp</li>
                            <li>Lý cao cấp</li>
                        </ul>
                    </div>
                </li>
                <li class="has_submenu">Khóa học bổ trợ
                    <div class="container_menu_child">
                        <ul class="menu_khoa_hoc_child">
                            <li>Ngữ Văn</li>
                            <li>Tiếng Anh</li>
                            <li>Toán</li>
                        </ul>
                    </div>
                </li>
                <li class="has_submenu">Bồi dưỡng học sinh giỏi
                    <div class="container_menu_child">
                        <ul class="menu_khoa_hoc_child">
                            <li>Toán</li>
                            <li>Ngữ văn</li>
                        </ul>
                    </div>
                </li>
                <li class="has_submenu">Luyện thi đại học
                    <div class="container_menu_child">
                        <ul class="menu_khoa_hoc_child">
                            <li>Toán</li>
                            <li>Ngữ văn</li>
                            <li>Tiếng Anh</li>
                            <li>Vật lý</li>
                            <li>Hóa học</li>
                            <li>Sinh học</li>
                        </ul>
                    </div>
                </li>
                <li class="has_submenu">Lớp 10 - Lớp 11 - Lớp 12
                    <div class="container_menu_child">
                        <ul class="menu_khoa_hoc_child">
                            <li>Toán</li>
                            <li>Ngữ văn</li>
                            <li>Tiếng Anh</li>
                            <li>Vật lý</li>
                            <li>Hóa học</li>
                            <li>Sinh học</li>
                            <li>Lịch sử</li>
                            <li>Địa lý</li>
                        </ul>
                    </div>
                </li>
                <li class="has_submenu">Luyện thi vào 10
                    <div class="container_menu_child">
                        <ul class="menu_khoa_hoc_child">
                            <li>Toán</li>
                            <li>Ngữ văn</li>
                            <li>Tiếng Anh</li>
                            <li>Vật lý</li>
                            <li>Hóa học</li>
                            <li>Sinh học</li>
                            <li>Lịch sử</li>
                            <li>Địa lý</li>
                        </ul>
                    </div>
                </li>
                <li class="has_submenu">Lớp 6 - Lớp 7 - Lớp 8 - Lớp 9
                    <div class="container_menu_child">
                        <ul class="menu_khoa_hoc_child">
                            <li>Toán</li>
                            <li>Ngữ văn</li>
                            <li>Tiếng Anh</li>
                            <li>Vật lý</li>
                            <li>Hóa học</li>
                            <li>Sinh học</li>
                            <li>Lịch sử</li>
                            <li>Địa lý</li>
                        </ul>
                    </div>
                </li>
                <li class="has_submenu">Luyện thi vào 6
                    <div class="container_menu_child">
                        <ul class="menu_khoa_hoc_child">
                            <li>Toán</li>
                            <li>Ngữ văn</li>
                            <li>Tiếng Anh</li>
                            <li>Vật lý</li>
                            <li>Hóa học</li>
                            <li>Sinh học</li>
                            <li>Lịch sử</li>
                            <li>Địa lý</li>
                        </ul>
                    </div>
                </li>
                <li class="has_submenu">Lớp 1 - Lớp 2 - Lớp 3 - Lớp 4 - Lớp 5
                    <div class="container_menu_child">
                        <ul class="menu_khoa_hoc_child">
                            <li>Tiếng Viêt</li>
                            <li>Toán</li>
                            <li>Tiếng Anh</li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
        <!-- phần các khóa học-->
        <div class="stack banner_top" style="background-color: #b2b2b2; overflow: hidden;">
            <p style="text-align: center;">Ưu đã lên tới 35%! Cùng con lớp 4-10 chinh phục 9,10 Toán Văn tại HOCMAI.VN
            </p>
        </div>
        <div class="stack banner_img" style="background-color: #b2b2b2; overflow: hidden;">
            <img src="../assets/images/clone_banner.png" alt="">
        </div>
        <div class="stack banner_img_bottom" style="background-color: #b2b2b2; overflow: hidden;">
            <img width=100% src="../assets/images/banner_bottom.png" alt="">
        </div>
    </div>
    <div style="height: 70px;"></div>
    <!-- Trung học phổ thông -->
	<div class="container">
	    <h1 style="padding-left: 60px">Trung học phổ thông</h1>
	    <hr>
	    <br>
	    <div class="row">
	        <div colspan="6">
	            <div><img class="images_thpt"
	                      src="https://r73troypb4obj.vcdn.cloud/website02/uploads/images/62318bba1a1b854d4e90223a/danh-gia-truong-thpt-a-phu-ly-ha-nam-co-tot-khong.jpg"
	                      alt=""
	                      width="400"
	                      height="400"></div>
	        </div>
	        	<% List<UserGS> list3lv3 = (List<UserGS>) request.getAttribute("list3lv3");
				   if (list3lv3 != null) {
				       for (UserGS gs : list3lv3) { %>
				           <div class="col 2 table_thpt_item" align="center">
				               <img src="<%= gs.getImg() %>" alt="" width="200" height="200">
				               <p><a href="profileGS?id=<%= gs.getIdGS() %>">Giáo Viên: <%= gs.getTenGS() %></a></p>
				               <p1><%= gs.getMonHoc().getTenMH() %></p1>
				               <p1>Số lớp học: <%= gs.getCountLH() %></p1>
				           </div>
				    <% }
				   } %>
		    </div>
	    <br>
    	<br>
		<div class="row">
		    <% List<UserGS> list4lv3 = (List<UserGS>) request.getAttribute("list4lv3");
		       if (list4lv3 != null) {
		           for (UserGS gs : list4lv3) { %>
		               <% int count = 5; %>
		               <div class="col 3 table_thpt_item" align="center">
		                   <img src="<%= gs.getImg() %>" alt="" width="200" height="200">
		                   <p><a href="profileGS?id=<%= gs.getIdGS() %>">Giáo Viên: <%= gs.getTenGS() %></a></p>
		                   <p><%= gs.getMonHoc().getTenMH() %></p>
		                   <p>Số lớp học: <%= gs.getCountLH() %></p>
		               </div>
		       <% }
		       } %>
		</div>
	</div>
    <!-- Trung học cơ sở -->
	<div style="height: 60px;"></div>
	<div class="container">
	    <h1 style="padding-left: 60px">Trung học cơ sở</h1>
	    <hr>
	    <br>
	    <div class="row">
	        <div colspan="6">
	            <div><img class="images_thpt"
	                      src="https://r73troypb4obj.vcdn.cloud/website02/uploads/images/62318bba1a1b854d4e90223a/danh-gia-truong-thpt-a-phu-ly-ha-nam-co-tot-khong.jpg"
	                      alt=""
	                      width="400"
	                      height="400"></div>
	        </div>
	        	<% List<UserGS> list3lv2 = (List<UserGS>) request.getAttribute("list3lv2");
				   if (list3lv3 != null) {
				       for (UserGS gs : list3lv3) { %>
				           <div class="col 2 table_thpt_item" align="center">
				               <img src="<%= gs.getImg() %>" alt="" width="200" height="200">
				               <p><a href="profileGS?id=<%= gs.getIdGS() %>">Giáo Viên: <%= gs.getTenGS() %></a></p>
				               <p1><%= gs.getMonHoc().getTenMH() %></p1>
				               <p1>Số lớp học: <%= gs.getCountLH() %></p1>
				           </div>
				    <% }
				   } %>
		    </div>
	    <br>
    	<br>
		<div class="row">
		    <% List<UserGS> list4lv2 = (List<UserGS>) request.getAttribute("list4lv2");
		       if (list4lv3 != null) {
		           for (UserGS gs : list4lv3) { %>
		               <% int count = 5; %>
		               <div class="col 3 table_thpt_item" align="center">
		                   <img src="<%= gs.getImg() %>" alt="" width="200" height="200">
		                   <p><a href="profileGS?id=<%= gs.getIdGS() %>">Giáo Viên: <%= gs.getTenGS() %></a></p>
		                   <p><%= gs.getMonHoc().getTenMH() %></p>
		                   <p>Số lớp học: <%= gs.getCountLH() %></p>
		               </div>
		       <% }
		       } %>
		</div>
	</div>
    <!-- tiểu học -->
	<div style="height: 60px;"></div>
	<div class="container">
	    <h1 style="padding-left: 60px">Tiểu học</h1>
	    <hr>
	    <br>
	    <div class="row">
	        <div colspan="6">
	            <div><img class="images_thpt"
	                      src="https://r73troypb4obj.vcdn.cloud/website02/uploads/images/62318bba1a1b854d4e90223a/danh-gia-truong-thpt-a-phu-ly-ha-nam-co-tot-khong.jpg"
	                      alt=""
	                      width="400"
	                      height="400"></div>
	        </div>
	        	<% List<UserGS> list3lv1 = (List<UserGS>) request.getAttribute("list3lv3");
				   if (list3lv3 != null) {
				       for (UserGS gs : list3lv3) { %>
				           <div class="col 2 table_thpt_item" align="center">
				               <img src="<%= gs.getImg() %>" alt="" width="200" height="200">
				               <p><a href="profileGS?id=<%= gs.getIdGS() %>">Giáo Viên: <%= gs.getTenGS() %></a></p>
				               <p1><%= gs.getMonHoc().getTenMH() %></p1>
				               <p1>Số lớp học: <%= gs.getCountLH() %></p1>
				           </div>
				    <% }
				   } %>
		    </div>
	    <br>
    	<br>
		<div class="row">
		    <% List<UserGS> list4lv1 = (List<UserGS>) request.getAttribute("list4lv3");
		       if (list4lv3 != null) {
		           for (UserGS gs : list4lv3) { %>
		               <% int count = 5; %>
		               <div class="col 3 table_thpt_item" align="center">
		                   <img src="<%= gs.getImg() %>" alt="" width="200" height="200">
		                   <p><a href="profileGS?id=<%= gs.getIdGS() %>">Giáo Viên: <%= gs.getTenGS() %></a></p>
		                   <p><%= gs.getMonHoc().getTenMH() %></p>
		                   <p>Số lớp học: <%= gs.getCountLH() %></p>
		               </div>
		       <% }
		       } %>
		</div>
	</div>
    <div class="footer">
    <div class="wrapper-ft ">
        <div class="content-top">
            <div class="footer-block">
                <h3>VỀ HOCMAI</h3>
                <ul class="footer-block-list">
                    <li>
                        <a href="">Giới thiệu</a>
                    </li>
                    <li>
                        <a href="">Giáo viên nổi tiếng</a>
                    </li>
                    <li>
                        <a href="">Hệ thống trung tâm HOCMAI</a>
                    </li>
                    <li>
                        <a href="">Học sinh tiêu biểu</a>
                    </li>
                    <li>
                        <a href="">Điều khoản chính sách</a>
                    </li>
                    <li>
                        <a href="">Quy chế hoạt động</a>
                    </li>
                    <li>
                        <a href="">Chính sách bảo mật thông tin</a>
                    </li>
                    <li>
                        <a href="">Giải quyết khiếu nại, tranh chấp</a>
                    </li>
                    <li>
                        <a href="">Tuyển dụng</a>
                    </li>
                </ul>
            </div>
            <div class="footer-block">
                <h3>DỊCH VỤ</h3>
                <ul class="footer-block-list">
                    <li>
                        <a href="">Thư viện</a>
                    </li>
                    <li>
                        <a href="">Ôn luyện</a>
                    </li>
                    <li>
                        <a href="">Diễn đàn HOCMAI</a>
                    </li>
                    <li>
                        <a href="">Speakup - Tiếng Anh 1 kèm 1 Online</a>
                    </li>
                    <li>
                        <a href="">ICANTECH - Đào tạo Công nghệ & Lập trình</a>
                    </li>
                </ul>
            </div>
            <div class="footer-block">
                <h3>HỖ TRỢ KHÁCH HÀNG</h3>
                <ul class="footer-block-list">
                    <li>
                        <a href="">Trung tâm hỗ trợ</a>
                    </li>
                    <li>
                        <a>Email: hotro@hocmai.vn</a>
                    </li>
                    <li>
                        <a>Đường dây nóng: 1900 6933</a>
                    </li>
                </ul>
            </div>
            <div class="footer-block">
                <h3>DÀNH CHO ĐỐI TÁC</h3>
                <ul class="footer-block-list">
                    <li>
                        <a>Email: info@hocmai.vn</a>
                    </li>
                    <li>
                        <a>Tel: +84 (24) 3519-0591</a>
                    </li>
                    <li>
                        <a>Fax: +84 (24) 3519-0587</a>
                    </li>
                </ul>
            </div>
            <div class="footer-block">
                <h3>TẢI ỨNG DỤNG HOCMAI</h3>
                <a href=""><img class="footer-img-app" src="../assets/images/footer-google-app.png"></a>
                <a href=""><img class="footer-img-app" src="../assets/images/footer-store-app.png"></a>
                <a href=""><img class="footer-img-app" src="../assets/images/congthuong.png"></a>
            </div>
        </div>
    </div>
    <div class="wrapper-ft">
        <div class="row">
            <div class="row-left">
                <p>
                    Cơ quan chủ quản: Công ty Cổ phần Đầu tư và Dịch vụ Giáo dục <br> MST: 0102183602 do Sở kế
                    hoạch và Đầu tư thành phố Hà Nội cấp ngày 13 tháng 03 năm 2007 <br> Địa chỉ: <br> - Văn
                    phòng Hà Nội: Tầng 4, Tòa nhà 25T2, Đường Nguyễn Thị Thập, Phường Trung Hoà, Quận Cầu Giấy,
                    Hà Nội. <br> - Văn phòng TP.HCM: 13M đường số 14 khu đô thị Miếu Nổi, Phường 3, Quận Bình
                    Thạnh, TP. Hồ Chí Minh <br> Hotline: 19006933 – Email: hotro@hocmai.vn <br> Chịu trách nhiệm
                    nội dung: Phạm Giang Linh
                </p>
            </div>
            <div class="row-right"></div>
        </div>
    </div>
</div>

</body>

</html>