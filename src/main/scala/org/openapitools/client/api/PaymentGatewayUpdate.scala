package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import PaymentGatewayUpdate._

case class PaymentGatewayUpdate (
  config: Option[AnyType],
createdAt: Option[OffsetDateTime],
deletedAt: Option[OffsetDateTime],
enabled: Option[Boolean],
gatewayType: Option[GatewayType],
label: Option[String],
updatedAt: Option[OffsetDateTime])

object PaymentGatewayUpdate {
  import DateTimeCodecs._

  implicit val PaymentGatewayUpdateCodecJson: CodecJson[PaymentGatewayUpdate] = CodecJson.derive[PaymentGatewayUpdate]
  implicit val PaymentGatewayUpdateDecoder: EntityDecoder[PaymentGatewayUpdate] = jsonOf[PaymentGatewayUpdate]
  implicit val PaymentGatewayUpdateEncoder: EntityEncoder[PaymentGatewayUpdate] = jsonEncoderOf[PaymentGatewayUpdate]
}
