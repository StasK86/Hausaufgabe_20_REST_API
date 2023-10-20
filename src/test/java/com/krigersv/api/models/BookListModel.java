package com.krigersv.api.models;

import lombok.Data;

import java.util.List;

@Data
public class BookListModel {
    private String userId;
    private List<CollectionModel> collectionOfIsbns;
}
