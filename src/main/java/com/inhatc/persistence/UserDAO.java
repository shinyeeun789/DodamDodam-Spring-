package com.inhatc.persistence;

import com.inhatc.domain.UserVO;

public interface UserDAO {
	// 1. ȸ������
	
	// 2. �α���
	public UserVO login(UserVO userVO) throws Exception;	// �α��� �õ�
	
	public boolean idCheck(UserVO userVO) throws Exception;	// ID Ȯ�� (ȸ������ ���� Ȯ��)
	
	// 3. �α׾ƿ�
	
	
	// �˷����� ���� ��������
	public String getAllergy(String userID) throws Exception;
}
