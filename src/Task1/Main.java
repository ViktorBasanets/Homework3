package Task1;

public class Main {
    public static void main(String[] args) {
        String[] paths = new String[] {
                "/a///..///kab///.//b/./home/./c/",
                "/home/",
                "/..",
                "/.",
                "/.data",
                "/....",
                "/home/./a/../b"
        };

        for (int i = 0; i < paths.length; i++) {
            new UnixPath(paths[i].toCharArray()).simplifies().showResult();
        }
    }
}
