package Task1;

import java.util.Stack;

public class UnixPath {
    char[] path;
    Stack<char[]> stack;
    char[] resultPath;

    public UnixPath(char[] path) {
        this.path = path;
        stack = new Stack<>();
    }

    public char[] getResultPath() {

        return resultPath;
    }

    public UnixPath simplifies() {
        resultPath = new char[1];
        resultPath[0] = '/';

        for(int i = 0; i < path.length; i++) {

            String tempLink = "";

            while (path[i] == '/') {
                i++;
            }

            while (i < path.length && path[i] != '/') {
                tempLink += path[i++];
            }

            if (tempLink.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (tempLink.equals(".")) {
                continue;
            } else if (tempLink.length() != 0) {
                stack.push(tempLink.toCharArray());
            }
        }

        reverseToResult();
        return this;
    }

    private void reverseToResult() {
        Stack<char[]> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        while (!tempStack.isEmpty()) {
            char[] array = tempStack.peek();

            if (tempStack.size() != 1) {
                saveArray(array,resultPath.length + array.length + 1);
                resultPath[resultPath.length - 1] = '/';
            } else {
                saveArray(array,resultPath.length + array.length);
            }
            tempStack.pop();
        }
    }

    private void saveArray(char[] tempArray, int length) {
        char[] temp = new char[length];
        int i;
        for (i = 0; i < resultPath.length; i++) {
            temp[i] = resultPath[i];
        }

        for (int j = 0; j < tempArray.length; j++, i++) {
            temp[i] = tempArray[j];
        }
        resultPath = temp;
    }
}