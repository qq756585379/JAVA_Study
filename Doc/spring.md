```
1.导入jar包：4+1  --> beans/core/context/expression  | commons-logging
2.编写目标类：dao和service
3.spring配置文件
4.核心api
	BeanFactory，延迟实例化bean，第一次调用getBean
	ApplicationContext 一般常用，功能更强
		ClassPathXmlApplicationContext 加载classpath xml文件
		FileSystemXmlApplicationContext 加载指定盘符文件 
		 ServletContext.getRealPath()
```

```

IoC：<bean id="" class="" >
DI：<bean> <property name="" value="" | ref="">

实例化方式：
  默认构造
  静态工厂：<bean id="" class="工厂类" factory-method="静态方法">
  实例工厂：<bean id="工厂id" class="工厂类"> 
   <bean id="" factory-bean="工厂id" factory-method="方法">
   
作用域：<bean id="" class="" scope="singleton | prototype">

生命周期：<bean id="" class="" init-method="" destroy-method="">
  后处理bean  BeanPostProcessor接口，<bean class="注册"> ，对容器中所有的bean都生效
  
属性注入
  构造方法注入：<bean><constructor-arg index="" type="" >
  setter方法注入：<bean><property>
  p命名空间：简化<property>   <bean p:属性名="普通值"  p:属性名-ref="引用值">  
  注意声明命名空间
  SpEL：<property name="" value="#{表达式}">
     #{123}  #{'abc'}
     #{beanId.propName?.methodName()}
     #{T(类).静态方法|字段}
  集合
     数组<array>
     List <list>
     Set <set>
     Map <map><entry key="" value="">
     Properties <props><prop key="">....
     
```

### 后处理bean 对一个生效

```
@Override
public Object postProcessBeforeInitialization(Object bean, String beanName) 
throws BeansException {
		if("userServiceId".equals(beanName)){
			System.out.println("前方法 ： " + beanName);
		}
		return bean;
	}
```

### 注解

```
1.扫描含有注解的类
	<context:component-scan base-package="....">
2.常见的注解
	@Component  组件，任意bean
	WEB
		@Controller  web层
		@Service service层
		@Repository dao层
	注入  --> 字段或setter方法
		普通值：@Value
		引用值：
			类型：@Autowired
			名称1：@Autowired  @Qualifier("名称")
			名称2：@Resource("名称")
	作用域：@Scope("prototype") 
	生命周期：
		初始化：@PostConstruct
		销毁方法：@PreDestroy

```

### 注解和xml混合使用

```
1.将所有的bean都配置xml中
	<bean id="" class="">
2.将所有的依赖都使用注解
	@Autowired
	默认不生效。为了生效，需要在xml配置：<context:annotation-config>

总结：
注解1：<context:component-scan base-package=" ">
注解2：<context:annotation-config>
1.一般情况两个注解不一起使用。
2. “注解1”扫描含有注解（@Component 等）类，注入注解自动生效。
	“注解2”只在xml和注解（注入）混合使用时，使注入注解生效。
```

### AOP

```
aop底层将采用代理机制进行实现。
接口 + 实现类 ：spring采用 jdk 的动态代理Proxy。
实现类：spring 采用 cglib字节码增强,不需要interface接口文件，只要implements实现文件
```

```
1.target：目标类，需要被代理的类。例如：UserService
2.Joinpoint(连接点):所谓连接点是指那些可能被拦截到的方法。例如：所有的方法
3.PointCut 切入点：已经被增强的连接点。例如：addUser()
4.advice 通知/增强，增强代码。例如：after、before
5. Weaving(织入):是指把增强advice应用到目标对象target来创建新的代理对象proxy的过程.
6.proxy 代理类
7. Aspect(切面): 是切入点pointcut和通知advice的结合
	一个线是一个特殊的面。
	一个切入点和一个通知，组成成一个特殊的面。

```

