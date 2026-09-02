package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DatevExportResponse._

case class DatevExportResponse (
  bookingCount: Integer,
csvContent: String,
filename: String)

object DatevExportResponse {
  import DateTimeCodecs._

  implicit val DatevExportResponseCodecJson: CodecJson[DatevExportResponse] = CodecJson.derive[DatevExportResponse]
  implicit val DatevExportResponseDecoder: EntityDecoder[DatevExportResponse] = jsonOf[DatevExportResponse]
  implicit val DatevExportResponseEncoder: EntityEncoder[DatevExportResponse] = jsonEncoderOf[DatevExportResponse]
}
