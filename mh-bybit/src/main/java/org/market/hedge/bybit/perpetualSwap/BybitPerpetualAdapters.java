package org.market.hedge.bybit.perpetualSwap;

import org.knowm.xchange.bybit.BybitAdapters;
import org.knowm.xchange.dto.Order;

public class BybitPerpetualAdapters extends BybitAdapters {

    public static String getReduceOnly(Order.OrderType side) {
        switch (side){
            case ASK:
            case BID:
                return "false";
            case EXIT_ASK:
            case EXIT_BID:
                return "true";
            default:
                throw new IllegalArgumentException("invalid order type");
        }
    }

    public static String getSideString(Order.OrderType type) {
        switch (type){
            case ASK:
            case EXIT_BID:
                return "Sell";
            case BID:
            case EXIT_ASK:
                return "Buy";
            default:
                throw new IllegalArgumentException("invalid order type");
        }
    }

}
