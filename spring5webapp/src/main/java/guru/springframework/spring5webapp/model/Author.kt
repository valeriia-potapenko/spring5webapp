package guru.springframework.spring5webapp.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
class Author() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private var id: Long? = null
    private var firstName: String? = null
    private var lastName: String? = null

    @ManyToMany
    private var books: Set<Book>? = null

    constructor(firstName: String, lastName: String) : this() {
        this.firstName = firstName
        this.lastName = lastName
    }

    constructor(firstName: String, lastName: String, books: Set<Book>) : this() {
        this.firstName = firstName
        this.lastName = lastName
        this.books = books
    }
}