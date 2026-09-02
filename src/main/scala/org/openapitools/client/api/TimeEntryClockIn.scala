package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import TimeEntryClockIn._

case class TimeEntryClockIn (
  notes: Option[String])

object TimeEntryClockIn {
  import DateTimeCodecs._

  implicit val TimeEntryClockInCodecJson: CodecJson[TimeEntryClockIn] = CodecJson.derive[TimeEntryClockIn]
  implicit val TimeEntryClockInDecoder: EntityDecoder[TimeEntryClockIn] = jsonOf[TimeEntryClockIn]
  implicit val TimeEntryClockInEncoder: EntityEncoder[TimeEntryClockIn] = jsonEncoderOf[TimeEntryClockIn]
}
