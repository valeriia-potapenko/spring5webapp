package guru.springframework.spring5webapp.repository

import guru.springframework.spring5webapp.model.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<Book, Long> {
}