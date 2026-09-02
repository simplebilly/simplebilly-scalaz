package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import InventoryCountStatus._

case class InventoryCountStatus (
  
object InventoryCountStatus {
  import DateTimeCodecs._

  implicit val InventoryCountStatusCodecJson: CodecJson[InventoryCountStatus] = CodecJson.derive[InventoryCountStatus]
  implicit val InventoryCountStatusDecoder: EntityDecoder[InventoryCountStatus] = jsonOf[InventoryCountStatus]
  implicit val InventoryCountStatusEncoder: EntityEncoder[InventoryCountStatus] = jsonEncoderOf[InventoryCountStatus]
}
