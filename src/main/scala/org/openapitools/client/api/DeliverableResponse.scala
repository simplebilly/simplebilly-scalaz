package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import DeliverableResponse._

case class DeliverableResponse (
  availableStock: Long,
deliverableQuantity: Long,
maxSellable: Option[Long],
productId: UUID,
reservedStock: Long,
warehouseId: Option[String])

object DeliverableResponse {
  import DateTimeCodecs._

  implicit val DeliverableResponseCodecJson: CodecJson[DeliverableResponse] = CodecJson.derive[DeliverableResponse]
  implicit val DeliverableResponseDecoder: EntityDecoder[DeliverableResponse] = jsonOf[DeliverableResponse]
  implicit val DeliverableResponseEncoder: EntityEncoder[DeliverableResponse] = jsonEncoderOf[DeliverableResponse]
}
