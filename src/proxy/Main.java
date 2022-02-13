package proxy;

import net.sf.cglib.proxy.*;
import proxy.cglib.AlbumService;
import proxy.cglib.AlbumServiceCallbackFilter;
import proxy.cglib.CreateAlbumMethodInterceptor;
import proxy.cglib.DeleteAlbumMethodInterceptor;
import proxy.dynamic.BookService;
import proxy.dynamic.BookServiceImpl;
import proxy.dynamic.BookServiceInvocationHandler;

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
