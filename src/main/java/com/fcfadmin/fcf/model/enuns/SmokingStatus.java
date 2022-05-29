package com.fcfadmin.fcf.model.enuns;

public enum SmokingStatus {

    UNKNOWN(0), NEVER_SMOKED(1), FORMERLY_SMOKED(2), SMOKES(3);

    private final Integer id;

    SmokingStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
