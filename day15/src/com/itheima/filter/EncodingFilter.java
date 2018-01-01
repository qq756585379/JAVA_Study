package com.itheima.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import javax.servlet.ServletException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 通用解决 get 和 post乱码过滤器
 */
public class EncodingFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 处理请求乱码
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletRequest myRequest = new MyRequest(httpServletRequest);

        // 处理响应乱码
        //response.setContentType("text/html;charset=utf-8");

        chain.doFilter(myRequest, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("EncodingFilter---init");
    }

    public void destroy() {
        System.out.println("EncodingFilter---destroy");
    }
}

// 自定义request对象
class MyRequest extends HttpServletRequestWrapper {

    private HttpServletRequest request;

    private boolean hasEncode;

    public MyRequest(HttpServletRequest request) {
        super(request);// super必须写
        this.request = request;
        System.out.println("MyRequest---init");
    }

/*
    @Override
    public String getParameter(String name) {
        name = request.getParameter(name);
        try {
            return new String(name.getBytes("iso-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
*/

    @Override
    public Map getParameterMap() {
        // 先获得请求方式
        String method = request.getMethod();
        if (method.equalsIgnoreCase("post")) {
            try {
                request.setCharacterEncoding("utf-8");
                System.out.println("request.getParameterMap = " + request.getParameterMap());
                return request.getParameterMap();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        } else if (method.equalsIgnoreCase("get")) {
            Map<String, String[]> parameterMap = request.getParameterMap();// 乱码
            if (!hasEncode) { // 确保get手动编码逻辑只运行一次
                for (String parameterName : parameterMap.keySet()) {
                    String[] values = parameterMap.get(parameterName);
                    if (values != null) {
                        for (int i = 0; i < values.length; i++) {
                            try {
                                values[i] = new String(values[i].getBytes("ISO-8859-1"), "utf-8");
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                hasEncode = true;
            }
            return parameterMap;
        }
        return super.getParameterMap();
    }

    @Override
    public String getParameter(String name) {
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        if (values == null) {
            return null;
        }
        return values[0]; // 取回参数的第一个值
    }

    @Override
    public String[] getParameterValues(String name) {
        Map<String, String[]> parameterMap = getParameterMap();
        String[] values = parameterMap.get(name);
        return values;
    }
}
