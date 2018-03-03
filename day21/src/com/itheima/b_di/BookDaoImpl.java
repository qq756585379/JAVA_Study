package com.itheima.b_di;

public class BookDaoImpl implements BookDao {

	@Override
	public void save() {
		System.out.println("BookDao di  add book");
	}

}
