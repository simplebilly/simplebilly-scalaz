package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import TimeEntryClockOut._

case class TimeEntryClockOut (
  clockOut: OffsetDateTime,
/* Optional manual hours; when absent, derived from clock_in..clock_out. */
  hours: Option[String])

object TimeEntryClockOut {
  import DateTimeCodecs._

  implicit val TimeEntryClockOutCodecJson: CodecJson[TimeEntryClockOut] = CodecJson.derive[TimeEntryClockOut]
  implicit val TimeEntryClockOutDecoder: EntityDecoder[TimeEntryClockOut] = jsonOf[TimeEntryClockOut]
  implicit val TimeEntryClockOutEncoder: EntityEncoder[TimeEntryClockOut] = jsonEncoderOf[TimeEntryClockOut]
}
