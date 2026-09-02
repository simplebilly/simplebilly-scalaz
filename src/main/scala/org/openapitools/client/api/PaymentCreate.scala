package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import PaymentCreate._

case class PaymentCreate (
  amount: Option[String],
attachment: Option[AnyType],
currency: Option[String],
/* References the customer entity. */
  customerId: Option[String],
description: Option[String],
metadata: Option[AnyType],
method: Option[PaymentMethod],
paymentDate: Option[OffsetDateTime],
reference: Option[String])

object PaymentCreate {
  import DateTimeCodecs._

  implicit val PaymentCreateCodecJson: CodecJson[PaymentCreate] = CodecJson.derive[PaymentCreate]
  implicit val PaymentCreateDecoder: EntityDecoder[PaymentCreate] = jsonOf[PaymentCreate]
  implicit val PaymentCreateEncoder: EntityEncoder[PaymentCreate] = jsonEncoderOf[PaymentCreate]
}
