package com.mybooking.catalogservice.repositories;

import com.mybooking.catalogservice.domain.entities.Author;
import com.mybooking.catalogservice.domain.entities.Book;
import com.mybooking.catalogservice.domain.entities.Category;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class CatalogDbRepository {
    public List<Book> getBookInfoByCategoryName(JdbcTemplate connector, String categoryName) throws SQLException {
        List<Book> books = connector.query("SELECT book.name AS book_name, category.Name category_name, author.Name AS author_name, book.price  FROM book \n" +
                        "INNER JOIN category ON book.Category_Id = category.id \n" +
                        "INNER JOIN author ON book.Author_Id = author.id " +
                        "WHERE category.Name=\"" + categoryName + "\"",
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
        );
        return books;
    }
}