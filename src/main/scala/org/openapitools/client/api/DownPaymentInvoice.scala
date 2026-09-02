package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import DownPaymentInvoice._

case class DownPaymentInvoice (
  contactId: Option[String],
contactName: Option[String],
createdAt: String,
currency: String,
id: String,
notes: Option[String],
paidAmount: String,
totalAmount: String,
voucherDate: LocalDate,
voucherNumber: Option[String],
voucherStatus: String)

object DownPaymentInvoice {
  import DateTimeCodecs._

  implicit val DownPaymentInvoiceCodecJson: CodecJson[DownPaymentInvoice] = CodecJson.derive[DownPaymentInvoice]
  implicit val DownPaymentInvoiceDecoder: EntityDecoder[DownPaymentInvoice] = jsonOf[DownPaymentInvoice]
  implicit val DownPaymentInvoiceEncoder: EntityEncoder[DownPaymentInvoice] = jsonEncoderOf[DownPaymentInvoice]
}
