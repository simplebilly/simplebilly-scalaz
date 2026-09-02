package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import OrderConfirmationCreate._

case class OrderConfirmationCreate (
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
taxCondition: Option[String],
title: Option[String],
voucherDate: LocalDate,
voucherStatus: VoucherStatus)

object OrderConfirmationCreate {
  import DateTimeCodecs._

  implicit val OrderConfirmationCreateCodecJson: CodecJson[OrderConfirmationCreate] = CodecJson.derive[OrderConfirmationCreate]
  implicit val OrderConfirmationCreateDecoder: EntityDecoder[OrderConfirmationCreate] = jsonOf[OrderConfirmationCreate]
  implicit val OrderConfirmationCreateEncoder: EntityEncoder[OrderConfirmationCreate] = jsonEncoderOf[OrderConfirmationCreate]
}
