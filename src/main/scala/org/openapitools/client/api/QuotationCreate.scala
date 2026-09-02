package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import QuotationCreate._

case class QuotationCreate (
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
taxCondition: Option[String],
title: Option[String],
voucherDate: LocalDate,
voucherStatus: VoucherStatus)

object QuotationCreate {
  import DateTimeCodecs._

  implicit val QuotationCreateCodecJson: CodecJson[QuotationCreate] = CodecJson.derive[QuotationCreate]
  implicit val QuotationCreateDecoder: EntityDecoder[QuotationCreate] = jsonOf[QuotationCreate]
  implicit val QuotationCreateEncoder: EntityEncoder[QuotationCreate] = jsonEncoderOf[QuotationCreate]
}
