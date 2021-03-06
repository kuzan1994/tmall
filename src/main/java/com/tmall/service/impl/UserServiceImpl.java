package com.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmall.mapper.UserMapper;
import com.tmall.pojo.User;
import com.tmall.pojo.UserExample;
import com.tmall.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper mapper;
	@Override
	public void add(User user) {
		mapper.insert(user);
	}

	@Override
	public void delete(int id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(User user) {
		mapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public User get(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public List<User> list() {
		UserExample example = new UserExample();
		example.setOrderByClause("id desc");
		return mapper.selectByExample(example);
	}

	@Override
	public Boolean isExist(String name) {
		UserExample example = new UserExample();
		example.createCriteria().andNameEqualTo(name);
		List<User> users = mapper.selectByExample(example);
		if (users.isEmpty()) {
			return false;
		}
		return true;
	}

	@Override
	public User get(String name, String password) {
		UserExample example = new UserExample();
		example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
		List<User> users = mapper.selectByExample(example);
		if (users.isEmpty()) {
			return null;
		}
		return users.get(0);
	}

}
