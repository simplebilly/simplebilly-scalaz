package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ReplenishmentSuggestionLine._

case class ReplenishmentSuggestionLine (
  /* Current stock in the target warehouse. */
  currentStock: Long,
maxStock: Option[Long],
minStock: Option[Long],
productId: UUID,
productName: String,
sku: String,
/* Surplus available in the source warehouse (above its target). */
  sourceAvailable: Long,
sourceWarehouseId: String,
suggestedQuantity: Long,
targetWarehouseId: String)

object ReplenishmentSuggestionLine {
  import DateTimeCodecs._

  implicit val ReplenishmentSuggestionLineCodecJson: CodecJson[ReplenishmentSuggestionLine] = CodecJson.derive[ReplenishmentSuggestionLine]
  implicit val ReplenishmentSuggestionLineDecoder: EntityDecoder[ReplenishmentSuggestionLine] = jsonOf[ReplenishmentSuggestionLine]
  implicit val ReplenishmentSuggestionLineEncoder: EntityEncoder[ReplenishmentSuggestionLine] = jsonEncoderOf[ReplenishmentSuggestionLine]
}
