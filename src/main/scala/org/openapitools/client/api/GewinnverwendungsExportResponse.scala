package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GewinnverwendungsExportResponse._

case class GewinnverwendungsExportResponse (
  csvContent: String,
filename: String)

object GewinnverwendungsExportResponse {
  import DateTimeCodecs._

  implicit val GewinnverwendungsExportResponseCodecJson: CodecJson[GewinnverwendungsExportResponse] = CodecJson.derive[GewinnverwendungsExportResponse]
  implicit val GewinnverwendungsExportResponseDecoder: EntityDecoder[GewinnverwendungsExportResponse] = jsonOf[GewinnverwendungsExportResponse]
  implicit val GewinnverwendungsExportResponseEncoder: EntityEncoder[GewinnverwendungsExportResponse] = jsonEncoderOf[GewinnverwendungsExportResponse]
}
