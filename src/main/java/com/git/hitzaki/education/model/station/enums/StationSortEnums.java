package com.git.hitzaki.education.model.station.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum StationSortEnums {
    STATION("",""),
    ;
    private final String k;
    private final String value;

    public String getValue() {
        return value;
    }

    public String getK() {
        return k;
    }
}
