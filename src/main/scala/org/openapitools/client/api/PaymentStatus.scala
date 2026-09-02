package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PaymentStatus._

case class PaymentStatus (
  
object PaymentStatus {
  import DateTimeCodecs._

  implicit val PaymentStatusCodecJson: CodecJson[PaymentStatus] = CodecJson.derive[PaymentStatus]
  implicit val PaymentStatusDecoder: EntityDecoder[PaymentStatus] = jsonOf[PaymentStatus]
  implicit val PaymentStatusEncoder: EntityEncoder[PaymentStatus] = jsonEncoderOf[PaymentStatus]
}
