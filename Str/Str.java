package Str;
import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * A class that represents a sequence of characters. It is similar to the String
 * class, but is mutable.
 * It also has some extra methods that are useful for many things that the
 * String class does not provide.
 *
 * Author: Dominick J
 */
public class Str {
    private char[] data;
    private Object[] args;

    /**
     * A class that represents a sequence of characters. It is similar to the String
     * 
     * @param str {@code String}  - The string to format
     * @param args {@code Object...} - The arguments to format the string with (in order)
     */
    public Str(String str, Object... args) {
        this.data = str.toCharArray();
        this.args = args;
    }

    /**
     * A class that represents a sequence of characters. It is similar to the String
     * 
     * @param data {@code char[]} - The data to format (as a char array)
     * @param args {@code Object...}- The arguments to format the string with (in order)
     */

    public Str(char[] data, Object... args) {
        this.data = data;
        this.args = args;
    }

    /**
     * A class that represents a sequence of characters. It is similar to the String
     * 
     * @param data - The data to format (as a char array)
     */
    public Str(char[] data) {
        this.data = data;
    }

    /**
     * A class that represents a sequence of characters. It is similar to the String
     * 
     * @param str {@code String} - The string to format
     */
    public Str(String str) {
        this.data = str.toCharArray();
    }

    /**
     * A class that represents a sequence of characters. It is similar to the String
     * This implementation is used when no arguments are passed.
     * It will create an empty string-like Str, with a default length of 10.
     */
    public Str() {
        this.data = new char[10];
    }

    public String toString() {
        return new String(this.format(args).data);
    }

    /**
     * Gets the character at the specified index in the Str object.
     * 
     * @param i
     * @return The character at the specified index
     */

    public char get(int i) {
        return data[i];
    }

    /**
     * Gets all the data in the char array.
     * 
     * @return {@code char[]} sequence of
     *         characters.
     */
    public char[] get() {
        return this.data;
    }

    /**
     * Looks for the specified character in the Str object split by the specified
     * character.
     * 
     * @param i {@code int} - The index of the sequence of characters to look in.
     * @param j {@code int} - The index of the character to look for.
     * @param c {@code char} - The character to split the Str object by.
     * @return {@code char} - The character at the specified index.
     */
    public char get(int i, int j, char c) {
        return (char) this.split(c)[i].get(j);
    }

    /**
     * Shortcut for getting the character at the specified index in the Str sequence
     * split by ' '.
     * @see #get(int, int, char)
     * @see #split(char)
     * 
     * @param i {@code int} - The index of the sequence of characters to look in.
     * @param j {@code int} - The index of the character to look for.
     * @return {@code char} - The character at the specified index.
     */
    public char get(int i, int j) {
        return (char) this.split(' ')[i].get(j);
    }

    /**
     * Returns the length of the Str object.
     * 
     * @return Length of Str object as int.
     */
    public int length() {
        return data.length;
    }

    /**
     * Returns a count of the amount of times the specified character occurs in (s)
     * String
     * 
     * @param s {@code String} - The string to match with
     * @param c {@code char} - The character to match with
     * @return {@code int} - The amount of times the character occurs in the String.
     */
    public static int count(String s, char c) {
        int count = 0;
        for (char i : s.toCharArray()) {
            if (i == c) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns a count of the amount of times the specified Str sequence occurs in a
     * Str object.
     * 
     * @param s {@code Str} - The Str sequence to match with.
     * @param c {@code char} - The character to match with
     * @return {@code int} - The amount of times the character occurs in the Str object.
     */
    public static int count(Str s, char c) {
        return count(s.toString(), c);
    }

    /**
     * Returns a count of the amount of times the specified character occurs in the
     * Str object.
     * 
     * @param c {@code char} - The character to match with. 
     * @return {@code int} - The amount of times the character occurs in the Str object.
     */
    public int count(char c) {
        int count = 0;
        for (char i : this.format(args).data) {
            if (i == c) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns a count of the amount of times the specified String occurs in the Str
     * object.
     * 
     * @param s {@code String} - The String to match with.
     * @return {@code int} - The amount of times the String occurs in the Str object.
     */
    public int count(String s) {
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == s.charAt(0)) {
                boolean match = true;
                for (int j = 0; j < s.length(); j++) {
                    if (data[i + j] != s.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Looks for the specified character in the Str object and returns the index of
     * the first occurrence.
     * 
     * @param c {@code char} -  The character to look for.
     * @return {@code int} - The index of the first occurrence of the character in the Str object.
     */
    public int find(char c) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == c) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Looks for the specified String in the Str object and returns the index of the
     * first occurrence.
     * 
     * @param s {@code Str} -  The Str sequence to look for.
     * @return {@code int} - Index representing the first occurrence of the String in the Str
     *         object.
     */
    public int find(String s) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == s.charAt(0)) {
                boolean match = true;
                for (int j = 0; j < s.length(); j++) {
                    if (data[i + j] != s.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Looks for the specified Str sequence in the Str object and returns the index
     * of the first occurrence.
     * 
     * @param s {@code Str} -  The Str sequence to look for.
     * @return {@code int} - Index representing the first occurrence of the String in the Str
     *         object.
     */
    public int find(Str s) {
        return this.find(s.toString());
    }

    /**
     * Collects a substring of the Str object specified by the start and end index.
     * 
     * @param i {@code int} -  The start index of the substring.
     * @param j {@code int} -  The end index of the substring.
     * @return {@code Str} - A Str object representing the substring.
     */
    public Str substring(int i, int j) {
        Str s = new Str("");
        while (i < j) {
            s.append(this.get(i));
            i++;
        }
        return s;
    }

    /**
     * Collects a substring of the Str object specified by the end index.
     * 
     * @param i {@code int} -  The end index of the substring.
     * @return {@code Str} - A Str object representing the substring.
     */
    public Str substring(int i) {
        return this.substring(0, i);
    }

    /**
     * Appends the specified Str sequence to the end of the Str object.
     * 
     * @param s {@code Str} -  The Str sequence to append.
     * @return {@code self} - The Str object.
     */
    public Str append(Str s) {
        for (char c : s.toCharArray()) {
            this.append(c);
        }
        return this;
    }

    /**
     * Appends the specified char to the end of the Str object.
     * 
     * @param c {@code char} - The char to append.
     * @return {@code self} - The Str object.
     * @see Str#prepend(char)
     * @see Str#append(Str)
     */
    public Str append(char c) {
        char[] data = new char[this.data.length + 1];
        for (int i = 0; i < this.data.length; i++) {
            data[i] = this.data[i];
        }
        data[data.length - 1] = c;
        this.data = data;
        return this;
    }

    /**
     * Prepends the specified String to the end of the Str object.
     * 
     * @param s {@code String} - The String to prepend.
     * @return {@code self} - The Str object.
     * @see Str#append(String)
     * @see Str#prepend(Str)
     */
    public Str prepend(String s) {
        return prepend(new Str(s));
    }

    /**
     * Prepends the specified Str sequence to the end of the Str object.
     * 
     * @param s {@code Str} - The Str sequence to prepend.
     * @return {@code self} - The Str object.
     * @see Str#append(Str)
     * @see Str#prepend(String)
     */
    public Str prepend(Str s) {
        for (char c : s.reverse().toCharArray()) {
            this.prepend(c);
        }
        return this;
    }

    /**
     * Prepends the specified char to the end of the Str object.
     * 
     * @param c {@code char} - The char to prepend.
     * @return {@code self} - The Str object.
     * @see Str#append(char)
     * @see Str#prepend(Str)
     */
    public Str prepend(char c) {
        char[] data = new char[this.data.length + 1];
        for (int i = 0; i < this.data.length; i++) {
            data[i + 1] = this.data[i];
        }
        data[0] = c;
        this.data = data;
        return this;
    }

    /**
     * Removes the specified character from the Str object.
     * 
     * @implNote THIS METHOD IS NOT YET IMPLEMENTED.
     * @param i {@code int} - Index at which to start the insertion
     * @param s {@code Str} - the Str sequence to insert
     * @return {@code self} - The Str object.
     */
    public Str insert(int i, Str s) {
        // TODO Complete this method
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    /**
     * Removes the specified character from the Str object.
     * 
     * @implNote THIS METHOD IS NOT YET IMPLEMENTED.
     * @param i {@code int} - Index at which to start the insertion
     * @param c {@code char} - the char to insert
     * @return {@code self} - The Str object.
     */
    public Str insert(int i, char c) {
        // TODO Complete this method
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    /**
     * Replaces the specified index in the Str object with the specified Str
     * sequence, creating room if necessary.
     * 
     * @param i {@code int} - Index at which to start the replacement
     * @param s {@code Str} - the Str sequence to replace
     * @return {@code self} - The Str object.
     * @see Str#replace(int, String)
     * @see Str#replace(int, char)
     */
    public Str replace(int i, Str s) {
        char[] data = new char[this.data.length + s.length()];
        for (int j = 0; j < i; j++) {
            data[j] = this.data[j];
        }
        for (int j = i; j < s.length(); j++) {
            data[i + j] = s.get(j);
        }
        for (int j = i + s.length(); j < data.length; j++) {
            data[j] = this.data[j - s.length()];
        }
        this.data = data;
        return this;
    }

    /**
     * Replaces the specified index in the Str object with the specified String,
     * creating room if necessary.
     * 
     * @param i {@code int} - Index at which to start the replacement
     * @param s {@code String} - the String to replace
     * @return {@code self} - The Str object.
     * @see Str#replace(int, Str)
     * @see Str#replace(int, char)
     */
    public Str replace(int i, String s) {
        return this.replace(i, new Str(s));
    }

    /**
     * Replaces the specified index in the Str object with the specified char.
     * 
     * @param i {@code int} - Index at which to start the replacement
     * @param c {@code char} - the char to replace
     * @return {@code self} - The Str object.
     * @see Str#replace(int, Str)
     * @see Str#replace(int, String)
     */
    public Str replace(int i, char c) {
        int j = 0;
        while (j < i)
            j++;
        this.data[j] = c;
        return this;
    }

    /**
     * Removes the specified sequence from the Str object.
     * 
     * @param i {@code int} - Index at which to start the removal
     * @param j {@code int} - Index at which to end the removal
     * @return {@code self} - The Str object.
     */
    public Str remove(int i, int j) {
        for (;i<j;i++) {
            this.remove(i);
        }
        return this;
    }

    /**
     * Removes the specified character from the index in Str object.
     * 
     * @param i {@code int} - Index to remove
     * @return {@code self} The Str object.
     * @see Str#remove(char)
     */
    public Str remove(int i) {
        char[] data = new char[this.data.length - 1];
        for (int k = 0; k != i; k++) {
            data[k] = this.data[k];
        }
        this.data = data;
        return this;
    }

    /**
     * Removes the specified character from the Str object.
     * 
     * @param c {@code char} - The character to remove
     * @return {@code self} The Str object.
     * @see Str#remove(int)
     */
    public Str remove(char c) {
        char[] data = new char[this.data.length - this.count(c)];
        int j = 0;
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] != c) {
                data[j] = this.data[i];
                j++;
            }
        }
        this.data = data;
        return this;
    }

    /**
     * Reverses the sequence of the Str Object.
     * 
     * @return A new Str object with the reversed sequence.
     */
    public Str reverse() {
        char[] data = new char[this.data.length];
        for (int i = this.data.length; i > 0; i--) {
            data[this.data.length - i] = this.data[i - 1];
        }
        return new Str(data);
    }

    /**
     * Trims the leading and trailing specified character from the beginning and end
     * of the Str object.
     * 
     * @param c - The character to trim
     * @return The Str object.
     * @see Str#trim(char)
     */
    public Str trim(char c) {
        char[] data = new char[this.data.length - this.count(c)];
        int j = 0;
        boolean match = true;
        for (int i = 0; i < this.data.length; i++)
            if (this.data[i] == c && match)
                continue;
            else if (this.data[i] != c) {
                data[j] = this.data[i];
                j++;
                if (match)
                    match = false;
            }
        this.data = data;
        match = true;
        j = data.length;
        data = new char[this.data.length - this.count(' ')];
        for (int i = data.length - 1; i > 0; i--)
            if (this.data[i] == c && match)
                continue;
            else if (this.data[i] != c) {
                data[j] = this.data[i];
                j--;
                if (match)
                    match = false;
            }
        this.data = data;
        return this;
    }

    /**
     * Trims leading and trailing whitespace.
     * 
     * @return {@code Str} - The Str object.
     * @see Str#trim(char)
     * @see Str#trim(int)
     */
    public Str trim() {
        return this.trim(' ');
    }

    /**
     * Trims the specified number of characters from the beginning of the Str
     * object.
     * 
     * @param i {@code int} - The number of characters to trim
     * @return {@code Str} - The Str object.
     * @see Str#trim(char)
     * @see Str#trim()
     */
    public Str trim(int i) {
        for (int j = 0; j < i; j++)
            this.remove(0);
            return this;
    }

    /**
     * Splits the Str object into an array of lists of characters by a given
     * character.
     *
     * @param c - the character to split by
     * @return {@code ArrayList<Character>[]} an array of lists of characters
     * @implNote Example: 
     * {@code Fstr.split("Hello, World!", ' ')} 
     * -> {@code [List('H','e','l','l','o'),List(','),List('W','o','r','l','d','!')]}}
     */
    public ArrayList<Character>[] split(char c) {
        Str formatted = this.format();
        @SuppressWarnings("unchecked")
        ArrayList<Character>[] splitArray = new ArrayList[formatted.count(c) + 1];
        int i = 0;
        for (char x : formatted.data) {
            if (x != c) {
                if (splitArray[i] == null) {
                    splitArray[i] = new ArrayList<Character>();
                }
                splitArray[i].add(x);
            } else {
                i++;
            }
        }
        // Add the final sequence of characters to splitArray
        if (splitArray[i] == null) {
            splitArray[i] = new ArrayList<Character>();
        }
        return splitArray;
    }

    /**
     * Formats the Str object by replacing the delimiters with the given arguments.
     * 
     * @param args {@code ...Object} - The arguments to replace the delimiters with represented as an
     *             array of objects.
     * @return {@code Str} - the formatted Str object.
        * @implNote Example:
        *           {@code Fstr = new Str("Hello, %s!")}
        *           {@code Fstr.format("World")}
        *           -> {@code "Hello, World!"}
     */
    public Str format(Object... args) {
        StringBuilder sb = new StringBuilder();
        int argsIndex = 0;
        boolean format = false;

        for (char c : this.data) {
            if (c == '%') {
                format = true;
                continue;
            }

            if (format) {
                switch (c) {
                    case 's':
                        sb.append(args[argsIndex].toString());
                        argsIndex++;
                        break;
                    case 'S':
                        sb.append(args[argsIndex].toString().toUpperCase());
                        argsIndex++;
                        break;
                    case 'd':
                        sb.append(Integer.parseInt(args[argsIndex].toString()));
                        argsIndex++;
                        break;
                    case 'f':
                        sb.append(Float.parseFloat(args[argsIndex].toString()));
                        argsIndex++;
                        break;
                    case 'c':
                        sb.append(args[argsIndex].toString().charAt(0));
                        argsIndex++;
                        break;
                    case 'b':
                        sb.append(Boolean.parseBoolean(args[argsIndex].toString()));
                        argsIndex++;
                        break;
                    case 'n':
                        sb.append(System.lineSeparator());
                        break;
                    case 't':
                        sb.append("\t");
                        break;
                    case '%':
                        sb.append('%');
                        break;
                    case 'i':
                        sb.append(Integer.parseInt(args[argsIndex].toString(), 16));
                        argsIndex++;
                        break;
                    case 'o':
                        sb.append(Integer.parseInt(args[argsIndex].toString(), 8));
                        argsIndex++;
                        break;
                    case 'x':
                        sb.append(Integer.parseInt(args[argsIndex].toString(), 2));
                        argsIndex++;
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid format specifier");
                }
                format = false;
            } else {
                sb.append(c);
            }
        }

        return new Str(sb.toString());
    }

    /**
     * Formats a String object by replacing the delimiters with the given arguments.
     * 
     * @param {@code String} s    - The String object to format.
     * @param args {@code ...Object  }- The arguments to replace the delimiters with represented as an
     *             array of objects.
     * @return {@code String} - the formatted String.
     * @implNote Example:
     *          {@code Fstr.format("Hello, %s!", "World")} -> {@code "Hello, World!"}
     */
    public static String format(String s, Object... args) {
        return new String(new Str(s).format(args).data);
    }

    public void forEach(Consumer<Character> action) {
        for (char c : this.data) {
            action.accept(c);
        }
    }

    public void forEach(BiConsumer<Integer, Character> action) {
        for (int i = 0; i < this.data.length; i++) {
            action.accept(i, this.data[i]);
        }
    }


    /**
     * Filters the Str object by a given predicate. 
     * Will remove all characters that do not satisfy the predicate, or meet a truthy condition.
     * @param truth {@code Predicate<Character>} - The condition to filter by.
     * @return {@code Str} - The filtered Str object.
     * @implNote Example:
     * {@code Str s = new Str("Hello, World!");}
     * {@code s.filter(c -> c != 'o');}
     * -> {@code "Hell, Wrld!"}
     */
    public Str filter(Predicate<Character> truth) {
        for (char c : data) {
            if (!truth.test(c)) this.remove(c);
        }
        return this;
    }
    
    public char[] toCharArray() {
        return this.data;
    }
}
