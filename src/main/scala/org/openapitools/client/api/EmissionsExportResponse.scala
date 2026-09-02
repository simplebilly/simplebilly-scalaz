package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EmissionsExportResponse._

case class EmissionsExportResponse (
  csvContent: String,
filename: String)

object EmissionsExportResponse {
  import DateTimeCodecs._

  implicit val EmissionsExportResponseCodecJson: CodecJson[EmissionsExportResponse] = CodecJson.derive[EmissionsExportResponse]
  implicit val EmissionsExportResponseDecoder: EntityDecoder[EmissionsExportResponse] = jsonOf[EmissionsExportResponse]
  implicit val EmissionsExportResponseEncoder: EntityEncoder[EmissionsExportResponse] = jsonEncoderOf[EmissionsExportResponse]
}
