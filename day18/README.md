# Listener/filter

监听器介绍

什么是监听器 Javaweb中的监听器是用于监听web常见对象HttpServletRequest,HttpSession,ServletContext

2.监听器的作用

	1.监听web对象创建与销毁.
	2.监听web对象的属性变化
	3.监听session绑定javaBean操作.
	
3.监听机制相关概念

	1.事件----一件事情
	2.事件源---产生这件事情的源头
	3.注册监听---将监听器与事件绑定，当事件产生时，监听器可以知道，并进行处理。
	4.监听器---对某件事情进行处理监听的一个对象

web监听器介绍

1.javaweb监听器介绍
			
	1.监听web对象创建与销毁的监听器
		ServletContextListener
		HttpSessionListener
		ServletRequestListener	
		
	2.监听web对象属性变化
		ServletContextAttributeListener
		HttpSessionAttributeListener
		ServletRequestAttributeListener	
		
	3.监听session绑定javaBean
		HttpSessionBindingListener
		HttpSessionActivationListener
		
javaweb监听器创建步骤

创建一个类，实现指定的监听器接口	
重写接口中的方法.

在web.xml文件中配置监听

演示监听对象创建与销毁

	1.ServletContext对象的创建与销毁监听
		ServletContext对象的创建与销毁分析
		ServletContext对象是服务器开启时创建。服务器关闭时销毁。
		监听ServletContext对象的创建与销毁

	2.HttpSession对象的创建与销毁监听
	
1.HttpSession对象的创建与销毁分析

	session对象创建:取决于请求中是否有jsessinid，如果有，可能会获取一个已经存在的session对象。
	如果没有，会创建一个新的session对象.
	
	销毁session：
		1.默认超时  30分钟
		2.关闭服务器
		3.invalidate()方法
		4.setMaxInactiveInterval(int interval) 可以设置超时时间
		
2.监听HttpSession对象的创建与销毁

3.HttpServletRequest对象的创建与销毁监听

	1.HttpServletRequest对象的创建与销毁分析
	request对象是发送请求时创建，当响应产生时，销毁.
	2.监听HttpServletRequest对象的创建与销毁
