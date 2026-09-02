package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.time.OffsetDateTime

import ProformaInvoiceCreate._

case class ProformaInvoiceCreate (
  convertedAt: Option[OffsetDateTime],
/* Set when the proforma was converted into a real invoice. References the invoice entity. */
  convertedToInvoiceId: Option[String],
currency: CurrencyCode,
/* References the customer entity. */
  customerId: Option[String],
/* Snapshot of the recipient at issue time (address, VAT id, …). */
  customerSnapshot: Option[AnyType],
issueDate: LocalDate,
lineItems: AnyType,
notes: Option[String],
/* Reference to the order/quote this proforma belongs to. */
  orderNumber: Option[String],
/* Optional deadline the real invoice should carry after conversion. */
  paymentDueDate: Option[LocalDate],
/* References the quotation entity. */
  quotationId: Option[String],
/* `draft` | `sent` | `converted`. */
  status: ProformaInvoiceStatus,
subtotal: String,
totalAmount: String,
totalTax: String)

object ProformaInvoiceCreate {
  import DateTimeCodecs._

  implicit val ProformaInvoiceCreateCodecJson: CodecJson[ProformaInvoiceCreate] = CodecJson.derive[ProformaInvoiceCreate]
  implicit val ProformaInvoiceCreateDecoder: EntityDecoder[ProformaInvoiceCreate] = jsonOf[ProformaInvoiceCreate]
  implicit val ProformaInvoiceCreateEncoder: EntityEncoder[ProformaInvoiceCreate] = jsonEncoderOf[ProformaInvoiceCreate]
}
