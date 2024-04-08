package rs.raf.projekatjun.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class EventResponse(
    val abbreviation: String,
    val client_ip:String,
    @Json(name="datetime")
    val datetime: String,
    val day_of_week: String,
    val day_of_year: String,
    val dst: Boolean,
    val dst_from: String,
    val dst_offset: String,
    val dst_until: String,
    val raw_offset: String,
    val timezone: String,
    val unixtime: String,
    val utc_datetime: String,
    val utc_offset: String,
    val week_number: String
)