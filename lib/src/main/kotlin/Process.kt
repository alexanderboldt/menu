import kotlinx.coroutines.runBlocking

/**
 * Manages the process of the menu.
 *
 * @param items The menu-items.
 */
internal class Process(private val items: List<Item>) {

    private val stringInputPrefix = ": "
    private val stringIdle = "\nPress enter to continue...\n"

    internal fun start() {
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
                } else if (!items.indices.contains(input.dec())) {
                    printMenu = false
                    continue
                } else {
                    println()
                    items[input.dec()].content()

                    print(stringIdle)
                    readln()
                }
            } while (!shutdown)
        }
    }

    internal fun printMenu() {
        items.forEachIndexed { index, menuItem ->
            println("${index.inc()} -> ${menuItem.title}")
        }
    }
}