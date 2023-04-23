package com.thieu.preconfig.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDto {
    private String key;
    private String value;
}
