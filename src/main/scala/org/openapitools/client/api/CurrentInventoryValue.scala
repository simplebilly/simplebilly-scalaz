package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CurrentInventoryValue._

case class CurrentInventoryValue (
  history: List[InventoryValuePoint],
productCount: Long,
totalPurchaseValue: String,
totalSalesValue: String)

object CurrentInventoryValue {
  import DateTimeCodecs._

  implicit val CurrentInventoryValueCodecJson: CodecJson[CurrentInventoryValue] = CodecJson.derive[CurrentInventoryValue]
  implicit val CurrentInventoryValueDecoder: EntityDecoder[CurrentInventoryValue] = jsonOf[CurrentInventoryValue]
  implicit val CurrentInventoryValueEncoder: EntityEncoder[CurrentInventoryValue] = jsonEncoderOf[CurrentInventoryValue]
}
