<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>file download</title>
<link rel="stylesheet" href="../css/swiper.min.css">
<link rel="stylesheet" href="../css/iconfont.css">	
<link rel="stylesheet" href="../css/commonality.css">
<link rel="stylesheet" href="../css/download.css">
</head>
<body>
<script src="../js/swiper.min.js"></script>
<script src="../js/fileDownload.js"></script>

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
	<!-- bnner -->
	<!-- 轮播图 -->

<div class="bnnerSpacer">
	<div class="slideshow">
	<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<!-- bnner pic -->
					<img id="bnner_titles" src="../img/show12.png" alt="">
					<img src="../img/20190329151738.jpg" alt="">					
				</div>
				<div class="swiper-slide">
					<img src="../img/20190329134435.jpg" alt="">
				</div>
				<div class="swiper-slide">
					<img src="../img/20190329151837.jpg" alt="">
				</div>
				<div class="swiper-slide">
					<img src="../img/bnner_1.png" alt="">
				</div>
				<div class="swiper-slide">
					<img src="../img/bnner_2.png" alt="">
				</div>
			</div>
		</div>
		<div class="leftTitle">
			<div class="DisplayLeftText">
				<h1 class="TextC">
					文件下载
				</h1>
				<h1 class="TextE">
					English
				</h1>
			</div>
		</div>
	</div>		
</div>
<!-- 热门文件下载 -->
<div class="copIductionOut">
	<div class="hotFile">
		<div class="serviceTop">
			<a href="">TOP</a>
			<p class="CallTe">文件下载</p>
		</div>
		<!-- 下载内容 -->
		<h1 class="hotFileTitle">热门文件下载</h1>
		<!-- 单独文件 如果需要增加文件 复制259-269行代码向最后添加 默认只显示4个文件 如果需要请点击查看更多 -->
		<!-- 1 -->
		<div id="FileBox">
			<div class="onlyFile">
				<div class="FileNum">01</div>
				<div class="FileList">
					<p class="FileName"><a href="#">文件全名,超链点击下载鼠标悬停变颜色,加下划线文件名超过两行自动隐藏超出部分并转化为省略号XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</a></p>
					<p class="FileIntro">简单描述,一行显示,超出部分转换为省略号XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</p>
				</div>
			</div>
			<!-- 2 -->
			<div class="onlyFile">
				<div class="FileNum">02</div>
				<div class="FileList">
					<p class="FileName"><a href="#">文件全名,超链点击下载鼠标悬停变颜色,加下划线文件名超过两行自动隐藏超出部分并转化为省略号XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</a></p>
					<p class="FileIntro">简单描述,一行显示,超出部分转换为省略号XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</p>
				</div>
			</div>
			<!-- 3 -->
			<div class="onlyFile">
				<div class="FileNum">03</div>
				<div class="FileList">
					<p class="FileName"><a href="#">文件全名,超链点击下载鼠标悬停变颜色,加下划线文件名超过两行自动隐藏超出部分并转化为省略号XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</a></p>
					<p class="FileIntro">简单描述,一行显示,超出部分转换为省略号XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</p>
				</div>
			</div>
			<!-- 4 -->
			<div class="onlyFile">
				<div class="FileNum">04</div>
				<div class="FileList">
					<p class="FileName"><a href="#">文件全名,超链点击下载鼠标悬停变颜色,加下划线文件名超过两行自动隐藏超出部分并转化为省略号XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</a></p>
					<p class="FileIntro">简单描述,一行显示,超出部分转换为省略号XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</p>
				</div>
			</div>
			<!-- 如果需要增加问题 在此行后进行添加 ↓ -->
			<div class="onlyFile">
				<div class="FileNum">05</div>
				<div class="FileList">
					<p class="FileName"><a href="#">文件全名,超链点击下载鼠标悬停变颜色,加下划线文件名超过两行自动隐藏超出部分并转化为省略号XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</a></p>
					<p class="FileIntro">简单描述,一行显示,超出部分转换为省略号XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</p>
				</div>
			</div>
			<div class="onlyFile">
				<div class="FileNum">06</div>
				<div class="FileList">
					<p class="FileName"><a href="#">文件全名,超链点击下载鼠标悬停变颜色,加下划线文件名超过两行自动隐藏超出部分并转化为省略号XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</a></p>
					<p class="FileIntro">简单描述,一行显示,超出部分转换为省略号XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</p>
				</div>
			</div>
			<div class="onlyFile">
				<div class="FileNum">07</div>
				<div class="FileList">
					<p class="FileName"><a href="#">文件全名,超链点击下载鼠标悬停变颜色,加下划线文件名超过两行自动隐藏超出部分并转化为省略号XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</a></p>
					<p class="FileIntro">简单描述,一行显示,超出部分转换为省略号XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX</p>
				</div>
			</div>
			<!-- 新增问价添加在上一行 ↑ -->
			<!-- -////////////////////////////////////// -->
		</div>		
		<!-- see more -->
		<div class="seeMore">
			<div class="MoreLeft">→</div>
			<p class="moreRight" id="see_more"><a href="#">查看更多</a></p>
			<p class="upList">收起</p>
		</div>
	</div>
</div>
<!-- 底部 -->
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
<div class="rightExerciseMe">
	<div id="rightExeTopBox"></div>
	<p class="RightExeText">
		联系我们
	</p>
</div>
<!--返回顶层-->
<div class="pageUp">
	↑
</div>
<!--body遮罩层-->
<div class="bodyShow"></div>
<div class="Ask">
		<p class="ATextRowO">快速反馈</p>
		<p class="ATextRowT">我们将听取您的意见/问题 </p>
		<div class="InputOne">
			<input id="name" type="text" placeholder="姓名">
			<input id="email" type="text" placeholder="邮箱地址">
		</div>
		<div class="InputTow">
			<textarea class="textDiv"  placeholder="您的问题或意见" rows="10"></textarea>
		</div>
		<div class="subBtn">
			提交问题/意见
		</div>
	</div>
</body>
</html>