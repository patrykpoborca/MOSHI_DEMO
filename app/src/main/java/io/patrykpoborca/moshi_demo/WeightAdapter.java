package io.patrykpoborca.moshi_demo;

import com.squareup.moshi.FromJson;

import java.util.Locale;
import java.util.Map;

import io.patrykpoborca.moshi_demo.models.Weight;

public class WeightAdapter {

    private static final double KG_TO_LBS = 2.20462;

    @FromJson
    Weight toWeight(Map<String, Object> map) {
        Weight weight = new Weight();
        weight.setUnitType(map.get("unitType").equals("LBS") ? Weight.WeightType.LBS : Weight.WeightType.KG);
        weight.setValue((Double) map.get("value"));

        if(Locale.getDefault().equals(Locale.US) && weight.getUnitType() == Weight.WeightType.KG) {
            weight.setUnitType(Weight.WeightType.LBS);
            weight.setValue(weight.getValue() * KG_TO_LBS);
        }
        else if(!Locale.getDefault().equals(Locale.US) && weight.getUnitType() == Weight.WeightType.LBS) {
            weight.setUnitType(Weight.WeightType.KG);
            weight.setValue(weight.getValue() / KG_TO_LBS);
        }
        return weight;
    }
}
