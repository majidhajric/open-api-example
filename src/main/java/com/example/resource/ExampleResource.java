package com.example.resource;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@Data
public class ExampleResource implements Serializable {

    private Long id;

    @NotBlank
    @Size(min = 0, max = 20)
    private String title;

}
