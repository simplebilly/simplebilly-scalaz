package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import StockTransferStatusUpdate._

case class StockTransferStatusUpdate (
  status: String)

object StockTransferStatusUpdate {
  import DateTimeCodecs._

  implicit val StockTransferStatusUpdateCodecJson: CodecJson[StockTransferStatusUpdate] = CodecJson.derive[StockTransferStatusUpdate]
  implicit val StockTransferStatusUpdateDecoder: EntityDecoder[StockTransferStatusUpdate] = jsonOf[StockTransferStatusUpdate]
  implicit val StockTransferStatusUpdateEncoder: EntityEncoder[StockTransferStatusUpdate] = jsonEncoderOf[StockTransferStatusUpdate]
}
