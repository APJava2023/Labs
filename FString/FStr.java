package Fstr;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.Scanner;

public class Fstr extends Object {
    String str;
    char[] data;
    Object[] args = {};

    public Fstr(String str, Object... args) {
        this.str = str;
        this.args = args;
        this.data = str.toCharArray();
    }

    public Fstr(char[] data, Object... args) {
        this.data = data;
        this.args = args;
    }

    public Fstr(char[] data) {
        this.data = data;
    }

    /*
     * Getters
     * getArgs -> Object[] - array of arg ojects used for substitution
     * initial -> String - Initial given string to be formatted
     */
    public Object[] getArgs() {
        return this.args;
    }

    public String initial() {
        return str;
    }

    /*
     * Casters
     * toString -> String - Format Fstr and return it.
     * toCharArray -> char[] - Format Fstr and then return an array of its
     * individual characters.
     */
    public String toString() {
        return String.format(str, args);
    }

    public char[] toCharArray() {
        return this.data;
    }

    /*
     * Formatter
     * [ STATIC ] format(String, Object...) & f -> String - Formats a string and
     * returns it
     * reformat(Object...) -> Fstr - take additional or replace specifiers with arg
     * parameters
     * and return string formatted with new parameters.
     * reformat(String) -> Fstr - Replace Fstr {str} parameter and return self
     */
    public String format(Object... args) {
        boolean formatMode = false;
        int argIndex = 0;
        char[] data = this.str.toCharArray();
        String str = "";
        for (char x : data) {
            if (x == '%' && !formatMode) formatMode = !formatMode;
            if (!formatMode && x != '%')
                str += String.valueOf(x);
            else {
                System.out.println(x);
                switch (x) {
                    case '%':
                        str += '%';
                        break;
                    case 's':
                        str += args[argIndex];
                        break;
                    case 'S':
                        str += args[argIndex].toString().toUpperCase();
                        break;
                    case 'd':
                        str += Double.parseDouble((String) args[argIndex]);
                        break;
                    case '+':
                        str += (int) args[argIndex];
                        break;
                    default:
                        str += x;
                        break;
                }
                argIndex++;

            }
        }
        return str;
    }

    public static String format(String str, Object... args) {
        return String.format(str, args);
    }

    public static String f(String str, Object... args) {
        return String.format(str, args);
    }

    public Fstr reformat(Object... args) {
        this.args = args;
        return this;
    }

    public Fstr reformat(String str) {
        this.str = str;
        return this;
    }

    /*
     * Collectors
     * substr(int) -> char - Return character at that index of the string.
     * substr(int, int) -> char - Return range of characters between given indexes
     * of the string.
     */
    public char substr(int i) {
        return this.toString().charAt(i);
    }

    public String substr(int i1, int i2) {
        return this.toString().substring(i1, i2);
    }

    /*
     * Loops
     * forEach(Consumer<Character>) -> void - Accept function(char) as parameter to
     * apply to looped over character array
     * forEach(BiConsumer<Character>) -> void - Accept function(char, int: index) as
     * parameter to apply to looped over character array
     */
    public void forEach(Consumer<Character> action) {
        String formatted = this.toString();
        for (int i = 0; i < formatted.length(); i++) {
            action.accept(formatted.toCharArray()[i]);
        }
    }

    public void forEach(BiConsumer<Character, Integer> action) {
        String formatted = this.toString();
        for (int i = 0; i < formatted.length(); i++) {
            action.accept(formatted.toCharArray()[i], i);
        }
    }

}

class Main {
    public static void main(String[] args) {
        Fstr r = new Fstr("Hello, %s!");
        System.out.println(r.format(10));

    }
}