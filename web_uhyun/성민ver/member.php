<script>
 function chk_frm(){
   if(!document.join.email.value){
    window.alert('�̸����� �Է��� �ּ���');
    document.join.email.focus();
    return false;
   }   
   if(!document.join.pw.value){
    window.alert('��й�ȣ�� �Է��� �ּ���');
    document.join.pw.focus();
    return false;
   }

   if(!document.join.name.value){
    window.alert('�̸��� �Է��� �ּ���');
    document.join.name.focus();
    return false;
   }

    
 
 return true;  
 }

</script>

<form action="member_post.php" method="post" onsubmit="return chk_frm()" name="join">
  <title> ȸ������ </title>

 <body>
 <table width=550 border=1 align=center>
 <tr>
  <td colspan=2 bgcolor=#99cc00 align=center>ȸ������
 <tr>
  <td>�̸���
  <td><input type=text name=email size=20 maxlength=20>
 <tr>
  <td>��й�ȣ
  <td><input type=password name=pw size=20 maxlength=20>
 <tr>
  <td>�̸�
  <td><input type=text name=name size=20 maxlength=20>
 <tr>
  <td bgcolor=#eeeeee colspan=2 align=center>
  <input type=submit value='ȸ������'>
</table>
</form>
 