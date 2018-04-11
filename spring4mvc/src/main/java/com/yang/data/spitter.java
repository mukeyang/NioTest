package com.yang.data;



import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by CS on 2018/4/11.
 */
public class spitter {
    @NotNull
    @Min(4)
    private int id;
    @NotNull
    @Size(min = 5,max = 30)
    private String name;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "spitter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
