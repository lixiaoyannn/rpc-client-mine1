package com.lixiaoyan;

import com.liyuxin.RequestEntry;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * 创建者:小䶮
 */
public class ClientProxy implements InvocationHandler{

    public <T> T client(final Class<T> interfaces){
        return (T) Proxy.newProxyInstance(interfaces.getClassLoader(),new Class<?>[]{interfaces},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RequestEntry requestEntry = new RequestEntry();
        requestEntry.setClassName(method.getDeclaringClass().getName());
        requestEntry.setMethodName(method.getName());
        requestEntry.setArgs(new Object[]{});
        NetTransport netTransport = new NetTransport();
        Object o = netTransport.sent(requestEntry);
        return o;
    }
}
