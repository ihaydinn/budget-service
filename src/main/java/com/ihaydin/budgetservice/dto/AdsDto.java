package com.ihaydin.budgetservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ismailhakkiaydin
 * @date 21, January, 2022
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdsDto {
    private Long id;
    private boolean isNoAds;
}
