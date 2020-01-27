package guru.springframework.spring5webapp.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
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
    private var authors: Set<Author>? = null

    constructor(title: String, isbn: String, publisher: String) : this() {
        this.title = title
        this.isbn = isbn
        this.publisher = publisher
    }

    constructor(title: String, isbn: String, publisher: String, authors: Set<Author>) : this(title, isbn, publisher) {
        this.authors = authors
    }

}