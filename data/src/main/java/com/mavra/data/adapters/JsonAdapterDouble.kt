package com.mavra.data.adapters

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JsonAdapterDouble @Inject constructor(): JsonAdapter<Double>(){
    override fun fromJson(reader: JsonReader): Double {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<Unit>()
            0.0
        } else {
            reader.nextDouble()
        }
    }

    override fun toJson(writer: JsonWriter, value: Double?) {
        writer.value(value)
    }
}
