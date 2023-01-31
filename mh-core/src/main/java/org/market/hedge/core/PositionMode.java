package org.market.hedge.core;

import lombok.Getter;


@Getter
public enum PositionMode {

    /**
     * MergedSingle - 單倉模式
     * */
    MergedSingle,
    /**
     * BothSide - 雙倉模式
     * * * */
    BothSide;

}
