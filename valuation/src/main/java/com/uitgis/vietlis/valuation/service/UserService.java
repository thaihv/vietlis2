package com.uitgis.vietlis.valuation.service;

import com.uitgis.vietlis.valuation.domain.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
