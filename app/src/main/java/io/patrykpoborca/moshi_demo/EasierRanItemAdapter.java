package io.patrykpoborca.moshi_demo;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import java.util.Map;

import io.patrykpoborca.moshi_demo.models.RanItem;

public class EasierRanItemAdapter {

    @FromJson
    RanItem ranItem(Map<String, Object> ranUnwrap) {
        RanItem ranItem = new RanItem();
        ranItem.setValue((String) ranUnwrap.get("value"));
        ranItem.setRandom((int) (Math.random() * 300));
        return ranItem;
    }

    @ToJson
    String serialize(RanItem ranItem) {
        return "{}";
    }
}
