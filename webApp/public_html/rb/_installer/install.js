var ingInstall = false;
function install(obj)
{
	if (ingInstall == true)
	{
		alert('서버작업을 진행하고 있습니다. 잠시 기다려 주세요.');
		return false;
	}
	if (confirm('정말로 설치하시겠습니까?       '))
	{
		obj.style.width = '400px';
		obj.style.fontSize = '13px';
		obj.style.color = '#000000';
		obj.style.background = '#666666';
		obj.value = '압축해제/퍼미션 조정중.. 잠시만 기다려 주세요.';
		ingInstall = true;
		location.href = './install.php?install=Y';
	}
}
function permCheck()
{
	alert('설치폴더의 퍼미션을 확인해 주세요.    ');
}
function saveCheck(f)
{
	if (ingInstall == true)
	{
		alert('서버작업을 진행하고 있습니다. 잠시 기다려 주세요.');
		return false;
	}
	if (f.host.value == '')
	{
		alert('도메인(또는 IP)을 입력해 주세요.   ');
		f.host.focus();
		return false;
	}
	if (f.port.value == '')
	{
		alert('포트번호를 입력해 주세요.   ');
		f.port.focus();
		return false;
	}
	if (f.id.value == '')
	{
		alert('아이디를 입력해 주세요.   ');
		f.id.focus();
		return false;
	}
	if (f.pw.value == '')
	{
		alert('패스워드를 입력해 주세요.   ');
		f.pw.focus();
		return false;
	}

	if (confirm('정말로 작업을 진행하시겠습니까?       '))
	{
		document.getElementById('_submit_btn_').style.color = '#000000';
		document.getElementById('_submit_btn_').style.background = '#666666';
		document.getElementById('_submit_btn_').value = '서버작업중..';
		ingInstall = true;
		return true;
	}
	return false;
}
