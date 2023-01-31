package org.market.hedge.core;

public enum TimeInForce {

    /**
     *  - Good Till Cancel 成交为止
     * * * */
    GTC,
    /**
     *  - Immediate or Cancel 无法立即成交(吃单)的部分就撤销
     * * * */
    IOC,
    /**
     *  - Fill or Kill 无法全部立即成交就撤销
     * * * */
    FOK,
    /**
     * - PostOnly`被動委托
     * * 判断以该报价提交的限价单会不会一成功发出就成交，从而提取了市场的流动性。
     * * 一旦属于上述情况，那么这个限价单就会被自动取消，否则将会顺利发出。
     * 以被动委托方式下单的投资者永远不可能成为taker，永远是maker，
     * * 作为maker，一旦挂的单子被成交，就可以获得返佣。
     * * 所以这种做法是为特别在意获得返佣的投资者量身定做的。*
     * * * */
    PO;

}
