package org.market.hedge.binance.option.dto.marketdat.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeInfo {

    /**
     * "timezone": "UTC",    // 交易所时区
     */
    @JsonProperty("timezone")
    private String timezone;

    /**
     * "serverTime": 1577836800000,    // 服务器时间
     */
    @JsonProperty("serverTime")
    private Long serverTime;

    @JsonProperty("optionSymbols")
    List<OptionSymbols> optionSymbols;

    /**
     * 期权合约底层资产信息
     */
    @JsonProperty("optionContracts")
    private List<OptionContract> optionContracts;

    /**
     * 期权系统支持资产
     */
    @JsonProperty("optionAssets")
    private List<OptionAsset> optionAssets;

    /**
     * 限制信息
     */
    @JsonProperty("rateLimits")
    private List<RateLimit> rateLimits;

}
