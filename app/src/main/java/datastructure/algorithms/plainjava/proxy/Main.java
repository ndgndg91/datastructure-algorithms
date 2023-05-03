package datastructure.algorithms.plainjava.proxy;


import datastructure.algorithms.plainjava.proxy.cglib.AlbumService;
import datastructure.algorithms.plainjava.proxy.cglib.AlbumServiceCallbackFilter;
import datastructure.algorithms.plainjava.proxy.cglib.CreateAlbumMethodInterceptor;
import datastructure.algorithms.plainjava.proxy.cglib.DeleteAlbumMethodInterceptor;
import datastructure.algorithms.plainjava.proxy.dynamic.BookService;
import datastructure.algorithms.plainjava.proxy.dynamic.BookServiceImpl;
import datastructure.algorithms.plainjava.proxy.dynamic.BookServiceInvocationHandler;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        cglibDynamicProxy();
    }

    private static void jdkDynamicProxy() {
        BookService proxiedPojo = (BookService) Proxy.newProxyInstance(
                BookServiceImpl.class.getClassLoader(),
                new Class[]{BookService.class},
                new BookServiceInvocationHandler(new BookServiceImpl())
        );
        proxiedPojo.create();
        proxiedPojo.delete();
    }

    private static void cglibDynamicProxy() {
        var enhancer = new Enhancer();
        var filter = new AlbumServiceCallbackFilter();
        var create = new CreateAlbumMethodInterceptor();
        var delete = new DeleteAlbumMethodInterceptor();
        enhancer.setSuperclass(AlbumService.class);
        enhancer.setCallbackFilter(filter);
        enhancer.setCallbacks(new Callback[]{create, delete, NoOp.INSTANCE});

        AlbumService albumServiceProxy = (AlbumService) enhancer.create();

        albumServiceProxy.create();
        albumServiceProxy.delete();
    }
}
