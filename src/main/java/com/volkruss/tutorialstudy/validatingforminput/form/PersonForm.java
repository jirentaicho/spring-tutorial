package com.volkruss.tutorialstudy.validatingforminput.form;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PersonForm{
    @NotNull
    @Size(min=2, max=30)
    private String name;

    @Override
    public String toString() {
        return "PersonForm{" +
                "name='" + name + '\'' +
                '}';
    }
}
