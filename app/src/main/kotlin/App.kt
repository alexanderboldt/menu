package org.alex.app

import menu

fun main() {
    val notes = mutableListOf<Note>()

    menu {
        item("Add a note") {
            print("Enter the description: ")
            val description = readln()

            notes.add(Note(notes.size.inc(), description))
        }
        item("Show all notes") {
            println("Listing all notes")
            println(notes)
        }
        item("Delete a note") {
            print("Enter the id to delete: ")
            val id = readln().toIntOrNull()

            val wasDeleted = notes.removeIf { it.id == id }
            if (!wasDeleted) println("Could not delete note with the given id!")
        }
    }
}
