package org.market.hedge.binance.option.dto.marketdat.resp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateLimit {

    /**
     * 限制类型
     */
    @JsonProperty("rateLimitType")
    private String rateLimitType;

    /**
     * 间隔
     */
    @JsonProperty("interval")
    private String interval;

    /**
     * 间隔数量
     */
    @JsonProperty("intervalNum")
    private Integer intervalNum;

    /**
     * 限制
     */
    @JsonProperty("limit")
    private Integer limit;
}