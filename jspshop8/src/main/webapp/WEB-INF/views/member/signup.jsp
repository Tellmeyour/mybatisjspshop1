<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에게모니 회원가입</title>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="/resources/css/index2.css" rel="stylesheet">
<link href="/resources/css/signup.css" rel="stylesheet">


</head>
<body>

<div id="page-wrapper">
  <!-- 사이드바 -->
  <div id="sidebar-wrapper">
    <ul class="sidebar-nav">
      <li class="sidebar-brand">
        <a href="/">에게모니</a>
      </li>
      	<input type="text" class="form-control me-2" placeholder="검색" maxlength="20"/>
      <br/>  
      <p class="acountbuttons" style="text-align: center;">
     	<span><a href="#">로그인</a></span>
     	<span><a href="/signup">회원가입</a></span>
     	<span><a href="#">Mypage</a></span>
   		<span><a href="#">Cart(0)</a></span>
      </p>
      <li>-</li>
      <br/>
      <li><a href="#">Top</a></li>
      <li><a href="#">Bottom</a></li>
      <li><a href="#">Cap</a></li>
      <li>-</li>
      <br/>
      <li><a href="/board/free">자유게시판</a></li>
      <li><a href="/board/suggestion">건의게시판</a></li>
      <li><a href="/board/write">게시판</a></li>
      <li>-</li>
      <br/>
      <li>CS CENTER</li>
      <li>070-4193-9293</li>
      <li>토요일, 일요일, 공휴일 제외</li>
      <li>평일 09:00 ~ 18:00</li>
      <li>-</li>
      <br/>
      <li><a href="#">메뉴 4</a></li>
      <li><a href="#">메뉴 5</a></li>
      <li><a href="#">메뉴 6</a></li>
      <li><a href="#">메뉴 7</a></li>
      <li><a href="#">메뉴 8</a></li>
      <li><a href="#">메뉴 9</a></li>
      <li><a href="#">메뉴 1</a></li>
      <li><a href="#">메뉴 2</a></li>
      <li><a href="#">메뉴 3</a></li>
      <li><a href="#">메뉴 4</a></li>
      <li><a href="#">메뉴 5</a></li>
      <li><a href="#">메뉴 6</a></li>
      <li><a href="#">메뉴 7</a></li>
      <li><a href="#">메뉴 8</a></li>
      <li><a href="#">메뉴 9</a></li>
      
    </ul>
  </div>
  <!-- /사이드바 -->

  <!-- 본문 -->
  
  <div id="page-content-wrapper">
    <div class="container-fluid">
      <div class="row">
			<form id="join_form" method="post" action="/member/signup">
				<div>
					<h2>회원가입</h2>
				</div>
				<div>
					<label>아이디</label>
					<input type="text" id="userid" class="form-control" placeholder="아이디" maxlength="13" title="아이디 입력" autocomplete="off"/>
					<div>
						<span id="idMsg" class="error_next_box" style="display:none;" aria-live="assertive"></span>
					</div>
				</div><br/>	
				<div>				
					<label for="pswd1">비밀번호</label>		
					<span class="ps_box_int_pass" id="pswd1Img">  
						<input type="password" id="pswd1" class="form-control" placeholder="비밀번호" title="비밀번호 입력" maxlength="25"  autocomplete="off"/>
						<span class="lbl">
							<span id="pswd1Span" class="step_txt"></span>
						</span>								
					</span>
					<span id="pswd1Msg" class="error_next_box" aria-live="assertive" style="display: none;">5~12자의 영문 소문자, 숫자와 특수기호(_)만 사용 가능합니다.</span>
				</div><br/>	
				
				<!-- <div>
					<label>비밀번호</label>
					<input type="password" id="pswd1" class="form-control" placeholder="비밀번호" maxlength="25"/>
					<div id="pswd1Msg" class="error_next_box" aria-live="assertive" style="display: none;">5~12자의 영문 소문자, 숫자와 특수기호(_)만 사용 가능합니다.</div>
				</div><br/>	 -->
				<div>
					<label>비밀번호 확인</label>
					<input type="password" id="pswd2" class="form-control"  placeholder="비밀번호 확인" maxlength="25" autocomplete="off"/>
					<span id="pswd2Msg" class="error_next_box" aria-live="assertive" style="display: none;"></span>
				</div><br/>
				<button class="btn btn-primary pull-right" type="button" id="btnjoin">
					<span>가입하기</span>
				</button>
			</form>
		</div>
    </div>
  </div>
  <!-- /본문 -->
</div>



	<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script type="text/javascript" src="/resources/js/signup.js"></script>
</body>
</html>