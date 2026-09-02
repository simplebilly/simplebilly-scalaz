package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import InvoiceStatus._

case class InvoiceStatus (
  
object InvoiceStatus {
  import DateTimeCodecs._

  implicit val InvoiceStatusCodecJson: CodecJson[InvoiceStatus] = CodecJson.derive[InvoiceStatus]
  implicit val InvoiceStatusDecoder: EntityDecoder[InvoiceStatus] = jsonOf[InvoiceStatus]
  implicit val InvoiceStatusEncoder: EntityEncoder[InvoiceStatus] = jsonEncoderOf[InvoiceStatus]
}
