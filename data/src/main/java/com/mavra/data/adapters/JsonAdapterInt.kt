package com.mavra.data.adapters

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JsonAdapterInt @Inject constructor() : JsonAdapter<Int>() {
    override fun fromJson(reader: JsonReader): Int {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<Unit>()
            0
        } else {
            reader.nextInt()
        }
    }

    override fun toJson(writer: JsonWriter, value: Int?) {
        writer.value(value)
    }
}