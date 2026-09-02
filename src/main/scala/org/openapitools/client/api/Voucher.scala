package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import Voucher._

case class Voucher (
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

object Voucher {
  import DateTimeCodecs._

  implicit val VoucherCodecJson: CodecJson[Voucher] = CodecJson.derive[Voucher]
  implicit val VoucherDecoder: EntityDecoder[Voucher] = jsonOf[Voucher]
  implicit val VoucherEncoder: EntityEncoder[Voucher] = jsonEncoderOf[Voucher]
}
