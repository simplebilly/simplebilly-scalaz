package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.time.OffsetDateTime

import ProformaInvoiceUpdate._

case class ProformaInvoiceUpdate (
  convertedAt: Option[OffsetDateTime],
/* Set when the proforma was converted into a real invoice. References the invoice entity. */
  convertedToInvoiceId: Option[String],
currency: Option[CurrencyCode],
/* References the customer entity. */
  customerId: Option[String],
/* Snapshot of the recipient at issue time (address, VAT id, …). */
  customerSnapshot: Option[AnyType],
issueDate: Option[LocalDate],
lineItems: Option[AnyType],
notes: Option[String],
/* Reference to the order/quote this proforma belongs to. */
  orderNumber: Option[String],
/* Optional deadline the real invoice should carry after conversion. */
  paymentDueDate: Option[LocalDate],
/* References the quotation entity. */
  quotationId: Option[String],
/* `draft` | `sent` | `converted`. */
  status: Option[ProformaInvoiceStatus],
subtotal: Option[String],
totalAmount: Option[String],
totalTax: Option[String])

object ProformaInvoiceUpdate {
  import DateTimeCodecs._

  implicit val ProformaInvoiceUpdateCodecJson: CodecJson[ProformaInvoiceUpdate] = CodecJson.derive[ProformaInvoiceUpdate]
  implicit val ProformaInvoiceUpdateDecoder: EntityDecoder[ProformaInvoiceUpdate] = jsonOf[ProformaInvoiceUpdate]
  implicit val ProformaInvoiceUpdateEncoder: EntityEncoder[ProformaInvoiceUpdate] = jsonEncoderOf[ProformaInvoiceUpdate]
}
