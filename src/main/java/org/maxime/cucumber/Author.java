package org.maxime.cucumber;

import java.util.Objects;

public class Author {

    private final String XfirstName;
    private final String lastName;

    public Author(String firstName, String lastName) {
        this.XfirstName = firstName.trim();
        this.lastName = lastName.trim();
    }

    public Author(String author) {
        this(author.substring(author.indexOf(',')+1),
             author.substring(0, author.indexOf(',')));
    }

    @Override
    public String toString() {
        return lastName + ", " + XfirstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author)) return false;
        Author author = (Author) o;
        return Objects.equals(XfirstName, author.XfirstName) && Objects.equals(lastName, author.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(XfirstName, lastName);
    }
}
