/**
 * Represents an item in a menu.
 *
 * @param title The title to display.
 * @param content The content as function.
 */
data class Item(
    val title: String,
    val content: suspend () -> Unit
)