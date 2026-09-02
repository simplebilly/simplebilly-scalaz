package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import Quotation._

case class Quotation (
  address: Option[AnyType],
/* References the contact entity. */
  contactId: Option[String],
contactName: Option[String],
currency: String,
expirationDate: Option[LocalDate],
files: Option[AnyType],
introduction: Option[String],
lineItems: Option[AnyType],
/* References the preceding sales voucher entity. */
  precedingSalesVoucherId: Option[String],
precedingSalesVoucherType: Option[PrecedingSalesVoucherType],
quotationNumber: Option[String],
remark: Option[String],
subtotal: Option[String],
taxCondition: Option[String],
title: Option[String],
totalAmount: Option[String],
totalTax: Option[String],
voucherDate: LocalDate,
voucherStatus: VoucherStatus)

object Quotation {
  import DateTimeCodecs._

  implicit val QuotationCodecJson: CodecJson[Quotation] = CodecJson.derive[Quotation]
  implicit val QuotationDecoder: EntityDecoder[Quotation] = jsonOf[Quotation]
  implicit val QuotationEncoder: EntityEncoder[Quotation] = jsonEncoderOf[Quotation]
}
