package com.niit.collaborate.restcontroller;

import java.util.ArrayList;

public interface BlogDAO {

	ArrayList<Blog> getBlogs();

	boolean createBlog(Blog blog);

}
