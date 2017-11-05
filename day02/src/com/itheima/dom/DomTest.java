package com.itheima.dom;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DomTest {

    public static void main(String[] args) throws Exception {
        //创建解析器工厂
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        //通过解析器工厂得到解析器
        DocumentBuilder documentBuilder = builderFactory.newDocumentBuilder();
        //通过解析器得到Document对象
        Document document = documentBuilder.parse("src/book.xml");
        test1(document);
    }

    private static void test1(Document document) {

    }
}
