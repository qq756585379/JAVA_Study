package com.itheima.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Book;
import com.itheima.util.C3P0Util;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class BookDaoImpl {

    /**
     * 查找所有图书
     *
     * @return
     * @throws SQLException
     */
    public List<Book> findAllBooks() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from book", new BeanListHandler<Book>(Book.class));
    }

    /**
     * 添加图书信息
     *
     * @param book
     * @throws SQLException
     */
    public void addBook(Book book) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        System.out.println(book.getName() + book.getCategory() + book.getDescription() + "");
        qr.update("INSERT INTO book VALUES(?,?,?,?,?,?,?)", book.getId(), book.getName(), book.getPrice(),
                book.getPnum(), book.getCategory(), book.getDescription(), book.getImg_url());
    }

    public Book findBookById(String id) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from book where id=?", new BeanHandler<Book>(Book.class), id);
    }

    /**
     * 修改图书信息
     *
     * @param book
     * @throws SQLException
     */
    public void updateBook(Book book) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update book set name=?,price=?,pnum=?,category=?,description=? where id=?",
                book.getName(), book.getPrice(), book.getPnum(), book.getCategory(), book.getDescription(), book.getId());
    }

    /**
     * 根据id删除图书
     *
     * @param id
     * @throws SQLException
     */
    public void delBook(String id) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("delete from book where id=?", id);
    }

    /**
     * 批量删除
     *
     * @param ids
     * @throws SQLException
     */
    public void deleAllBooks(String[] ids) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        Object[][] params = new Object[ids.length][];
        for (int i = 0; i < params.length; i++) {
            params[i] = new Object[]{ids[i]};//循环给每个一维数组中的元素赋值，值是id
        }
        qr.batch("delete from book where id=?", params);
    }

    /**
     * 多条件查询图书
     *
     * @param id
     * @param category
     * @param name
     * @param minprice
     * @param maxprice
     * @return
     * @throws SQLException
     */
    public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice)
            throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        String sql = "select * from book where 1=1";
        List list = new ArrayList();
        if (!"".equals(id.trim())) {
            sql += " and id like ?"; //  不能在这写%   %'1002'%
            list.add("%" + id.trim() + "%");// '%1002%'
        }
        if (!"".equals(category.trim())) {
            sql += " and category=?";
            list.add(category.trim());
        }
        if (!"".equals(name.trim())) {
            sql += " and name like ?";
            list.add("%" + name.trim() + "%");
        }
        if (!"".equals(minprice.trim())) {
            sql += " and price>?";
            list.add(minprice.trim());
        }
        if (!"".equals(maxprice.trim())) {
            sql += " and price< ?";
            list.add(maxprice.trim());
        }
        return qr.query(sql, new BeanListHandler<Book>(Book.class), list.toArray());
    }

    /**
     * 得到总记录数
     *
     * @return
     * @throws SQLException
     */
    public int count() throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        long l = (Long) qr.query("select count(*) from book", new ScalarHandler(1));
        return (int) l;
    }

    /**
     * 查找分页数据
     *
     * @param currentPage
     * @param pageSize
     * @return
     * @throws SQLException
     */
    public List<Book> findBooks(int currentPage, int pageSize) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from book limit ?,?",
                new BeanListHandler<Book>(Book.class), (currentPage - 1) * pageSize, pageSize);
    }

    /**
     * 根据书名查找图书 模糊查询
     *
     * @param name
     * @return
     * @throws SQLException
     */
    public List<Object> searchBookByName(String name) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select name from book where name like ?", new ColumnListHandler(), "%" + name + "%");
    }
}
