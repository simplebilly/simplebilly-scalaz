package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.time.OffsetDateTime
import java.util.UUID

import Invoice._

case class Invoice (
  attachments: Option[AnyType],
billingPeriodEnd: Option[LocalDate],
billingPeriodStart: Option[LocalDate],
cancellationDate: Option[LocalDate],
/* References the invoice entity. */
  cancellationInvoiceId: Option[String],
cancellationReason: Option[String],
/* References the contract entity. */
  contractId: Option[UUID],
currency: CurrencyCode,
/* References the customer entity. */
  customerId: Option[String],
discountAmount: Option[String],
discountDays: Option[Integer],
discountPercentage: Option[String],
documentType: Option[DocumentType],
dunningLevel: Option[Integer],
inputVatAmount: Option[String],
inputVatDeductible: Option[Boolean],
inputVatPercentage: Option[String],
introductionText: Option[String],
invoiceType: InvoiceType,
isCancelled: Option[Boolean],
isDraft: Option[Boolean],
isEuAcquisition: Option[Boolean],
isEuDelivery: Option[Boolean],
isIntraCommunityAcquisition: Option[Boolean],
isReverseCharge: Option[Boolean],
issueDate: LocalDate,
ledgerAccount: Option[String],
lineItems: AnyType,
margin25a: Option[Boolean],
margin25aGross: Option[String],
margin25aPurchasePrice: Option[String],
notes: Option[String],
orderNumber: Option[String],
originalPdfPath: Option[String],
paidAmount: Option[String],
paymentDueDate: Option[LocalDate],
paymentStatus: Option[PaymentStatus],
paymentTermsText: Option[String],
/* References the preceding sales voucher entity. */
  precedingSalesVoucherId: Option[String],
precedingSalesVoucherType: Option[PrecedingSalesVoucherType],
receiptConfirmationAvailable: Option[Boolean],
/* References the invoice entity. */
  relatedInvoiceId: Option[UUID],
relationshipType: Option[String],
senderSnapshot: Option[AnyType],
sentAt: Option[OffsetDateTime],
servicePeriodEnd: Option[LocalDate],
servicePeriodStart: Option[LocalDate],
status: InvoiceStatus,
subtotal: String,
/* References the supplier entity. */
  supplierId: Option[String],
taxExemptionReason: Option[String],
totalAmount: String,
totalTax: String,
vatCountry: Option[CountryCode],
vatSpecialCase: Option[String])

object Invoice {
  import DateTimeCodecs._

  implicit val InvoiceCodecJson: CodecJson[Invoice] = CodecJson.derive[Invoice]
  implicit val InvoiceDecoder: EntityDecoder[Invoice] = jsonOf[Invoice]
  implicit val InvoiceEncoder: EntityEncoder[Invoice] = jsonEncoderOf[Invoice]
}
