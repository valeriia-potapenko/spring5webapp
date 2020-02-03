package guru.springframework.spring5webapp.repository

import guru.springframework.spring5webapp.model.Author
import org.springframework.data.repository.CrudRepository

interface AuthorRepository: CrudRepository<Author, Long> {
}