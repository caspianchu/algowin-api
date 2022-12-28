package org.market.hedge.bybit.perpetualSwap;

import org.knowm.xchange.bybit.dto.BybitResult;
import org.market.hedge.bybit.perpetualSwap.dto.marketData.resp.BybitSymbol;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.List;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public interface BybitPerpetual {

    /**
     * 獲取合約信息.
     * */
    @GET
    @Path("/v2/public/symbols")
    BybitResult<List<BybitSymbol>> symbols() throws IOException;

}
