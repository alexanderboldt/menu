/**
 * The start of the menu-dsl.
 *
 * @param block Function that contains the items.
 */
fun menu(block: MenuBuilder.() -> Unit) {
    val items = MenuBuilder().apply(block).getItems()
    Process(items).start()
}