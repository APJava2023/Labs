# Str - Formatted String
Str is an eloquently written class for mutable and formattable strings in Java.

## Usage
---
### Strings can be created in a variety of ways.

##### Create a Str from a String
```java
Str str = new Str("Hello, World!");
System.out.println(str);
// Hello, World!
```

##### Create a Str from an array of characters
```java
char[] sequence = {'H', 'e', 'l', 'l', 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd', '!'};
Str str = new Str(sequence);
System.out.println(str);
// Hello, World!
```

##### Create a Str from scratch
```java
Str str = new Str();
// str is empty with a length of 10
```

### Strings can also be formatted.


#### This can be done during construction.
```java
Str str = new Str("Hello, %s!", "World");
System.out.println(str);
// Hello, World!
```

#### Or after construction.
```java
Str str = new Str("Hello, %s!");
str.format("World");
System.out.println(str);
// Hello, World!
```

#### It can even be done statically with the format method.
```java
String formattedString = Str.format("Hello, %s!", "World");
System.out.println(formattedString);
// Hello, World!
```

## Methods
---
### Constructors
* `Str()`
* `Str(String)`
* `Str(char[])`
* `Str(String, Object...)`
* `Str(char[], Object...)`

### Instance Methods

#### Mutators
* [`append()`](####append) 
* [`prepend()`](####prepend)
* [`format()`](####format)
* [`insert()`](####insert)
* [`replace()`](####replace)
* [`reverse()`](####reverse)
* [`remove()`](####remove)
* [`format()`](####format)
* [`filter()`](####filter)
* [`trim()`](####trim)

#### Accessors
* [`get()`](####get)
* [`length()`](####length)
* [`substr()`](####substr)
* [`split()`](####split)
* [`toString()`](####toString)

#### Static Methods
* [`format()`](####format)


#### Append
* `append(String)`
* `append(char[])`
* `append(Str)`
##### Append text to the end of the Str.
```java
Str str = new Str("Hello");
str.append(", World!");
System.out.println(str);
// Hello, World!
```

#### Prepend
* `prepend(String)`
* `prepend(char[])`
* `prepend(Str)`
##### Prepend text to the beginning of the Str.
```java
Str str = new Str("World!");
str.prepend("Hello, ");
System.out.println(str);
// Hello, World!
```

#### Format
* `format(String, Object...)`
##### Format the Str with the given arguments.
```java
Str str = new Str("Hello, %s!");
str.format("World");
System.out.println(str);
// Hello, World!
```

#### Insert
* `insert(int, String)`
* `insert(int, char[])`
* `insert(int, Str)`
##### Insert text at the given index.
```java
Str str = new Str("Hello, World!");
str.insert(7, "beautiful ");
System.out.println(str);
// Hello, beautiful World!
```

#### Replace
* `replace(String, String)`
* `replace(char, char)`
* `replace(Str, Str)`
* `replace(int, String)`
* `replace(int, char[])`
* `replace(int, Str)`
##### Replace all occurrences of the given substring with the given replacement.
##### Will replace index if passed integer.
```java
Str str = new Str("Hello, World!");
str.replace("World", "beautiful World");
System.out.println(str);
// Hello, beautiful World!
```

#### Reverse
* `reverse()`
##### Reverse the Str.
```java
Str str = new Str("Hello, World!");
str.reverse();
System.out.println(str);
// !dlroW ,olleH
```

#### Remove
* `remove(char)`
* `remove(int)`
##### Remove all occurrences of the given char.
##### Will remove index if passed integer.
```java
Str str = new Str("Hello, World!");
str.remove("W");
System.out.println(str);
// Hello, orld!
```

#### Filter
* `filter(Predicate<Character>)`
##### Remove all characters that do not satisfy the given predicate.
```java
Str str = new Str("Hello, World!");
str.filter(c -> c != 'l');
System.out.println(str);
// Heo, Word!
```

#### Trim
* `trim()`
##### Remove all leadning and trailing whitespace from the Str.
```java
Str str = new Str("   Hello, World!   ");
str.trim();
System.out.println(str);
// Hello, World!
```

#### Get
* `get(int)`
* `get(int, int)`
* `get(int, int, char)`
##### Get a substring from the given index.
```java
Str str = new Str("Hello, World!");
System.out.println(str.get(7));
// W
```
##### Get a substring from the given index with the given range within the Str.
```java
Str str = new Str("Hello, World!");
System.out.println(str.get(7, 12));
// World
```
##### Split the Str by the given character and get the char at the given coordinate.
```java
Str str = new Str("Hello, World!");
System.out.println(str.get(0, 0, ' '));
// H
```

#### Length
* `length()`
##### Get the length of the Str.
```java
Str str = new Str("Hello, World!");
System.out.println(str.length());
// 13
```

#### Substr
* `substr(int)`
* `substr(int, int)`
##### Get a substring with given length.
```java
Str str = new Str("Hello, World!");
System.out.println(str.substr(7));
// Hello, 
```

##### Get a substring with given range within the Str.
```java
Str str = new Str("Hello, World!");
System.out.println(str.substr(7, 12));
// World
```

#### Split
* `split(char)`
* `split()`
##### Split the Str by the given character.
```java
Str str = new Str("Hello, World!");
System.out.println(str.split(' '));
// [List('H','e','l','l','o',','), List('W','o','r','l','d','!')]
```

##### Split the Str by whitespace.
```java
Str str = new Str("Hello World!");
System.out.println(str.split());
// [List('H','e','l','l','o'), List('W','o','r','l','d','!')]
```

#### To String
* `toString()`
##### Get the Str as a String.
```java
Str str = new Str("Hello, World!");
System.out.println(str.toString());
// Hello, World!
```

#### Format
* `format(String, Object...)`
##### Format the Str with the given arguments.
```java
Str str = new Str("Hello, %s!");
str.format("World");
System.out.println(str);
// Hello, World!
```


