package org.maxime.cucumber

import io.cucumber.java.DataTableType
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import junit.framework.Assert
import kotlin.test.assertEquals
import kotlin.test.fail

class TableTest {

    private val favoritesAuthors = mutableListOf<Author>();
    private val library = mutableListOf<Book>();

    @Given("There are my favorite authors")
    fun these_are_my_favourite_authors(authors: List<Author>?) {
        favoritesAuthors.addAll(authors!!)
    }

    @Then("I have {int} favorites authors")
    fun iHaveFavoritesAuthors(count: Int) {
        Assert.assertEquals(count, favoritesAuthors.size)
    }

    @Given("I have a library containing some books")
    fun iHaveALibraryContainingSomeBooks(books: List<Book>?) {
        library.addAll(books!!)
    }

    @Then("Here is my book count \\(with map)")
    fun hereIsMyBookCount(entries: Map<String, Long>) {
        entries.forEach { (k: String, v: Long) ->
            val author = Author(k)
            val count: Long= library.count { it.author == author }.toLong()
            assertEquals(v, count, author.toString())
        }
    }

    @Then("Here is my oldest per author \\(with list)")
    fun hereIsMyBookPerAuthor(entries: List<List<String>>) {

        val authorColumn = entries.first().indexOf("AUTHOR")
        val titleColumn = entries.first().indexOf("TITLE")
        val dateColumn = entries.first().indexOf("DATE")

        entries
            .subList(1, entries.size)
            .forEach { v ->
                val author = Author(v[authorColumn])
                val expectedYear = v[dateColumn].toInt()
                val expectedTitle = v[titleColumn]

                val myBooks: List<Book> = library.filter { it.author == author }
                if (myBooks.isEmpty())
                    fail("Library does not contain any book from $author")

                val myOldest = myBooks.minByOrNull { it.year }!!

                assertEquals(expectedYear, myOldest.year, "Your oldest book from '$author' is from year ${myOldest.year}")
                assertEquals(expectedTitle, myOldest.title, "Your oldest book from '$author' is '${myOldest.title}'")
        }
    }



    @DataTableType
    fun authorEntry(entry: Map<String, String>): Author {
        return Author(
            entry["FIRST NAME"],
            entry["LAST NAME"]
        )
    }

    @DataTableType
    fun bookEntry(entry: Map<String, String>): Book {
        val author = Author(entry["AUTHOR"])
        return Book(
            entry["TITLE"],
            author,
            entry["DATE"]!!.toInt())
    }
}