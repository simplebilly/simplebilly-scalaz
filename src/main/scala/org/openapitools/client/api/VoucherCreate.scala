package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import VoucherCreate._

case class VoucherCreate (
  categoryId: Option[String],
/* References the contact entity. */
  contactId: Option[String],
contactName: Option[String],
currency: String,
description: Option[String],
fileAttachments: Option[AnyType],
lineItems: Option[AnyType],
metadata: Option[AnyType],
notes: Option[String],
openAmount: Option[String],
paidDate: Option[LocalDate],
paymentStatus: Option[PaymentStatus],
taxAmounts: Option[AnyType],
taxCondition: Option[String],
totalGrossAmount: Option[String],
totalNetAmount: Option[String],
voucherDate: LocalDate,
voucherNumber: Option[String],
voucherStatus: VoucherStatus,
voucherType: VoucherType)

object VoucherCreate {
  import DateTimeCodecs._

  implicit val VoucherCreateCodecJson: CodecJson[VoucherCreate] = CodecJson.derive[VoucherCreate]
  implicit val VoucherCreateDecoder: EntityDecoder[VoucherCreate] = jsonOf[VoucherCreate]
  implicit val VoucherCreateEncoder: EntityEncoder[VoucherCreate] = jsonEncoderOf[VoucherCreate]
}
