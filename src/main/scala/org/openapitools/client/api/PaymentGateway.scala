package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import PaymentGateway._

case class PaymentGateway (
  config: AnyType,
createdAt: OffsetDateTime,
deletedAt: Option[OffsetDateTime],
enabled: Boolean,
gatewayId: String,
gatewayType: GatewayType,
label: String,
tenantId: UUID,
updatedAt: Option[OffsetDateTime])

object PaymentGateway {
  import DateTimeCodecs._

  implicit val PaymentGatewayCodecJson: CodecJson[PaymentGateway] = CodecJson.derive[PaymentGateway]
  implicit val PaymentGatewayDecoder: EntityDecoder[PaymentGateway] = jsonOf[PaymentGateway]
  implicit val PaymentGatewayEncoder: EntityEncoder[PaymentGateway] = jsonEncoderOf[PaymentGateway]
}
