package Task1;

import java.util.Stack;

public class UnixPath {
    private char[] path;
    private Stack<char[]> stack;
    private char[][] result;

    public UnixPath(char[] path) {
        this.path = path;
        this.stack = new Stack<>();
    }

    public UnixPath simplifies() {
        for(int i = 0; i < path.length; i++) {
            String tempLink = "";

            while (path[i] == '/') { i++; }

            while (i < path.length && path[i] != '/') {
                tempLink += path[i++];
            }

            if (tempLink.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (tempLink.equals(".")) {
                continue;
            } else {
                stack.push(("/" + tempLink).toCharArray());
            }
        }

        return this;
    }

    public void showResult() {
        result = stack.toArray(new char[0][]);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }

        if (result.length == 0) {
            System.out.println("/");
        } else System.out.println();
    }
}