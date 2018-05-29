package Task1;

import java.util.Stack;

public class UnixPath {

    private char[] path;
    private Stack<char[]> stack;
    private char[][] result;

    public UnixPath(char[] path) {
        this.path = path;
        this.stack = new Stack<>();
        this.result = new char[1][];
    }

    public UnixPath simplifies() {
        if (String.valueOf(path).equals(String.valueOf("/..")) ||
                String.valueOf(path).equals(String.valueOf("/."))) {
            result[0] = "/".toCharArray();
            return this;
        }

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
        result = stack.toArray(new char[0][]);

        return this;
    }

    public void showResult() {
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }
        System.out.println();
    }
}