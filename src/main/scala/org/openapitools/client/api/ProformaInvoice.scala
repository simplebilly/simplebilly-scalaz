package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.time.OffsetDateTime

import ProformaInvoice._

case class ProformaInvoice (
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

object ProformaInvoice {
  import DateTimeCodecs._

  implicit val ProformaInvoiceCodecJson: CodecJson[ProformaInvoice] = CodecJson.derive[ProformaInvoice]
  implicit val ProformaInvoiceDecoder: EntityDecoder[ProformaInvoice] = jsonOf[ProformaInvoice]
  implicit val ProformaInvoiceEncoder: EntityEncoder[ProformaInvoice] = jsonEncoderOf[ProformaInvoice]
}
