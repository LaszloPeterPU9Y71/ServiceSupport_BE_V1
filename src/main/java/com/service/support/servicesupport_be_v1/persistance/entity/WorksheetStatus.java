package com.service.support.servicesupport_be_v1.persistance.entity;

public enum WorksheetStatus {
    BEERKEZETT("Beérkezett"),
    FOLYAMATBAN("Folyamatban"),
    FELKULDVE("Felküldve"),
    VISSZAERKEZETT("Visszaérkezett"),
    KIAJANLOTT("Kiajánlott"),
    ELFOGADVA("Elfogadva"),
    KIERTESTVE("Kiértesítve"),
    LEZART("Lezárt");

    private final String label;

    WorksheetStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
