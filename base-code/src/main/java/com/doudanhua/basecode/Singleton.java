package com.doudanhua.basecode;

/**
 * @Author zhangqian
 * @Description 单例
 * @Date 2020/8/21 12:03
 */
public class Singleton {
    //使⽤ volatile 修饰变量就可以禁⽌ JVM 的指令重排，保证在多线程环
    //境下也能正常运⾏。 我们只需要将上⾯的代码稍作修改，就可以在多线程环境下使⽤了
    private static  volatile Singleton uniqueInstancs;

    private Singleton(){

    }

    public static  Singleton getInstance(){
        //先判断对想是否实例化，有的话直接返回
        if(uniqueInstancs!=null){
            return uniqueInstancs;
        }
        synchronized (Singleton.class){
            if(uniqueInstancs==null){
                uniqueInstancs=new Singleton();
            }
        }
        return uniqueInstancs;
    }
    //1、
    //我们⾸先判断 uniqueInstance 是否为空，如果不为空直接返回。如果
    //同时有多个线程都发现 `uniqueInstance==null 为空的话，就会去创建这个对象，但是创建部分的
    //代码块使⽤了 synchronized 关键字加锁，这样就保证了某⼀时刻只能有⼀个线程可以执⾏创建对象
    //这部分代码块，也就保证了当前系统只存在⼀个 Singleton 对象


    //2、
    //uniqueInstance = new Singleton() 不是原⼦操作，这段代
    //码可以简单分为下⾯三步执⾏：
    //1. 为 uniqueInstance 分配内存空间;
    //2. 初始化 uniqueInstance;
    //3. 将 uniqueInstance 指向分配的内存地址
    //由于但是由于 JVM 具有指令重排的特性，执⾏顺序有可能变成 1i>3i>2。指令重排在单线程环境下不
    //会出现问题，但是在多线程环境下会导致⼀个线程获得还没有初始化的实例。例如，线程 a 执⾏了 1
    //和 3，此时 线程 b 调⽤ getUniqueInstance() 后发现 uniqueInstance 不为空，因此返回
    //uniqueInstance，但此时 uniqueInstance 还未被初始化，所以就会导致空指针异常。
    //使⽤ volatile 修饰变量就可以禁⽌ JVM 的指令重排
}
