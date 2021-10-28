package com.mavra.data.adapters

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class JsonAdapterString @Inject constructor() : JsonAdapter<String>() {
    override fun fromJson(reader: JsonReader): String {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<Unit>()
            ""
        } else {
            reader.nextString() ?: ""
        }
    }

    override fun toJson(writer: JsonWriter, value: String?) {
        writer.value(value)
    }
}


