package proxy;

import proxy.dynamic.BookService;
import proxy.dynamic.BookServiceImpl;
import proxy.dynamic.BookServiceInvocationHandler;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        BookService proxiedPojo = (BookService) Proxy.newProxyInstance(
                BookServiceImpl.class.getClassLoader(),
                new Class[]{BookService.class},
                new BookServiceInvocationHandler(new BookServiceImpl())
        );
        proxiedPojo.create();
        proxiedPojo.delete();

    }
}
