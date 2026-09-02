package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PaymentMethod._

case class PaymentMethod (
  
object PaymentMethod {
  import DateTimeCodecs._

  implicit val PaymentMethodCodecJson: CodecJson[PaymentMethod] = CodecJson.derive[PaymentMethod]
  implicit val PaymentMethodDecoder: EntityDecoder[PaymentMethod] = jsonOf[PaymentMethod]
  implicit val PaymentMethodEncoder: EntityEncoder[PaymentMethod] = jsonEncoderOf[PaymentMethod]
}
