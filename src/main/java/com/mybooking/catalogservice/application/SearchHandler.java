package com.mybooking.catalogservice.application;

import com.mybooking.catalogservice.domain.entities.Book;
import com.mybooking.catalogservice.domain.entities.Category;
import com.mybooking.catalogservice.domain.exceptions.SomethingHappendInBackendException;
import com.mybooking.catalogservice.domain.services.SearchService;
import com.mybooking.catalogservice.repositories.CatalogDbRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchHandler {
    @Autowired
    SearchService searchService;

    @Autowired
    CatalogDbRepository dbRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Book> getBooksByCategory(String categoryName) throws SQLException, SomethingHappendInBackendException {
        try{
        Category category = new Category();
        List<Book> myBooks = new ArrayList<>();
        category.setName(categoryName);
        if (searchService.validateCategory(category)) {
            List<Book> bookResults = dbRepository.getBookInfoByCategoryName(jdbcTemplate,  categoryName);
            myBooks = searchService.validateBookResult(bookResults);

        }
            return myBooks;
        }catch (NullPointerException e){
            throw new SomethingHappendInBackendException();
        }
    }
}
