package dev.manas.Bookstore.dto;

import dev.manas.Bookstore.constant.Category;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookStoreResponseDto {

    @ApiModelProperty(value="Id should be unique and not null")
    private long id;
    @ApiModelProperty(value="Title of the book")
    private String title;
    @ApiModelProperty(value="Author of the book")
    private String Author;
    @ApiModelProperty(value="Category of the book")
    private Category category;
    @ApiModelProperty(value = "Price of the book")
    @Min(value = 0, message = "Price should be positive value.")
    private float price;
    @ApiModelProperty(value = "Total number of books available on the store")
    private int totalCount;

}
