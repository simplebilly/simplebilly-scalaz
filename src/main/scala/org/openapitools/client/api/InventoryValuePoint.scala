package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import InventoryValuePoint._

case class InventoryValuePoint (
  productCount: Long,
recordedAt: OffsetDateTime,
totalPurchaseValue: String,
totalSalesValue: String)

object InventoryValuePoint {
  import DateTimeCodecs._

  implicit val InventoryValuePointCodecJson: CodecJson[InventoryValuePoint] = CodecJson.derive[InventoryValuePoint]
  implicit val InventoryValuePointDecoder: EntityDecoder[InventoryValuePoint] = jsonOf[InventoryValuePoint]
  implicit val InventoryValuePointEncoder: EntityEncoder[InventoryValuePoint] = jsonEncoderOf[InventoryValuePoint]
}
