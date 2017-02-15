package io.patrykpoborca.moshi_demo;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAdapter {

    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");

    @FromJson
    Date toDate(String json) {
        try {
            return simpleDateFormat.parse(json);
        } catch (ParseException e) {
            return null;
        }
    }

    @ToJson
    String toJson(Date date) {
        return simpleDateFormat.format(date);
    }
}
