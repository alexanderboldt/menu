/**
 * Represents an item in a menu.
 *
 * @param title The title to display.
 * @param action The action as function.
 */
data class Item(
    val title: String,
    val action: suspend () -> Unit
)