package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import InventoryCountStatusUpdate._

case class InventoryCountStatusUpdate (
  status: String)

object InventoryCountStatusUpdate {
  import DateTimeCodecs._

  implicit val InventoryCountStatusUpdateCodecJson: CodecJson[InventoryCountStatusUpdate] = CodecJson.derive[InventoryCountStatusUpdate]
  implicit val InventoryCountStatusUpdateDecoder: EntityDecoder[InventoryCountStatusUpdate] = jsonOf[InventoryCountStatusUpdate]
  implicit val InventoryCountStatusUpdateEncoder: EntityEncoder[InventoryCountStatusUpdate] = jsonEncoderOf[InventoryCountStatusUpdate]
}
