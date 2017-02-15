package io.patrykpoborca.moshi_demo;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;

import java.io.IOException;

import io.patrykpoborca.moshi_demo.models.RanItem;

public class RanItemAdapter extends JsonAdapter<RanItem> {


    @Override
    public RanItem fromJson(JsonReader reader) throws IOException {
        RanItem ranItem = new RanItem();
        reader.beginObject();
        while (reader.hasNext()) {
            if(reader.nextName().equals("value")) {
                ranItem.setValue(reader.nextString());
            }
        }
        ranItem.setRandom((int) (Math.random() * 300));
        return ranItem;
    }

    @Override
    public void toJson(JsonWriter writer, RanItem value) throws IOException {
        writer.beginObject()
                .name("value")
                .value(value.getValue())
                .name("random")
                .value(value.getRandom())
                .endObject();
    }
}
