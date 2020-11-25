package com.example.demospringboot.linebusiness.infrastructure.repositories.mongo.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Data
@Document
public class BookCatalog {
    @MongoId(FieldType.INT64)
    private Long bookId;
    @Field
    private String bookCatalog;
}
