package com.lixiaoyan;

import com.liyuxin.IDoubleSixService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClientProxy clientProxy = new ClientProxy();
        IDoubleSixService doubleSixService = clientProxy.client(IDoubleSixService.class);
        Object result = doubleSixService.helloHello();
        System.out.println(result);
    }
}
