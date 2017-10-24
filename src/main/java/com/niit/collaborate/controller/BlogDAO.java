package com.niit.collaborate.controller;

import java.util.ArrayList;

public interface BlogDAO {

	ArrayList<Blog> getBlogs();

	boolean createBlog(Blog blog);

}
