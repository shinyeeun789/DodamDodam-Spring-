package com.inhatc.persistence;

import com.inhatc.domain.UserVO;

public interface UserDAO {
	// ȸ������
	// �α���
	// �α׾ƿ�
	
	// �α��� �õ�
	public UserVO login(UserVO userVO) throws Exception;
	// �˷����� ���� ��������
	public String getAllergy(String userID) throws Exception;
}
