package dev.manas.Bookstore.entity;

import dev.manas.Bookstore.constant.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book extends BaseModel {
    private String title;
    private String Author;
    private Category category;
    private float price;
    //Amount of book available
    private int totalCount;
    //total number of copies sold
    private int sold;
}
