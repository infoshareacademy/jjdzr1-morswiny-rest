package com.isa.morswiny.dto;

import java.util.Objects;

public class PlaceDto {

    private Integer placeId;
    private String id;
    private String subname;
    private String name;

    public PlaceDto() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceDto placeDto = (PlaceDto) o;
        return Objects.equals(placeId, placeDto.placeId) &&
                Objects.equals(id, placeDto.id) &&
                Objects.equals(subname, placeDto.subname) &&
                Objects.equals(name, placeDto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeId, id, subname, name);
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
