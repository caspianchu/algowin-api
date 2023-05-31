package org.market.hedge.binance.option.dto.marketdat.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionAsset {

    /**
     * ID
     */
    @JsonProperty("id")
    private Integer id;

    /**
     * 资产名
     */
    @JsonProperty("name")
    private String name;
}