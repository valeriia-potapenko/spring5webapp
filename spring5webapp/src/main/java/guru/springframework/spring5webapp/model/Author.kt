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

    @ManyToMany(mappedBy = "authors")
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Author
        if (id != other.id) return false
        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Author(id=$id, firstName=$firstName, lastName=$lastName, books=$books)"
    }
}