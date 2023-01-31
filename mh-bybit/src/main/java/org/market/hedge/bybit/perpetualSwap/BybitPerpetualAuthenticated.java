package org.market.hedge.bybit.perpetualSwap;

import org.knowm.xchange.bybit.dto.BybitResult;
import org.knowm.xchange.bybit.service.BybitException;
import org.market.hedge.bybit.perpetualSwap.dto.trade.req.BybitPerpetualOrderReq;
import org.market.hedge.bybit.perpetualSwap.dto.trade.resp.BybitPerpetualPosition;
import si.mazi.rescu.ParamsDigest;
import si.mazi.rescu.SynchronizedValueFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public interface BybitPerpetualAuthenticated extends BybitPerpetual{

    @POST
    @Path("/private/linear/order/create")
    BybitResult<BybitPerpetualOrderReq> placeOrder(
            @FormParam("api_key") String var1,
            @FormParam("symbol") String var2,
            // Limit 限價單  Market 市價單
            @FormParam("order_type") String orderType,
            // 委托數量(加密貨幣)
            @FormParam("qty") String var3,
            @FormParam("price") String price,
            //- `GoodTillCancel`一直有效至取消
            //- `ImmediateOrCancel`立即成交或取消
            //- `FillOrKill`完全成交或取消
            //- `PostOnly`被動委托
            @FormParam("time_in_force") String timeInForce,
            //true-平倉 false-開倉,ture時止盈止損設置不生效
            @FormParam("reduce_only") String reduceOnly,
            //只會減少您的倉位而不會增加您的倉位。如果當平倉委托被觸發時，
            // 賬戶上的余額不足，那麽該合約的其他委托將被取消或者降低委托數量。
            // 使用此選項可以確保您的止損單被用於減倉而非加倉。
            @FormParam("close_on_trigger") String closeOnTrigger,
            //持仓模式 0-單向持倉 1-雙向持倉Buy 2-雙向持倉Sell
            @FormParam("position_idx") Integer positionIdx,
            @FormParam("side") String var5,
            @FormParam("timestamp") SynchronizedValueFactory<Long> var7,
            @FormParam("sign") ParamsDigest var8) throws IOException, BybitException;

    @POST
    @Path("/private/linear/order/cancel-all")
    BybitResult<List<String>> cancelAll(
            @FormParam("api_key") String var1,
            @FormParam("symbol") String var2,
            @FormParam("timestamp") SynchronizedValueFactory<Long> var7,
            @FormParam("sign") ParamsDigest var8) throws IOException, BybitException;

    @POST
    @Path("/private/linear/position/switch-mode")
    BybitResult<String> switchMode(
            @FormParam("api_key") String var1,
            @FormParam("symbol") String var2,
            @FormParam("mode") String var3,
            @FormParam("timestamp") SynchronizedValueFactory<Long> var7,
            @FormParam("sign") ParamsDigest var8) throws IOException, BybitException;

/*
    @GET
    @Path("/private/linear/position/list")
    BybitResult<List<BybitPerpetualPosition>> position(
            @QueryParam("api_key") String var1,
            @QueryParam("symbol") String var2,
            @QueryParam("timestamp") SynchronizedValueFactory<Long> var7,
            @QueryParam("sign") ParamsDigest var8) throws IOException, BybitException;
*/


    @GET
    @Path("/private/linear/position/list")
    BybitResult<List<BybitPerpetualPosition>> position(
            @QueryParam("api_key") String var1,
            @QueryParam("symbol") String var2,
            @QueryParam("timestamp") Long var7,
            @QueryParam("sign") String var8) throws IOException, BybitException;

}
