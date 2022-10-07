package org.maxime.cucumber

import io.cucumber.java.DataTableType
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import kotlin.test.assertEquals


class SendMailsTest {

    private var attachments: List<Attachment> = emptyList()
    private var maxSize: Double = -1.0

    private var emails: List<EMail> = emptyList()

    @Given("The maximum size for an email is {int} Mb")
    fun theMaximumSizeIs(maxSize: Double) {
        this.maxSize = maxSize
    }

    @And("We have this set of attachments :")
    fun weHaveThisSetOfAttachements(attachments: List<Attachment>) {
        this.attachments = attachments
    }

    @And("We prepare emails")
    fun wePrepareEmails() {
       // Nothing
    }

    private fun buildEmails(): List<EMail> {

        val emails = GroupPerSizeHelper<Attachment>()
            .load(this.attachments.map { it.size to it })
            .group(this.maxSize)
            .map { group -> EMail(
                attachments = group.map { it.filename },
                size = group.sumOf { it.size }
            ) }

        return emails
    }

    @Then("An errors occurs because file {string} size exceeded the limit")
    fun anErrors(fileName: String) {
        val fileError =
            this.attachments.find {
                it.size > this.maxSize
            }
        assertEquals(fileName, fileError?.filename)
    }

    @Then("We expect to have {int} mails :")
    fun weHaveMails(count: Int, expectedEmails: List<EMail>) {

        this.emails = buildEmails()

        assertEquals(count, emails.size)

        expectedEmails.forEachIndexed { index, expectedEmail ->

            assertEquals(expectedEmail.attachments.sortedBy { it }.joinToString(", "),
                         emails[index].attachments.sortedBy { it }.joinToString(", "))

            assertEquals(expectedEmail.size,
                emails[index].size)
        }
    }

    @DataTableType
    fun attachmentEntry(entry: Map<String, String>): Attachment {
        return Attachment(
            entry["File name"]!!,
            entry["Size"]!!.toDouble()
        )
    }

    @DataTableType
    fun mailEntry(entry: Map<String, String>): EMail {
        return EMail(
            entry["File names"]!!.split(",").map { it.trim() },
            entry["Total size"]!!.toDouble()
        )
    }
}

data class Attachment(
    val filename: String,
    val size: Double
)

data class EMail(
    val attachments: List<String>,
    val size: Double
)