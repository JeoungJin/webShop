<!doctype html>
<html lang="ko">
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>
  
<script type="text/javascript">
  var email;
  var access_token;
  var naver_id_login = new naver_id_login("E2xeeVfWxpjGRQ_67gpS" );
  // 접근 토큰 값 출력
  access_token = naver_id_login.oauthParams.access_token ;
  // 네이버 사용자 프로필 조회
  naver_id_login.get_naver_userprofile("naverSignInCallback()");
  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
  function naverSignInCallback() {
	 email = naver_id_login.getProfileData('email');
	 nickname = naver_id_login.getProfileData('nickname') ;
	 
    $("#email", top.opener.document).val(email);
    $("#nickname", top.opener.document).val(nickname);
    $("#access_token", top.opener.document).val(access_token);
    
    $("#myfrm", top.opener.document).submit();
    window.close();
    
    //top.opener.location.href = "http://localhost:9090/webShop/navertest/naver?access_token=" + access_token + "&email=" +email +"&nickname=" + nickname;
    
  
  }
  
   
  
</script>
</body>
</html>