<?php

class TrashVO
{
	var $trashSrl;
	var $title;
	var $originModule;
	var $serializedObject;
	var $description;
	var $ipaddress;
	var $removerSrl;
	var $userId;
	var $nickName;
	var $regdate;

	function getTrashSrl()
	{
		return $this->trashSrl;
	}
	function setTrashSrl($trashSrl)
	{
		$this->trashSrl = $trashSrl;
	}
	function getTitle()
	{
		if(empty($this->title)) return $lang->untitle;
		return htmlspecialchars($this->title);
	}
	function setTitle($title)
	{
		$this->title = $title;
	}
	function getOriginModule()
	{
		if(empty($this->originModule)) return 'document';
		return $this->originModule;
	}
	function setOriginModule($originModule)
	{
		$this->originModule = $originModule;
	}
	function getSerializedObject()
	{
		return $this->serializedObject;
	}
	function setSerializedObject($serializedObject)
	{
		$this->serializedObject = $serializedObject;
	}
	function getDescription()
	{
		return htmlspecialchars($this->description);
	}
	function setDescription($description)
	{
		$this->description = $description;
	}
	function getIpaddress()
	{
		return $this->ipaddress;
	}
	function setIpaddress($ipaddress)
	{
		$this->ipaddress = $ipaddress;
	}
	function getRemoverSrl()
	{
		return $this->removerSrl;
	}
	function setRemoverSrl($removerSrl)
	{
		$this->removerSrl = $removerSrl;
	}
	function getUserId()
	{
		return $this->userId;
	}
	function setUserId($userId)
	{
		$this->userId = $userId;
	}
	function getNickName()
	{
		return htmlspecialchars($this->nickName);
	}
	function setNickName($nickName)
	{
		$this->nickName = $nickName;
	}
	function getRegdate()
	{
		if(empty($this->regdate)) return date('YmdHis');

		return $this->regdate;
	}
	function setRegdate($regdate)
	{
		$this->regdate = $regdate;
	}
}

/* End of file Trash.php */
/* Location: ./modules/trash/model/Trash.php */
