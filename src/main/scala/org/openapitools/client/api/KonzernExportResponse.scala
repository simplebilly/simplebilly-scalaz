package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import KonzernExportResponse._

case class KonzernExportResponse (
  csvContent: String,
filename: String)

object KonzernExportResponse {
  import DateTimeCodecs._

  implicit val KonzernExportResponseCodecJson: CodecJson[KonzernExportResponse] = CodecJson.derive[KonzernExportResponse]
  implicit val KonzernExportResponseDecoder: EntityDecoder[KonzernExportResponse] = jsonOf[KonzernExportResponse]
  implicit val KonzernExportResponseEncoder: EntityEncoder[KonzernExportResponse] = jsonEncoderOf[KonzernExportResponse]
}
