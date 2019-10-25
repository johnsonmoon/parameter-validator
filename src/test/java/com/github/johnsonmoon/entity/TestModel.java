package com.github.johnsonmoon.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Create by xuyh at 2019/9/23 14:26.
 */
@Valid
public class TestModel {
    @NotNull(message = "ID is null！")
    private String id;

    @NotNull(message = "name is null！")
    @NotEmpty(message = "name is empty!")
    private String name;

    @Size(max = 1000, message = "max length is 1000!")
    private String description;

    @Size(max = 10)
    private String color;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
