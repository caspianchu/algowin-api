package org.market.hedge.bybit.perpetualSwap.service;

import org.knowm.xchange.bybit.dto.BybitResult;
import org.market.hedge.bybit.BybitExchange;
import org.market.hedge.bybit.perpetualSwap.dto.trade.resp.BybitPerpetualPosition;
import org.market.hedge.core.BilateralPositionInfo;
import org.market.hedge.core.ParsingCurrencyPair;
import org.market.hedge.core.PositionInfo;
import org.market.hedge.service.account.MHAccountService;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author chuxianbo
 */
public class BybitPerpetualAccountService extends BybitPerpetualAccountServiceRaw implements MHAccountService {
    public BybitPerpetualAccountService(BybitExchange exchange) {
        super(exchange);
    }

    @Override
    public BilateralPositionInfo getBilateralPosition(ParsingCurrencyPair parsingCurrencyPair, Object... args) throws IOException {
        Long lla=this.nonceFactory.createValue();
        String param_str = "api_key="+this.apiKey+"&symbol="+parsingCurrencyPair.getParsing()+"&timestamp="+lla;
        String sign=null;
        try {
            sign=hmacSHA256(this.secretKey,param_str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BybitResult<List<BybitPerpetualPosition>> result=bybit.position(this.apiKey,
                parsingCurrencyPair.getParsing(),
                lla,
                sign);
        PositionInfo buy=PositionInfo.builder().build();
        PositionInfo sell=PositionInfo.builder().build();
        result.getResult().forEach(e->{
            if ("Buy".equals(e.getSide())){
                buy.setSymbol(e.getSymbol());
                buy.setVolume(new BigDecimal(e.getSize()));
                buy.setAvailable(new BigDecimal(e.getFree_qty()));
            }
            if ("Sell".equals(e.getSide())){
                sell.setSymbol(e.getSymbol());
                sell.setVolume(new BigDecimal(e.getSize()));
                sell.setAvailable(new BigDecimal(e.getFree_qty()));
            }
        });
        return new BilateralPositionInfo(buy,sell);
    }

    /**
     * result=[BybitPerpetualPosition(user_id=40566924, symbol=BTCUSDT, side=Buy, size=0, position_value=0, entry_price=0, liq_price=0, bust_price=0, leverage=10, auto_add_margin=0, is_isolated=false, position_margin=0, occ_closing_fee=0, realised_pnl=0, cum_realised_pnl=-0.0205271, free_qty=0, tp_sl_mode=Full, deleverage_indicator=0, unrealised_pnl=0, risk_id=1, take_profit=0, stop_loss=0, trailing_stop=0, position_idx=1, mode=BothSide),
     * BybitPerpetualPosition(user_id=40566924, symbol=BTCUSDT, side=Sell, size=0.001, position_value=19.198, entry_price=19198, liq_price=68197.5, bust_price=68293.5, leverage=10, auto_add_margin=0, is_isolated=false, position_margin=49.09593515, occ_closing_fee=0.0409761, realised_pnl=0.00190255, cum_realised_pnl=-0.55256165, free_qty=0.001, tp_sl_mode=Full, deleverage_indicator=2, unrealised_pnl=0.2235, risk_id=1, take_profit=0, stop_loss=0, trailing_stop=0, position_idx=2, mode=BothSide)]}
     * */

    /**
     * sha256_HMAC加密
     * @param message 消息
     * @param secret  秘钥
     * @return 加密后字符串
     */
    public static String hmacSHA256(String secret, String message) throws Exception{
        String hash = "";
        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        hmacSha256.init(secret_key);
        byte[] bytes = hmacSha256.doFinal(message.getBytes());
        hash = byteArrayToHexString(bytes);
        return hash;
    }

    /**
     * 将加密后的字节数组转换成字符串
     *
     * @param b 字节数组
     * @return 字符串
     */
    public  static String byteArrayToHexString(byte[] b) {
        StringBuilder hs = new StringBuilder();
        String stmp;
        for (int n = 0; b!=null && n < b.length; n++) {
            stmp = Integer.toHexString(b[n] & 0XFF);
            if (stmp.length() == 1) {
                hs.append('0');
            }
            hs.append(stmp);
        }
        return hs.toString().toLowerCase();
    }

}
