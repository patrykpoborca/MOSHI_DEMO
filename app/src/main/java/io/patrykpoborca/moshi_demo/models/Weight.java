package io.patrykpoborca.moshi_demo.models;

public class Weight {

    private WeightType unitType;
    private double value;

    public WeightType getUnitType() {
        return unitType;
    }

    public void setUnitType(WeightType unitType) {
        this.unitType = unitType;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public enum WeightType {
        KG,
        LBS
    }
}
