package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import StockUpdateRequest._

case class StockUpdateRequest (
  quantity: Long)

object StockUpdateRequest {
  import DateTimeCodecs._

  implicit val StockUpdateRequestCodecJson: CodecJson[StockUpdateRequest] = CodecJson.derive[StockUpdateRequest]
  implicit val StockUpdateRequestDecoder: EntityDecoder[StockUpdateRequest] = jsonOf[StockUpdateRequest]
  implicit val StockUpdateRequestEncoder: EntityEncoder[StockUpdateRequest] = jsonEncoderOf[StockUpdateRequest]
}
