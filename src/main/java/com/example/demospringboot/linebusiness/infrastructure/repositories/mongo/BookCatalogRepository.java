package com.example.demospringboot.linebusiness.infrastructure.repositories.mongo;

import com.example.demospringboot.linebusiness.infrastructure.repositories.mongo.entity.BookCatalog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookCatalogRepository extends MongoRepository<BookCatalog, Long> {
}
