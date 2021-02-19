package com.mybooking.catalogservice.services;

import com.mybooking.catalogservice.domain.entities.Book;
import com.mybooking.catalogservice.domain.services.SearchService;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class SearchServiceTest {
    SearchService  searchService = new SearchService();

    @Test
    public void categoryNameIsNull(){

    }

    @Test
    public void bookPriceIsUnderZero(){
        Book book = new Book();
        book.setPrice(-10.0);

        boolean isValid = searchService.validatePriceOfBook( book);
        Assert.isTrue(!isValid);
    }
}
