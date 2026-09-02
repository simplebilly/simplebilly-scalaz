package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import Payment._

case class Payment (
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

object Payment {
  import DateTimeCodecs._

  implicit val PaymentCodecJson: CodecJson[Payment] = CodecJson.derive[Payment]
  implicit val PaymentDecoder: EntityDecoder[Payment] = jsonOf[Payment]
  implicit val PaymentEncoder: EntityEncoder[Payment] = jsonEncoderOf[Payment]
}
