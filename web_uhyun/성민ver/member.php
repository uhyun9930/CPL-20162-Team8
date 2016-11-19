<script>
 function chk_frm(){
   if(!document.join.email.value){
    window.alert('이메일을 입력해 주세요');
    document.join.email.focus();
    return false;
   }   
   if(!document.join.pw.value){
    window.alert('비밀번호를 입력해 주세요');
    document.join.pw.focus();
    return false;
   }

   if(!document.join.name.value){
    window.alert('이름를 입력해 주세요');
    document.join.name.focus();
    return false;
   }

    
 
 return true;  
 }

</script>

<form action="member_post.php" method="post" onsubmit="return chk_frm()" name="join">
  <title> 회원가입 </title>

 <body>
 <table width=550 border=1 align=center>
 <tr>
  <td colspan=2 bgcolor=#99cc00 align=center>회원가입
 <tr>
  <td>이메일
  <td><input type=text name=email size=20 maxlength=20>
 <tr>
  <td>비밀번호
  <td><input type=password name=pw size=20 maxlength=20>
 <tr>
  <td>이름
  <td><input type=text name=name size=20 maxlength=20>
 <tr>
  <td bgcolor=#eeeeee colspan=2 align=center>
  <input type=submit value='회원가입'>
</table>
</form>
 