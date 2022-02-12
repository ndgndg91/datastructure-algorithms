package proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class BookServiceInvocationHandler implements InvocationHandler {
    private final BookService bookService;

    public BookServiceInvocationHandler(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        method.invoke(bookService, args);
        System.out.println("after invoke");
        return proxy;
    }
}
