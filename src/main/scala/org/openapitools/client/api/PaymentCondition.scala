package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PaymentCondition._

case class PaymentCondition (
  discountDays: Integer,
discountPercentage: Double,
id: String,
name: String,
paymentTermDays: Integer)

object PaymentCondition {
  import DateTimeCodecs._

  implicit val PaymentConditionCodecJson: CodecJson[PaymentCondition] = CodecJson.derive[PaymentCondition]
  implicit val PaymentConditionDecoder: EntityDecoder[PaymentCondition] = jsonOf[PaymentCondition]
  implicit val PaymentConditionEncoder: EntityEncoder[PaymentCondition] = jsonEncoderOf[PaymentCondition]
}
