package datastructure.algorithms.plainjava.proxy.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

public class AlbumServiceCallbackFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        System.out.println("accept : " + method.getName());
        if (method.getName().contains("create")) {
            return 0;
        } else if (method.getName().contains("delete")) {
            return 1;
        } else {
            return 2;
        }
    }
}
