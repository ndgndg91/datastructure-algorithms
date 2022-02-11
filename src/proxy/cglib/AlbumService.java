package proxy.cglib;

public class AlbumService {

    public void create() {
        System.out.println("AlbumService create");
        this.create();
    }

    public void delete() {
        System.out.println("AlbumService delete");
    }
}
