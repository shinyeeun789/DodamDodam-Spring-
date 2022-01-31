package com.inhatc.persistence;

import com.inhatc.domain.UserVO;

public interface UserDAO {
	
	public void join(UserVO userVO) throws Exception;
	
	// �α��� �õ�
	public UserVO login(UserVO userVO) throws Exception;
	
	// ����� ���� ��������
	public UserVO getUserInfo(UserVO userVO) throws Exception;
	
	// ID Ȯ�� (ȸ������ ���� Ȯ��)
	public boolean idCheck(UserVO userVO) throws Exception;
	
	// NAME Ȯ��
	public boolean nameCheck(UserVO userVO) throws Exception;
	
	// �˷����� ���� ��������
	public String getAllergy(String userID) throws Exception;
	
	// �˷����� ���� ������Ʈ�ϱ�
	public int updateAllergy(UserVO userVO) throws Exception;
	
	// �̸� ���� ������Ʈ�ϱ�
	public int updateUserName(UserVO userVO) throws Exception;
}
