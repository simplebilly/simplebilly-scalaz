package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SupplierInvoiceStatusUpdate._

case class SupplierInvoiceStatusUpdate (
  status: String)

object SupplierInvoiceStatusUpdate {
  import DateTimeCodecs._

  implicit val SupplierInvoiceStatusUpdateCodecJson: CodecJson[SupplierInvoiceStatusUpdate] = CodecJson.derive[SupplierInvoiceStatusUpdate]
  implicit val SupplierInvoiceStatusUpdateDecoder: EntityDecoder[SupplierInvoiceStatusUpdate] = jsonOf[SupplierInvoiceStatusUpdate]
  implicit val SupplierInvoiceStatusUpdateEncoder: EntityEncoder[SupplierInvoiceStatusUpdate] = jsonEncoderOf[SupplierInvoiceStatusUpdate]
}
