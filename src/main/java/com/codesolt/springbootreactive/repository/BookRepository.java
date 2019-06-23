package com.codesolt.springbootreactive.repository;

import com.codesolt.springbootreactive.model.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Profile({"prod", "cassandraTest"})
public interface BookRepository extends ReactiveCassandraRepository<Book, UUID> {}
