<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Administrator_page</title>
<link rel="stylesheet" href="../css/iconfont.css">
<link rel="stylesheet" href="../css/commonality.css">
<link rel="stylesheet" href="../css/Administrator.css">
</head>
<body>
<script src="../js/commonality.js"></script>
<div class="headerOut" id="hd">
	<div class="header">
		<!-- header -->
		<!-- 响应后的菜单 -->
		<div class="twoMenuBox">
			<div class="MenuList">
				<div class="onceMeun">
					<div class="title">
						<p class="ch"><a href="<%= request.getContextPath()%>/index">首页</a></p>
						<p class="en"><a href="<%= request.getContextPath()%>/index">Engsils</a></p>
					</div>
				</div>
				<div class="onceMeun">
					<div class="title">
						<p class="ch"><a href="<%= request.getContextPath()%>/product">产品展示</a></p>
						<p class="en"><a href="<%= request.getContextPath()%>/product">Engsils</a></p>
					</div>
				</div>
				<div class="onceMeun">
					<div class="title">
						<p class="ch"><a href="<%= request.getContextPath()%>/product">">技术服务</a></p>
						<p class="en"><a href="<%= request.getContextPath()%>/product">">Engsils</a></p>
					</div>
				</div>
				<div class="onceMeun">
					<div class="title">
						<p class="ch"><a href="<%= request.getContextPath()%>/product">">使用案例</a></p>
						<p class="en"><a href="<%= request.getContextPath()%>/product">">Engsils</a></p>
					</div>
				</div>
				<div class="onceMeun">
					<div class="title">
						<p class="ch"><a href="<%= request.getContextPath()%>/product">">文件下载</a></p>
						<p class="en"><a href="<%= request.getContextPath()%>/product">">Engsils</a></p>
					</div>
				</div>
				<div class="onceMeun">
					<div class="title">
						<p class="ch"><a href="">联系我们</a></p>
						<p class="en"><a href="">Engsils</a></p>
					</div>
				</div>
			</div>
		</div>
		<!-- logo盒子 -->
		<div class="logoBox">
			<a href="<%= request.getContextPath()%>/index"><img src="../img/logo.png" alt=""></a>
		</div>
		<!-- 响应前的菜单 -->
		<ul class="MenuBox">
			<!-- 一级菜单 -->
			<li>
				<div class="Chinese">
					<a href="<%= request.getContextPath()%>/index">首页</a>
				</div>
				<div class="English">
					<a href="<%= request.getContextPath()%>/index">English</a>
				</div>
				<!-- 二级菜单 -->
			</li>
			<li>
				<div class="Chinese">
					<a href="<%= request.getContextPath()%>/product">产品展示</a>
				</div>
				<div class="English">
					<a href="<%= request.getContextPath()%>/product">english</a>
				</div>
				<!-- 二级菜单 product display-->
				<div class="drodDisplay">
					<div class="drodDisplayCen">
						<!-- 左侧文字 -->
						<div class="DisplayLeftText">
							<h1 class="TextC">
								产品展示
							</h1>
							<h1 class="TextE">
								English
							</h1>
						</div>
						<!-- 右侧展示区 -->
						<div class="DisplayPicShow">
							<!-- 单个展示块 -->
							<div class="showRow">
								<div class="ShowBox">
									<img src="../img/20190329151738.jpg" alt="">
									<p>产品一号</p>
								</div>
								<!--  -->
								<div class="ShowBox">
									<img src="../img/20190329151738.jpg" alt="">
									<p>产品一号</p>
								</div>
								<!--  -->
								<div class="ShowBox">
									<img src="../img/20190329151738.jpg" alt="">
									<p>产品一号</p>
								</div>
							</div>
							<!--  -->
							<div class="showRow">
								<div class="ShowBox">
									<img src="../img/20190329151738.jpg" alt="">
									<p>产品一号</p>
								</div>
								<!--  -->
								<div class="ShowBox">
									<img src="../img/20190329151738.jpg" alt="">
									<p>产品一号</p>
								</div>
								<!--  -->
								<div class="ShowBox">
									<img src="../img/20190329151738.jpg" alt="">
									<p>产品一号</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</li>
			<li>
				<div class="Chinese">
					<a href="<%= request.getContextPath()%>/service">技术服务</a>
				</div>
				<div class="English">
					<a href="<%= request.getContextPath()%>/service">english</a>
				</div>
			</li>
			<li class="caseShow">
				<div class="Chinese">
					<a href="<%= request.getContextPath()%>/usecase">使用案例</a>
				</div>
				<div class="English">
					<a href="<%= request.getContextPath()%>/usecase">English</a>
				</div>
				<!-- 二级菜单 -->
				<div class="case">
					<div class="drodDisplayCen">
						<!-- 左侧文字 -->
						<div class="DisplayLeftText">
							<h1 class="TextC">
								使用案例
							</h1>
							<h1 class="TextE">
								English
							</h1>
						</div>
						<!-- 右侧展示区 -->
						<div class="DisplayPicShow">
							<!-- 单个展示块 -->
							<div class="showRow">
								<div class="ShowBox">
									<img src="../img/20190329151738.jpg" alt="">
									<p>案例一号</p>
								</div>
								<!--  -->
								<div class="ShowBox">
									<img src="../img/20190329151738.jpg" alt="">
									<p>案例一号</p>
								</div>
								<!--  -->
								<div class="ShowBox">
									<img src="../img/20190329151738.jpg" alt="">
									<p>案例一号</p>
								</div>
							</div>
							<!--  -->
							<div class="showRow">
								<div class="ShowBox">
									<img src="../img/20190329151738.jpg" alt="">
									<p>案例一号</p>
								</div>
								<!--  -->
								<div class="ShowBox">
									<img src="../img/20190329151738.jpg" alt="">
									<p>案例一号</p>
								</div>
								<!--  -->
								<div class="ShowBox">
									<img src="../img/20190329151738.jpg" alt="">
									<p>案例一号</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</li>
			<li class="downloadCase">
				<div class="Chinese">
					<a href="<%= request.getContextPath()%>/file_download">文件下载</a>
				</div>
				<div class="English">
					<a href="<%= request.getContextPath()%>/file_download">English</a>
				</div>
				<!-- 二级菜单 -->

			</li>
			<li id="callMe">
				<div class="Chinese">
					<a href="">联系我们</a>
				</div>
				<div class="English">
					<a href="">English</a>
				</div>
			</li>
		</ul>
		<div class="userBox">
			<div class="userProfile">
				<img src="../img/user.png" alt="">
			</div>
			<div class="userlogin">
				<div class="login">登陆</div>
				<a href="Administrator.jsp" class="managePage" >查看留言</a>
			</div>
		</div>
	</div>
</div>
<!-- Administrator_table -->
<div class="admTable">
	<table class="AmTb" border="1" cellspacing="0" >
		<tr>
			<td>序号</td>
			<td>内容</td>
			<td>姓名</td>
			<td>电话</td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
	</table>
	<div class="pageIndex">
		<div class="pageNum"><</div>
		<div class="pageNum">1</div>
		<div class="pageNum">2</div>
		<div class="pageNum">3</div>
		<div class="pageNum">4</div>
		<div class="pageNum">5</div>
		<div class="pageNum">6</div>
		<div class="pageNum">7</div>
		<div class="pageNum">8</div>
		<div class="pageNum">9</div>
		<div class="pageNum">10</div>
		<select class="pageRow" >
			<option >10条/页</option>
			<option>5条/页</option>
		</select>
		<p class="jumpTo">跳至</p>
		<input type="text" id="jump">
		<p class="ye">页</p>
	</div>
</div>
<!-- foot -->
<div class="pageBottomOut">
		<div class="pageBottom">
			<div class="kernelLeft">
				<h1 class="kernelLeftTit">关于我们的简介</h1>
				<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam sit nonummy nibh euismod tincidunt ut laoreet dolore magna aliquarm erat sit volutpat. Nostrud exerci tation ullamcorper suscipit lobortis nisl aliquip commodo consequat.</p>
			</div>
			<div class="kernelLeft">
				<h1 class="kernelLeftTit">我们的联系人</h1>
				<p>35, Lorem Lis Street, Park Ave</p>
				<p>California, US</p>
				<p>Phone: 300 323 3456</p>
				<p>Fax: 300 323 1456</p>
				<p>Email: <a href="">info@metronic.com</a></p>
				<p>Skype: metroni</p>
			</div>
			<div class="kernelRith">
				<h1 class="kernelRigth">关注我们</h1>
				<div class="contact">				
					<span class="iconfont icon-sina"></span>
					<span class="iconfont icon-weixin"></span>
				</div>
				<div class="QRcode">
					<!-- 二维码 -->
					<img src="../img/timg.jpg" alt="">
				</div>			
			</div>
		</div>
		<div class="pagebottomText">	
			<p>Copyright &copy 2018-鄂ICP备000000000000号-3鄂公网备 000000000000号</p>
		</div>
	</div>
<!--右侧联系我们-->
<!--返回顶层-->
<div class="pageUp">
	↑
</div>
<!--body遮罩层-->
</body>
</html>
<script type="text/javascript">
	
</script>