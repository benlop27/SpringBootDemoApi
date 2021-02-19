package com.mybooking.catalogservice.domain.DTOs;

import com.mybooking.catalogservice.domain.entities.Book;

import java.sql.Timestamp;

public class BookSalePerMonth {
    Book book;
    Double totalPrice;
    String Month;
    String Year;
    int Quantity;
}
