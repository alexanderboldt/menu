/**
 * Builds the menu with its items.
 */
class MenuBuilder() {

    private val items = mutableListOf<Item>()

    fun item(title: String, action: suspend () -> Unit) {
        items.add(Item(title, action))
    }

    internal fun getItems(): List<Item> = items
}