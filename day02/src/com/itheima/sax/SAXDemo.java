package com.itheima.sax;

import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXDemo {
    public static void main(String[] args) throws Exception {

        //使用SAXParserFactory创建SAX解析工厂
        SAXParserFactory saxParserFactory=SAXParserFactory.newInstance();
        //通过SAX解析工厂得到解析器对象
        SAXParser saxParser = saxParserFactory.newSAXParser();
        //通过解析器对象得到一个XML的读取器
        XMLReader xmlReader=saxParser.getXMLReader();

    }

}
