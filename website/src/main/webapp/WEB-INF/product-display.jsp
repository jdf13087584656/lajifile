<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>product display</title>
<link rel="stylesheet" href="../css/iconfont.css">	
<link rel="stylesheet" href="../css/commonality.css">
<link rel="stylesheet" href="../css/proPage.css">
<link rel="stylesheet" href="../css/swiper.min.css">
</head>
<body>
<script src="../js/swiper.min.js"></script>
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
					产品展示
				</h1>
				<h1 class="TextE">
					English
				</h1>
			</div>
		</div>
	</div>		
</div>
	<!-- 公司介绍 company introduction-->
	<div class="copIductionOut">
		<div class="copIduction">
		<h1 class="ductionTitle">
			<!-- 公司介绍 -->
			公司介绍,使用纵向排版<br>
			单色背景图,与别的区块区分
		</h1>
		<p class="ductionEnglish">
			A title is one or more words used before or after a person's name, in certain contexts.<br> 
			It may signify either veneration, an official position, or a professional or academic qualification. In some languages,<br> 
			titles may be inserted between the first and last name (for example, 
			Graf in German, Cardinal in Catholic usage (Richard Cardinal Cushing) or clerical titles such as Archbishop).<br> 
			Some titles are hereditary.
		</p>
		</div>
	</div>
	<!-- 产品展示版块 -->
	<div class="technologyOut">
		<div class="technology">
		<div class="technologyText">
			<div class="techBigTitle">
				TECHNOLOGY
			</div>
			<div class="techLitTitle">
				<div class="techLitTitleLeft">
					精湛工艺
				</div>
				<div class="techLitTitleLeft">
					优雅美学
				</div>
			</div>
		</div>
		<div class="technologyCen">
			<!-- 如果要增加 复制304-321行代码 ,放在321行之面 -->
			<div class="technologyShowBox">
				<div class="technologyShow">
					<!-- 更改图片 -->
					<img src="../img/show_11.png" alt="">
					<!--  -->
					<div class="outBox">
						<h1 class="outBoxT">标题</h1>
						<p class="outBoxC">可以自己编辑的可以编辑4行超出部分变为省略号,可以自己编辑的可以编辑4行超出部分变为省略号,可以自己编辑的可以编辑4行超出部分变为省略号,可以自己编辑的可以编辑4行超出部分变为省略号,可以自己编辑的可以编辑4行超出部分变为省略号,可以自己编辑的可以编辑4行超出部分变为省略号,可以自己编辑的可以编辑4行超出部分变为省略号,</p>
						<a href="#" class="seeMore">查看系列</a>
					</div>
				</div>
				<div class="technologyShow">
					<!-- 更改图片 -->
					<img src="../img/show_22.png" alt="">
					<!--  -->
					<div class="outBox">
						<h1 class="outBoxT">标题</h1>
						<p class="outBoxC">可以自己编辑的内容</p>
						<a href="#" class="seeMore">查看系列</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	<div class="prDisOut">
		<div class="prDis">
			<div class="prDisLeft">
				<div class="prDisLeftCh">
					各类产品
				</div>
				<div class="prDisLeftEn">
					English
				</div>
			</div>
			<div class="prDisRight">
				<div class="prDisRightCh">
					简单文字介绍<br>
					用淡色背景,与公司介绍区分开来
				</div>
				<div class="prDisRightEn">
					A title is one or more words used before or after a person's name, in certain contexts.<br> 
				It may signify either veneration, an official position, or a professional or academic qualification. In some languages,<br> 
				titles may be inserted between the first and last name (for example, 
				Graf in German, Cardinal in Catholic usage (Richard Cardinal Cushing) or clerical titles such as Archbishop).<br> 
				Some titles are hereditary.
				</div>
			</div>
		</div>
	</div>
	<!-- 产品展示图片 -->
<!-- <h1 class="AllProText">各项产品</h1> -->
<div class="proPicOut">
	<div class="proPicOut">
	<!-- 在此处可以添加淘宝店铺跳转            跳转目标网址   ↓ -->
		<div class="proPic" onclick="window.location.href='https://www.baidu.com'">
		<div class="proPicTop">
			<div class="proPicTopLeft">
				<!-- 产品图片 -->
				<img src="../img/pro_1.png" alt="">
				<!-- 遮罩层 -->
				<div class="barrier">
					<div class="barrierText">
						<p class="proName">产品一</p>
						<p class="enName">English</p>
					</div>					
				</div>
				<!--  -->
			</div>
			<div class="proPicTopRight">
				<!-- 右侧上部 -->
				<div class="proPicTopRightTo">
					<!-- 产品图片 -->
					<img src="../img/20190329134640.jpg" alt="">
					<!-- 遮罩层 -->
					<div class="barrier">
						<div class="barrierText">
							<p class="proName">产品二</p>
							<p class="enName">English</p>
						</div>					
					</div>
				</div>
				<!-- 右侧下部 -->
				<div class="proPicTopRightBo">
					<!-- 右侧下部左 -->
					<div class="proPicTopRightBoLe">
						
						<!-- 产品图片 -->
						<img src="../img/show1.png" alt="">
						<!-- 遮罩层 -->
						<div class="barrier">
							<div class="barrierText">
								<p class="proName">产品三</p>
								<p class="enName">English</p>
							</div>					
						</div>
					</div>
					<!-- 右侧下部右 -->
					<div class="proPicTopRightBoRi">
						
						<!-- 产品图片 -->
					<img src="../img/20190329134640.jpg" alt="">
						<!-- <img src="" alt=""> -->
						<!-- 遮罩层 -->
						<div class="barrier">
							<div class="barrierText">
								<p class="proName">产品四</p>
								<p class="enName">English</p>
							</div>					
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
</div>

	<!-- fooot -->
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