package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SupplierInvoiceStatus._

case class SupplierInvoiceStatus (
  
object SupplierInvoiceStatus {
  import DateTimeCodecs._

  implicit val SupplierInvoiceStatusCodecJson: CodecJson[SupplierInvoiceStatus] = CodecJson.derive[SupplierInvoiceStatus]
  implicit val SupplierInvoiceStatusDecoder: EntityDecoder[SupplierInvoiceStatus] = jsonOf[SupplierInvoiceStatus]
  implicit val SupplierInvoiceStatusEncoder: EntityEncoder[SupplierInvoiceStatus] = jsonEncoderOf[SupplierInvoiceStatus]
}
