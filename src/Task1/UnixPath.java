package Task1;

import java.util.Arrays;

public class UnixPath {

    public static void main(String[] args) {

        char[] path = "/a///..//////home/./c/".toCharArray();

        replace(path, '/',0);
        path = arrayMaker(path);

        riceTo(path, "/../".toCharArray(),0);
        path = arrayMaker(path);

        stayOn(path, "/./".toCharArray(),0);
        path = arrayMaker(path);

        System.out.println(Arrays.toString(path));
        System.out.println(path);
    }

    private static void replace(char[] path, char ch, int index) {

        if(index == path.length - 2) {
            return;
        }

        if(path[index] == ch) {
            path[index] = '\0';

            if(path[index + 1] != '/') {
                path[index] = '/';
            }
        }

        replace(path, ch, ++index);
    }

private static void stayOn(char[] path, char[] seq, int index) {

        if(index == path.length - 1) {
            return;
        }

        boolean equally = false;

        for(int i = 0; i < seq.length; i++) {
            equally = path[i + index] == seq[i] ? true : false;
            if (!equally) {
               break;
            }
        }

        if(equally) {

            for (int i = 0; i < seq.length; i++) {
                path[i + index] = '\0';
            }

            path[index] = '/';
        }

        stayOn(path, seq, ++index);
    }


    private static void riceTo(char[] path, char[] seq, int index) {

        if(index == path.length - 1) {
            return;
        }

        boolean equally = false;

        for(int i = 0; i < seq.length; i++) {
            equally = path[i + index] == seq[i] ? true : false;
            if (!equally) {
                break;
            }
        }

        if(equally) {

            for (int i = 0; i < seq.length; i++) {
                path[i + index] = '\0';
            }

            path[index] = '/';

            for(int i = index; i > 0; i--) {
                path[i] = '\0';
            }
        }

        riceTo(path, seq, ++index);
    }

    static char[] arrayMaker(char[] array) {
        int counter = 0;

        for (int i = 0; i < array.length; i++) {
            counter += array[i] != '\0' ? 1 : 0;
        }

        if (array[array.length - 1] == '/') {
            counter--;
        }

        char[] result = new char[counter];

        for (int i = 0, j = 0; i < array.length && j < result.length; i++) {

            if(array[i] != '\0') {
                result[j++] = array[i];
            }
        }

        return result;
    }
}


