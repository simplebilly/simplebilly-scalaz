package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ProductStock._

case class ProductStock (
  name: String,
productId: UUID,
sku: String,
stockQuantity: Option[Long])

object ProductStock {
  import DateTimeCodecs._

  implicit val ProductStockCodecJson: CodecJson[ProductStock] = CodecJson.derive[ProductStock]
  implicit val ProductStockDecoder: EntityDecoder[ProductStock] = jsonOf[ProductStock]
  implicit val ProductStockEncoder: EntityEncoder[ProductStock] = jsonEncoderOf[ProductStock]
}
