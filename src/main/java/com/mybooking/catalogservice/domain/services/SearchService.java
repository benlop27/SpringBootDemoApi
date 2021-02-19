package com.mybooking.catalogservice.domain.services;
import com.mybooking.catalogservice.domain.entities.Book;
import com.mybooking.catalogservice.domain.entities.Category;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
public class SearchService {

    public boolean validateCategory(Category category){
        if(category.getName()!=null)return true;
        return false;
    }

    public List<Book> validateBookResult(List<Book> bookResult) throws SQLException {
        ArrayList<Book> books = new ArrayList<>();
           bookResult.forEach(book -> {
            if(book.getName()!=null){
                books.add(book);
            }
           });

        return  books;
    }

    public boolean validatePriceOfBook(Book book){
        if(book.getPrice()<0.0){return false;}
        return  true;
    }
}
