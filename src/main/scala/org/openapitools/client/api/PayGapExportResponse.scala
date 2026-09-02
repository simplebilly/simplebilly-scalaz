package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PayGapExportResponse._

case class PayGapExportResponse (
  csvContent: String,
filename: String)

object PayGapExportResponse {
  import DateTimeCodecs._

  implicit val PayGapExportResponseCodecJson: CodecJson[PayGapExportResponse] = CodecJson.derive[PayGapExportResponse]
  implicit val PayGapExportResponseDecoder: EntityDecoder[PayGapExportResponse] = jsonOf[PayGapExportResponse]
  implicit val PayGapExportResponseEncoder: EntityEncoder[PayGapExportResponse] = jsonEncoderOf[PayGapExportResponse]
}
