package com.inhatc.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.inhatc.domain.UserVO;
import com.inhatc.persistence.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	@Inject
	private UserDAO dao;

	@Override
	public int login(UserVO userVO) throws Exception {
		UserVO userInfo = dao.login(userVO);
		if (userInfo == null) {
			if (dao.idCheck(userVO)) {
				return 0;		// ��й�ȣ ����
			} else {
				return -1;		// �̰��� ȸ��
			}
		} else {
			return 1;			// ����
		}
	}

	@Override
	public UserVO getUserInfo(UserVO userVO) throws Exception {
		
		return dao.login(userVO);
	}

	@Override
	public String getAllergy(String userID) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
