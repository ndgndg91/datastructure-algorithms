package datastructure.algorithms.plainjava.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DeleteAlbumMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("before " + method.getDeclaringClass() + " : " + method.getName() + "() called "  + methodProxy.getSuperName());
        methodProxy.invokeSuper(proxy, args);
        System.out.println("after " + method.getDeclaringClass() + " : " + method.getName() + "() called " + methodProxy.getSuperName());
        return methodProxy;
    }
}
