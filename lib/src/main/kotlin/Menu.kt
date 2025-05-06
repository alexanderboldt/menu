import kotlinx.coroutines.runBlocking

fun menu(block: MenuBuilder.() -> Unit) {
    MenuBuilder().apply(block).start()
}

class MenuBuilder() {

    private val menuItems = mutableListOf<Item>()

    private val stringInputPrefix = ": "
    private val stringIdle = "\nPress enter to continue...\n"

    fun item(title: String, action: suspend () -> Unit) {
        menuItems.add(Item(title, action))
    }

    fun start() {
        runBlocking {
            var printMenu = true
            var shutdown = false

            do {
                if (printMenu) printMenu()
                printMenu = true

                print(stringInputPrefix)
                val input = readln().toIntOrNull()

                if (input == null) {
                    printMenu = false
                    continue
                } else if (input == 0) {
                    shutdown = true
                } else if (!menuItems.indices.contains(input.dec())) {
                    printMenu = false
                    continue
                } else {
                    println()
                    menuItems[input.dec()].action()

                    print(stringIdle)
                    readln()
                }
            } while (!shutdown)
        }
    }

    fun printMenu() {
        menuItems.forEachIndexed { index, menuItem ->
            println("${index.inc()} -> ${menuItem.title}")
        }
    }
}