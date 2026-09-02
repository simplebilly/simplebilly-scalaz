package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import InvoicePdfUrlResponse._

case class InvoicePdfUrlResponse (
  url: String)

object InvoicePdfUrlResponse {
  import DateTimeCodecs._

  implicit val InvoicePdfUrlResponseCodecJson: CodecJson[InvoicePdfUrlResponse] = CodecJson.derive[InvoicePdfUrlResponse]
  implicit val InvoicePdfUrlResponseDecoder: EntityDecoder[InvoicePdfUrlResponse] = jsonOf[InvoicePdfUrlResponse]
  implicit val InvoicePdfUrlResponseEncoder: EntityEncoder[InvoicePdfUrlResponse] = jsonEncoderOf[InvoicePdfUrlResponse]
}
