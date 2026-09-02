package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GoBDExportResponse._

case class GoBDExportResponse (
  bookingCount: Integer,
csvContent: String,
filename: String)

object GoBDExportResponse {
  import DateTimeCodecs._

  implicit val GoBDExportResponseCodecJson: CodecJson[GoBDExportResponse] = CodecJson.derive[GoBDExportResponse]
  implicit val GoBDExportResponseDecoder: EntityDecoder[GoBDExportResponse] = jsonOf[GoBDExportResponse]
  implicit val GoBDExportResponseEncoder: EntityEncoder[GoBDExportResponse] = jsonEncoderOf[GoBDExportResponse]
}
