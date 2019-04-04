package com.dagger2.sample.network

import com.google.gson.*
import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat
import java.lang.reflect.Type

/**
 * Copyright (c), 2018-2019
 * @author: lixin
 * Date: 2019/4/3
 * Description:
 */
class DateTimeConverter: JsonSerializer<DateTime>, JsonDeserializer<DateTime> {
    override fun serialize(src: DateTime?, typeOfSrc: Type?, context: JsonSerializationContext?): JsonElement {
        val fmt = ISODateTimeFormat.dateTimeParser()
        return JsonPrimitive(fmt.print(src))
    }

    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): DateTime? {
        if (json?.asString == null || json.asString.isEmpty()) {
            return null
        }
        val fmt = ISODateTimeFormat.dateTimeParser()
        return fmt.parseDateTime(json.asString)
    }
}