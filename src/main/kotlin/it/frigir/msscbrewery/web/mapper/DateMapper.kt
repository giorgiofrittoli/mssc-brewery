package it.frigir.msscbrewery.web.mapper

import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.OffsetDateTime
import java.time.ZoneOffset

@Component
class DateMapper {
    fun asOffsetDateTime(ts: Timestamp?): OffsetDateTime {
        return OffsetDateTime.of(ts?.toLocalDateTime(), ZoneOffset.UTC)
    }

    fun asTimestamp(offsetDateTime: OffsetDateTime?): Timestamp {
        return Timestamp.valueOf(offsetDateTime?.atZoneSameInstant(ZoneOffset.UTC)?.toLocalDateTime())
    }
}