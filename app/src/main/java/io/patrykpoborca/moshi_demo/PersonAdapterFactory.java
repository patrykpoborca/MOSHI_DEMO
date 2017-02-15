package io.patrykpoborca.moshi_demo;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import io.patrykpoborca.moshi_demo.models.Adult;
import io.patrykpoborca.moshi_demo.models.Child;
import io.patrykpoborca.moshi_demo.models.Person;

public class PersonAdapterFactory implements JsonAdapter.Factory {

    @Override
    public JsonAdapter<?> create(final Type type, Set<? extends Annotation> annotations, final Moshi moshi) {
        if(type.equals(Person.class)) {
            final JsonAdapter<Child> childJsonAdapter = moshi.adapter(Child.class);
            final JsonAdapter<Adult> adultJsonAdapter = moshi.adapter(Adult.class);
            moshi.nextAdapter(this, type, annotations);

            return new JsonAdapter<Person>() {
                @Override
                public Person fromJson(JsonReader reader) throws IOException {
                    Map<String, Object> o = (Map<String, Object>) reader.readJsonValue();
                    switch (((String)o.get("__typeName")).toLowerCase()) {
                        case "child":
                            return childJsonAdapter.fromJsonValue(o);
                        default:
                        case "adult":
                            return adultJsonAdapter.fromJsonValue(o);
                    }
                }

                @Override
                public void toJson(JsonWriter writer, Person value) throws IOException {

                }
            };
        }
        return null;
    }
}
