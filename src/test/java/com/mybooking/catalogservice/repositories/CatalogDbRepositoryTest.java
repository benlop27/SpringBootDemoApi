package com.mybooking.catalogservice.repositories;

import com.mybooking.catalogservice.domain.entities.Author;
import com.mybooking.catalogservice.domain.entities.Book;
import com.mybooking.catalogservice.domain.entities.Category;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.Assert;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.mockito.Mockito.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CatalogDbRepositoryTest {
    CatalogDbRepository catalogDbRepository = new CatalogDbRepository();

    @Test
    public void queryIsNotValid(){
        try {

            //Definition
            List<Book> booksMocked = new ArrayList();
            Book book = mock(Book.class);
            booksMocked.add(book);
            JdbcTemplate connector = mock(JdbcTemplate.class);
            when(connector.query("SELECT book.name AS book_name, category.Name category_name, author.Name AS author_name, book.price  FROM book \n" +
                            "INNER JOIN category ON book.Category_Id = category.id \n" +
                            "INNER JOIN author ON book.Author_Id = author.id " +
                            "WHERE category.Name=\"" + "azul" + "\"",
                    new RowMapper<Book>() {
                        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                            Book book = new Book();
                            Author author = new Author();
                            author.setName(rs.getString("author_name"));
                            Category category = new Category();
                            category.setName(rs.getString("category_name"));
                            book.setAuthor(author);
                            book.setName(rs.getString("book_name"));
                            book.setCategory(category);
                            book.setPrice(rs.getDouble("price"));
                            return book;
                        }
                    }
            )).thenReturn(booksMocked);
            //Test
            List<Book> datos = catalogDbRepository.getBookInfoByCategoryName(connector,"azul");

            //Action
            Assert.notNull(datos);
        } catch (SQLException e) {
            Assert.isTrue(false);
        }

    }
}
