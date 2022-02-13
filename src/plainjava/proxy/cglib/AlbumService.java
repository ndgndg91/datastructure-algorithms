package plainjava.proxy.cglib;

public class AlbumService {

    public AlbumService() {
        System.out.println("AlbumService 생성자!");
    }

    public void create() {
        System.out.println("AlbumService create");
        this.delete();
    }

    public void delete() {
        System.out.println("AlbumService delete");
    }
}
