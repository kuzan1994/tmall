package com.tmall.mapper;

import java.util.List;

import com.tmall.pojo.Category;
import com.tmall.util.Page;

public interface CategoryMapper {
	List<Category> list(Page page);
	int total();
	void add(Category category);
	void delete(int id);
	Category get(int id);
	void update(Category category);
}
