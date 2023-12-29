package com.project.proiectspring.dto;

public class UpdateRentalDto extends CreateRentalDto {

    private long id;

    public UpdateRentalDto() {
    }

    public UpdateRentalDto(long id, long book_id, long user_id, String rentalDate, String dueDate) {
        super(book_id, user_id, rentalDate, dueDate);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
