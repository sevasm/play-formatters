package controllers;

public class IntegerDto {
    private Integer integer;

    public IntegerDto(Integer integer) {
        this.integer = integer;
    }

    public IntegerDto() {
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}
