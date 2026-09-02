package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import StockTransferStatus._

case class StockTransferStatus (
  
object StockTransferStatus {
  import DateTimeCodecs._

  implicit val StockTransferStatusCodecJson: CodecJson[StockTransferStatus] = CodecJson.derive[StockTransferStatus]
  implicit val StockTransferStatusDecoder: EntityDecoder[StockTransferStatus] = jsonOf[StockTransferStatus]
  implicit val StockTransferStatusEncoder: EntityEncoder[StockTransferStatus] = jsonEncoderOf[StockTransferStatus]
}
