package org.market.hedge.binance.option.dto.marketdat.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionContract {

    /**
     * ID
     */
    @JsonProperty("id")
    private Integer id;

    /**
     * 标的资产
     */
    @JsonProperty("baseAsset")
    private String baseAsset;

    /**
     * 报价资产
     */
    @JsonProperty("quoteAsset")
    private String quoteAsset;

    /**
     * 期权合约底层资产
     */
    @JsonProperty("underlying")
    private String underlying;

    /**
     * 结算资产
     */
    @JsonProperty("settleAsset")
    private String settleAsset;
}