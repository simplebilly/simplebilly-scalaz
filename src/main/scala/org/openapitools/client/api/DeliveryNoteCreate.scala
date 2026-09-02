package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import DeliveryNoteCreate._

case class DeliveryNoteCreate (
  address: Option[AnyType],
/* References the contact entity. */
  contactId: Option[String],
contactName: Option[String],
currency: String,
deliveryDate: Option[LocalDate],
deliveryNoteNumber: Option[String],
files: Option[AnyType],
introduction: Option[String],
lineItems: Option[AnyType],
/* References the preceding sales voucher entity. */
  precedingSalesVoucherId: Option[String],
precedingSalesVoucherType: Option[PrecedingSalesVoucherType],
remark: Option[String],
shippingDate: Option[LocalDate],
shippingMethod: Option[String],
title: Option[String],
voucherDate: LocalDate,
voucherStatus: VoucherStatus)

object DeliveryNoteCreate {
  import DateTimeCodecs._

  implicit val DeliveryNoteCreateCodecJson: CodecJson[DeliveryNoteCreate] = CodecJson.derive[DeliveryNoteCreate]
  implicit val DeliveryNoteCreateDecoder: EntityDecoder[DeliveryNoteCreate] = jsonOf[DeliveryNoteCreate]
  implicit val DeliveryNoteCreateEncoder: EntityEncoder[DeliveryNoteCreate] = jsonEncoderOf[DeliveryNoteCreate]
}
