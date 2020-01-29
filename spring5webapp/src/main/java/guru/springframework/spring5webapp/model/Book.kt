package guru.springframework.spring5webapp.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany

@Entity
class Book() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long? = null
    private var title: String? = null
    private var isbn: String? = null
    private var publisher: String? = null

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = [JoinColumn(name = "book_id")],
            inverseJoinColumns = [JoinColumn(name = "author_id")])
    private var authors: Set<Author>? = null

    constructor(title: String, isbn: String, publisher: String) : this() {
        this.title = title
        this.isbn = isbn
        this.publisher = publisher
    }

    constructor(title: String, isbn: String, publisher: String, authors: Set<Author>) : this(title, isbn, publisher) {
        this.authors = authors
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Book
        if (id != other.id) return false
        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Book(id=$id, title=$title, isbn=$isbn, publisher=$publisher, authors=$authors)"
    }
}