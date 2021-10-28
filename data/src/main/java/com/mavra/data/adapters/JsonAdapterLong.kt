package com.mavra.data.adapters

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @user mustafa.kilic
 * @since 28.10.2021
 */

@Singleton
class JsonAdapterLong @Inject constructor() : JsonAdapter<Long>() {
    override fun fromJson(reader: JsonReader): Long {
        return if (reader.peek() == JsonReader.Token.NULL) {
            reader.nextNull<Unit>()
            0L
        } else {
            reader.nextLong()
        }
    }

    override fun toJson(writer: JsonWriter, value: Long?) {
        writer.value(value)
    }
}


