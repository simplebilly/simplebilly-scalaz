package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ExtraPayment._

case class ExtraPayment (
  amount: String,
employeeId: UUID,
reason: Option[String])

object ExtraPayment {
  import DateTimeCodecs._

  implicit val ExtraPaymentCodecJson: CodecJson[ExtraPayment] = CodecJson.derive[ExtraPayment]
  implicit val ExtraPaymentDecoder: EntityDecoder[ExtraPayment] = jsonOf[ExtraPayment]
  implicit val ExtraPaymentEncoder: EntityEncoder[ExtraPayment] = jsonEncoderOf[ExtraPayment]
}
