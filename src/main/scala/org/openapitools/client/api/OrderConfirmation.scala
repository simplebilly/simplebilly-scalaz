package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import OrderConfirmation._

case class OrderConfirmation (
  address: Option[AnyType],
confirmationNumber: Option[String],
/* References the contact entity. */
  contactId: Option[String],
contactName: Option[String],
currency: String,
files: Option[AnyType],
introduction: Option[String],
lineItems: Option[AnyType],
/* References the preceding sales voucher entity. */
  precedingSalesVoucherId: Option[String],
precedingSalesVoucherType: Option[PrecedingSalesVoucherType],
remark: Option[String],
subtotal: Option[String],
taxCondition: Option[String],
title: Option[String],
totalAmount: Option[String],
totalTax: Option[String],
voucherDate: LocalDate,
voucherStatus: VoucherStatus)

object OrderConfirmation {
  import DateTimeCodecs._

  implicit val OrderConfirmationCodecJson: CodecJson[OrderConfirmation] = CodecJson.derive[OrderConfirmation]
  implicit val OrderConfirmationDecoder: EntityDecoder[OrderConfirmation] = jsonOf[OrderConfirmation]
  implicit val OrderConfirmationEncoder: EntityEncoder[OrderConfirmation] = jsonEncoderOf[OrderConfirmation]
}
