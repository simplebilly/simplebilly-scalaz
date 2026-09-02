package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import OrderStateUpdate._

case class OrderStateUpdate (
  sendStateToShop: Option[Boolean],
state: String)

object OrderStateUpdate {
  import DateTimeCodecs._

  implicit val OrderStateUpdateCodecJson: CodecJson[OrderStateUpdate] = CodecJson.derive[OrderStateUpdate]
  implicit val OrderStateUpdateDecoder: EntityDecoder[OrderStateUpdate] = jsonOf[OrderStateUpdate]
  implicit val OrderStateUpdateEncoder: EntityEncoder[OrderStateUpdate] = jsonEncoderOf[OrderStateUpdate]
}
