package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DatevImportResponse._

case class DatevImportResponse (
  count: Integer,
filename: String,
rows: List[DatevImportRow])

object DatevImportResponse {
  import DateTimeCodecs._

  implicit val DatevImportResponseCodecJson: CodecJson[DatevImportResponse] = CodecJson.derive[DatevImportResponse]
  implicit val DatevImportResponseDecoder: EntityDecoder[DatevImportResponse] = jsonOf[DatevImportResponse]
  implicit val DatevImportResponseEncoder: EntityEncoder[DatevImportResponse] = jsonEncoderOf[DatevImportResponse]
}
