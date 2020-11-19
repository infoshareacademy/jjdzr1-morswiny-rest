package com.isa.morswiny.services;

import com.isa.morswiny.Dao.PlaceDao;
import com.isa.morswiny.dto.PlaceDto;
import com.isa.morswiny.model.Place;

import javax.inject.Inject;

public class PlaceService {

    @Inject
    private PlaceDao placeDao;

    private PlaceDto placeToDto(Place place){
        PlaceDto placeDto = new PlaceDto();
        placeDto.setId(place.getId());
        placeDto.setName(place.getName());
        placeDto.setPlaceId(place.getPlaceId());
        placeDto.setSubname(place.getSubname());
        return placeDto;

    }

    private Place dtoToPlace(PlaceDto placeDto){
        Place place = new Place();
        place.setId(placeDto.getId());
        place.set
    }




}