package com.krigersv.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthorizationModel {
    @JsonProperty("created_date")
    private String createdDate;
    private String expires, password, token, userId, username;
    private Boolean isActive;
}
