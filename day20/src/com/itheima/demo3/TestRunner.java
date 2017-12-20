package com.itheima.demo3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRunner {

    public static void main(String[] args) throws IllegalArgumentException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
        //查看测试类中的方法，哪 个有@MyTest就执行哪个方法
        //test1();
        Class clazz = SomeDaoImpl.class;
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            //得到当前方法上的注解对象
            MyTest myTest = m.getAnnotation(MyTest.class);
            if (myTest != null) {//如果当前方法上有@MyTest注解
                long timeout = myTest.timeout();
                if (timeout < 0) {//表示不需要测试
                    m.invoke(clazz.newInstance(), null);
                } else {//需要测试
                    long l1 = System.nanoTime();//得到纳秒
                    m.invoke(clazz.newInstance(), null);
                    long l2 = System.nanoTime();//得到纳秒
                    if ((l2 - l1) > timeout) {
                        System.out.println(m.getName() + "方法超时！");
                    }
                }
            }

			/*if(myTest==null){//如果没有注解,不测试执行时间
                System.out.println("aaaaaaaaaaa");
				m.invoke(clazz.newInstance(), null);
			}else{
				long timeout = myTest.timeout();//得到注解的属性值
				long l1 = System.nanoTime();//得到纳秒
				m.invoke(clazz.newInstance(), null);
				long l2 = System.nanoTime();//得到纳秒
				if((l2-l1)>timeout){
					System.out.println(m.getName()+"方法超时！");
				}
			}*/
        }
    }

    private static void test1() throws IllegalAccessException,
            InvocationTargetException, InstantiationException {
        //得到要执行的类的Class对象
        Class clazz = SomeDaoImpl.class;
        //得到类中的方法,包括本类中和父类中的所有公共的方法
        Method[] methods = clazz.getMethods();
        //遍历所有方法
        for (Method m : methods) {
            //判断当前方法上是否有@MyTest注解
            boolean isExistsAnno = m.isAnnotationPresent(MyTest.class);
            System.out.println(m.getName() + "当前方法是否有注解：" + isExistsAnno);
            if (m.isAnnotationPresent(MyTest.class)) {
                m.invoke(clazz.newInstance(), null);
            }
        }
    }

}