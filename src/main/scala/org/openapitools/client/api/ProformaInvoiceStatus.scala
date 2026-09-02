package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ProformaInvoiceStatus._

case class ProformaInvoiceStatus (
  
object ProformaInvoiceStatus {
  import DateTimeCodecs._

  implicit val ProformaInvoiceStatusCodecJson: CodecJson[ProformaInvoiceStatus] = CodecJson.derive[ProformaInvoiceStatus]
  implicit val ProformaInvoiceStatusDecoder: EntityDecoder[ProformaInvoiceStatus] = jsonOf[ProformaInvoiceStatus]
  implicit val ProformaInvoiceStatusEncoder: EntityEncoder[ProformaInvoiceStatus] = jsonEncoderOf[ProformaInvoiceStatus]
}
