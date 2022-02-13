package plainjava.proxy;

import net.sf.cglib.proxy.*;
import plainjava.proxy.cglib.AlbumService;
import plainjava.proxy.cglib.AlbumServiceCallbackFilter;
import plainjava.proxy.cglib.CreateAlbumMethodInterceptor;
import plainjava.proxy.cglib.DeleteAlbumMethodInterceptor;
import plainjava.proxy.dynamic.BookService;
import plainjava.proxy.dynamic.BookServiceImpl;
import plainjava.proxy.dynamic.BookServiceInvocationHandler;

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
