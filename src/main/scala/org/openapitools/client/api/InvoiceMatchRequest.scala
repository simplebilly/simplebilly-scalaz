package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import InvoiceMatchRequest._

case class InvoiceMatchRequest (
  supplierInvoiceId: String)

object InvoiceMatchRequest {
  import DateTimeCodecs._

  implicit val InvoiceMatchRequestCodecJson: CodecJson[InvoiceMatchRequest] = CodecJson.derive[InvoiceMatchRequest]
  implicit val InvoiceMatchRequestDecoder: EntityDecoder[InvoiceMatchRequest] = jsonOf[InvoiceMatchRequest]
  implicit val InvoiceMatchRequestEncoder: EntityEncoder[InvoiceMatchRequest] = jsonEncoderOf[InvoiceMatchRequest]
}
