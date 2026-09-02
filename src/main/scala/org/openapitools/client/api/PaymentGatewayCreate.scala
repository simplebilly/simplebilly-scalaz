package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import PaymentGatewayCreate._

case class PaymentGatewayCreate (
  config: AnyType,
createdAt: OffsetDateTime,
deletedAt: Option[OffsetDateTime],
enabled: Boolean,
gatewayType: GatewayType,
label: String,
updatedAt: Option[OffsetDateTime])

object PaymentGatewayCreate {
  import DateTimeCodecs._

  implicit val PaymentGatewayCreateCodecJson: CodecJson[PaymentGatewayCreate] = CodecJson.derive[PaymentGatewayCreate]
  implicit val PaymentGatewayCreateDecoder: EntityDecoder[PaymentGatewayCreate] = jsonOf[PaymentGatewayCreate]
  implicit val PaymentGatewayCreateEncoder: EntityEncoder[PaymentGatewayCreate] = jsonEncoderOf[PaymentGatewayCreate]
}
