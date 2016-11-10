<script>
 function chk_frm(){
   if(!document.join.user_id.value){
    window.alert('아이디를 입력해 주세요');
    document.join.user_id.focus();
    return false;
   }
   
   if(!document.join.pw.value){
    window.alert('비밀번호를 입력해 주세요');
    document.join.pw.focus();
    return false;
   }
   if(!document.join.email.value){
    window.alert('이메일을 입력해 주세요');
    document.join.email.focus();
    return false;
   }
    
    
 
 return true;  
 }

</script>
 

<form action="join.php" method="post" onsubmit="return chk_frm()" name="join">
  <title> 회원가입 </title>

 <body>
 <table width=550 border=1 align=center>
 <tr>
  <td colspan=2 bgcolor=#99cc00 align=center>회원가입
 <tr>
  <td>아이디
  <td><input type=text name=user_id size=10 maxlength=20>

 <tr>
  <td>비밀번호
  <td><input type=password name=pw size=10 maxlength=20>
 <tr>
  <td>이름
  <td><input type=text name=name size=10 maxlength=20>
 <tr>
  <td>E-Mail
  <td><input type=text name=email size=30 maxlength=30>
 <tr>
  <td>자기소개
  <td><textarea name=memo rows=5 cols=50></textarea>
 <tr>
  <td bgcolor=#eeeeee colspan=2 align=center>
  <input type=submit value='회원가입'>
</table>
</form>