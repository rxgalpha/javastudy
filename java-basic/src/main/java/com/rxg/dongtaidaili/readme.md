[浅谈JDK动态代理 上中下]( https://zhuanlan.zhihu.com/p/62534874 )  
cglib:[CGLIB原理及实现机制](https://blog.csdn.net/gyshun/article/details/81000997)  

juejin:[Java 动态代理详解](https://juejin.im/post/5c1ca8df6fb9a049b347f55c)  
使用Proxy.newProxyInstance创建动态代理开发流程：  
1.创建真实对象。  
2.定义InvocationHandler的实现类：  
	定义用于操作真实对象的Object成员，定义构造方法(可用于不同的类创建代理)  
	重写invoke方法，通过method.invoke操作真实对象  
3.Proxy.newProxyInstance创建代理对象。
