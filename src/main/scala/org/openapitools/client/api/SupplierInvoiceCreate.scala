package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import SupplierInvoiceCreate._

case class SupplierInvoiceCreate (
  currency: Option[String],
/* References the goods receipt entity. */
  goodsReceiptId: Option[String],
invoiceDate: LocalDate,
invoiceNumber: String,
/* JSON array of `{product_id, name, quantity, unitPriceNet, taxRate}`. */
  lineItems: AnyType,
notes: Option[String],
/* References the purchase order entity. */
  purchaseOrderId: Option[String],
/* One of: draft | matched | has_variances | posted | cancelled */
  status: SupplierInvoiceStatus,
/* References the supplier entity. */
  supplierContactId: Option[String],
supplierName: Option[String],
totalGrossAmount: Option[String],
totalNetAmount: Option[String])

object SupplierInvoiceCreate {
  import DateTimeCodecs._

  implicit val SupplierInvoiceCreateCodecJson: CodecJson[SupplierInvoiceCreate] = CodecJson.derive[SupplierInvoiceCreate]
  implicit val SupplierInvoiceCreateDecoder: EntityDecoder[SupplierInvoiceCreate] = jsonOf[SupplierInvoiceCreate]
  implicit val SupplierInvoiceCreateEncoder: EntityEncoder[SupplierInvoiceCreate] = jsonEncoderOf[SupplierInvoiceCreate]
}
