package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import StilleExportResponse._

case class StilleExportResponse (
  csvContent: String,
filename: String)

object StilleExportResponse {
  import DateTimeCodecs._

  implicit val StilleExportResponseCodecJson: CodecJson[StilleExportResponse] = CodecJson.derive[StilleExportResponse]
  implicit val StilleExportResponseDecoder: EntityDecoder[StilleExportResponse] = jsonOf[StilleExportResponse]
  implicit val StilleExportResponseEncoder: EntityEncoder[StilleExportResponse] = jsonEncoderOf[StilleExportResponse]
}
