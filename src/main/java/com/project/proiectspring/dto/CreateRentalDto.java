package com.project.proiectspring.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateRentalDto {

    @NotNull
    private long book_id;

    @NotNull
    private long user_id;

    @NotBlank
    private String rentalDate;

    @NotBlank
    private String dueDate;

    public CreateRentalDto() {
    }

    public CreateRentalDto(long book_id, long user_id, String rentalDate, String dueDate) {
        this.book_id = book_id;
        this.user_id = user_id;
        this.rentalDate = rentalDate;
        this.dueDate = dueDate;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(String rentalDate) {
        this.rentalDate = rentalDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
