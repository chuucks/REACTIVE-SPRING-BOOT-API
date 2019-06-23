package com.codesolt.springbootreactive.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommonResponse {

    @JsonProperty("success")
    private Boolean success;

    @JsonProperty("message")
    private String message;
}
