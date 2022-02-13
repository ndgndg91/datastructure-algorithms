package plainjava.proxy.dynamic;

public class BookServiceImpl implements BookService {

    @Override
    public void create() {
        System.out.println("BookService create");
        this.delete();
    }

    @Override
    public void delete() {
        System.out.println("BookService delete");
    }
}
