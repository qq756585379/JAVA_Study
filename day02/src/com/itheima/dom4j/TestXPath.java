package com.itheima.dom4j;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.util.List;

public class TestXPath {

    //XPath解析依赖dom4j和jaxen包
    //dtd约束没有schema严格，解析主要采用dom4j和xpath结合

    @Test
    public void test() throws Exception {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/book.xml");
        Node node = document.selectSingleNode("/书架/书[1]/书名");
        System.out.println(node.getText());
    }

    @Test
    public void test2() throws Exception {
        SAXReader read = new SAXReader();
        Document document = read.read("src/book.xml");
        List list = document.selectNodes("//*");
        for (int i = 0; i < list.size(); i++) {
            Node node = (Node) list.get(i);
            System.out.println(node.getName() + "\t" + node.getText());
        }
    }

    @Test
    public void test1() throws Exception {
        SAXReader read = new SAXReader();
        Document document = read.read("src/test.xml");
        List nodes = document.selectNodes("/bookstore//book/title");
        for (int i = 0; i < nodes.size(); i++) {
            Node node = (Node) nodes.get(i);
            System.out.println(node.getText());
        }
    }
}
