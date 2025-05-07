# Menu
This is a simple Kotlin-Library to create a menu in a console-project.

## Usage
The menu can be build with an own declarative DSL. The outer scope is `menu` and contains `items` with the title and the content as a function. The content of an item supports Kotlin Coroutines. The console displays the items in the same order as defined.
```kotlin
menu {
    item("First") {
        // ...
    }
    item("Second") {
        // ...
    }
    item("Third") {
        // ...
    }
}
```

If this example would be compiled, the console would show the menu as followed.

```bash
1 -> First
2 -> Second
3 -> Third
: 
```

The user can chose between the items by entering the wanted number. The menu loops until the user enters `0` to exit the whole process.
