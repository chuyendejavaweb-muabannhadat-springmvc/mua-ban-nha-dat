
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản Lý Danh Mục</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap-responsive.min.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/fullcalendar.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/matrix-style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/matrix-media.css" />
<link
	href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css"
	rel="stylesheet" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/jquery.gritter.css" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.4.2/css/all.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

</head>
<body
	style="background:url(${pageContext.request.contextPath}/video/bann.jpg) fixed;color:white;">


	<jsp:include page="header_Admin.jsp"></jsp:include>
	<!--main-container-part-->
	<div id="content" style="background: rgba(0, 0, 0, 0)">
		<!--breadcrumbs-->
		<div id="content-header">
			<div id="breadcrumb">
				<a href="index_Admin.jsp" title="Go to Home" class="tip-bottom"><i
					class="icon-home"></i> Home</a>
			</div>
		</div>
		<!--End-breadcrumbs-->
		<!--Start-->
		<div>
			<center>
				<h4 style="color: red;">
					Hướng Dẫn: Các bài chưa được duyệt sẽ không được hiển thị trên
					trang website ; Bấm vào [Đi Duyệt] để đi đến dạng Demo của bài đăng
					chưa được duyệt. Ở đó , bấm vào <span style="color: aqua;">duyệt</span>
					nếu đăng lên website, Và <span style="color: aqua">Hủy Bỏ</span>
					bài đăng để hủy bỏ bài .
				</h4>



			</center>
			<h3 style="color: white;">Danh Sách Bài Đăng Cho Thuê Của Thành
				Viên</h3>
			<table id="danhmuc">
				<tr style="width: 100%">
					<td><input type="checkbox" id="listAll" name="list" value="">
					</td>
					<th>Mã bài viết</th>
					<th>Bài viết</th>
					<th>Danh mục</th>
					<th>Gói bài viết</th>
					<th>Thời gian bắt đầu</th>
					<th>Thời gian kết thúc</th>
					<th>Người đăng bài</th>
					<th>Trạng thái</th>
					<th>Công cụ</th>
				</tr>
				<c:forEach items="${listPostNews}" var="postNews">
					<tr>
						<td><input type="checkbox" id="listAll" name="list" value="">
						</td>
						<td>${postNews.id}</td>
						<td>${postNews.title}</td>
						<td>${postNews.news_id.name}</td>
						<td>${postNews.type_id.name}</td>
						<td>${postNews.start_day}</td>
						<td>${postNews.end_day}</td>
						<td>${postNews.user_id.username }</td>


						<c:choose>
							<c:when test="${postNews.status==0}">
								<td>Chưa duyệt</td>
							</c:when>
							<c:when test="${postNews.status==1}">
								<td>Đã duyệt</td>
							</c:when>
							<c:when test="${postNews.status==2}">
								<td>Ẩn</td>
							</c:when>

						</c:choose>


						<td><span><a href="view-detail-post-news?id=${postNews.id}"><i class="fas fa-eye">Xem
										chi tiết</i></a></span> <span><a href="delete?id=${postNews.id}"><i
									class="fas fa-trash-alt">Xóa</i></a></span></td>
						<!-- <td><span style="border: 2px dashed red;"><a
								style="color: rgba(122, 231, 0, 0.8); font-size: 15px;"
								href=""><i class="fas fa-unlock-alt"></i>Xem chi tiết</a></span> 
									<span><a href=""><i
									class="fas fa-trash-alt">Xóa</i></a></span></td> -->

					</tr>
				</c:forEach>

			</table>
		</div>

	</div>
	<div class="clear"></div>

	<!--End-->
	<jsp:include page="menu_Admin.jsp"></jsp:include>


	<script src="${pageContext.request.contextPath}/js/excanvas.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.ui.custom.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.flot.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.flot.resize.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.peity.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/fullcalendar.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/matrix.js"></script>
	<script src="${pageContext.request.contextPath}/js/matrix.dashboard.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.gritter.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/matrix.interface.js"></script>
	<script src="${pageContext.request.contextPath}/js/matrix.chat.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/matrix.form_validation.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.wizard.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.uniform.js"></script>
	<script src="${pageContext.request.contextPath}/js/select2.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/matrix.popover.js"></script>
	<script
		src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/matrix.tables.js"></script>

	<script type="text/javascript">
		// This function is called from the pop-up menus to transfer to
		// a different page. Ignore if the value returned is a null string:
		function goPage(newURL) {

			// if url is empty, skip the menu dividers and reset the menu selection to default
			if (newURL != "") {

				// if url is "-", it is this page -- reset the menu:
				if (newURL == "-") {
					resetMenu();
				}
				// else, send page to designated URL            
				else {
					document.location.href = newURL;
				}
			}
		}

		// resets the menu selection upon entry to this page:
		function resetMenu() {
			document.gomenu.selector.selectedIndex = 2;
		}
	</script>
</body>
</html>
