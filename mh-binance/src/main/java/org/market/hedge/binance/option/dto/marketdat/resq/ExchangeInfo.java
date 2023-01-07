package org.market.hedge.binance.option.dto.marketdat.resq;

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

}
