package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.BookDaoImpl;
import com.itheima.domain.Book;
import com.itheima.domain.PageBean;

public class BookServiceImpl {

    BookDaoImpl bookDao = new BookDaoImpl();

    public List<Book> findAllBooks() {
        try {
            return bookDao.findAllBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addBook(Book book) {
        try {
            bookDao.addBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book findBookById(String id) {
        try {
            return bookDao.findBookById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateBook(Book book) {
        try {
            bookDao.updateBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(String id) {
        try {
            bookDao.delBook(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleAllBooks(String[] ids) {
        try {
            bookDao.deleAllBooks(ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice) {
        try {
            return bookDao.searchBooks(id, category, name, minprice, maxprice);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public PageBean findBooksPage(int currentPage, int pageSize) {
        try {
            int count = bookDao.count();//从数据库得到总记录数
            int totalPage = (int) Math.ceil(count * 1.0 / pageSize); //求出总页数
            List<Book> books = bookDao.findBooks(currentPage, pageSize);

            //把5个变量封装到PageBean中，做为返回值
            PageBean pb = new PageBean();
            pb.setBooks(books);

//            pb.setProducts();
            pb.setCount(count);
            pb.setCurrentPage(currentPage);
            pb.setPageSize(pageSize);
            pb.setTotalPage(totalPage);

            return pb;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 根据书名查找图书 模糊查询
    public List<Object> searchBookByName(String name) {
        try {
            return bookDao.searchBookByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
