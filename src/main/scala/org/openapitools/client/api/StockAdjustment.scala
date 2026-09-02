package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate
import java.util.UUID

import StockAdjustment._

case class StockAdjustment (
  batchNumber: Option[String],
binLocation: Option[String],
expiryDate: Option[LocalDate],
productId: Option[UUID],
quantity: Long,
serialNumbers: Option[List[String]])

object StockAdjustment {
  import DateTimeCodecs._

  implicit val StockAdjustmentCodecJson: CodecJson[StockAdjustment] = CodecJson.derive[StockAdjustment]
  implicit val StockAdjustmentDecoder: EntityDecoder[StockAdjustment] = jsonOf[StockAdjustment]
  implicit val StockAdjustmentEncoder: EntityEncoder[StockAdjustment] = jsonEncoderOf[StockAdjustment]
}
