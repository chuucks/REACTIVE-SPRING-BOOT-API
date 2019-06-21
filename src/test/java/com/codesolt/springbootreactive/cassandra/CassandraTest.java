package com.codesolt.springbootreactive.cassandra;

import com.codesolt.springbootreactive.model.Book;
import com.codesolt.springbootreactive.repository.BookRepository;
import com.datastax.driver.core.utils.UUIDs;
import org.cassandraunit.spring.CassandraDataSet;
import org.cassandraunit.spring.CassandraUnit;
import org.cassandraunit.spring.CassandraUnitDependencyInjectionTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import reactor.core.publisher.Flux;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@ActiveProfiles("cassandraTest")
@RunWith(SpringRunner.class)
@SpringBootTest({ "spring.data.cassandra.port=9142"})
@TestExecutionListeners({ CassandraUnitDependencyInjectionTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class })
@CassandraDataSet(value = { "data_schema.cql" })
@CassandraUnit
public class CassandraTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void bookTest() {

        //Find
        Flux<Book> cassandraBooks = bookRepository.findAll();
        assertNotNull(cassandraBooks);
        Book cassandraBook = cassandraBooks.blockFirst();
        assertNotNull(cassandraBook.getId());
        assertEquals("mx", cassandraBook.getBookCurrency());

        //Save
        Book javaBook = Book.builder()
                .id(UUIDs.timeBased())
                .bookCode("new_mxn")
                .bookDescription("NEW")
                .bookCurrency("mx")
                .build();
        bookRepository.save(javaBook);

        //Update
        cassandraBook.setBookDescription("DIFF");
        bookRepository.save(cassandraBook);
    }
}
