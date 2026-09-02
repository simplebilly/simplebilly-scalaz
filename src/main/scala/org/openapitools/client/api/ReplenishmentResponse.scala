package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import ReplenishmentResponse._

case class ReplenishmentResponse (
  generatedAt: OffsetDateTime,
lines: List[ReplenishmentSuggestionLine],
targetWarehouseId: String,
totalSuggestedQuantity: Long)

object ReplenishmentResponse {
  import DateTimeCodecs._

  implicit val ReplenishmentResponseCodecJson: CodecJson[ReplenishmentResponse] = CodecJson.derive[ReplenishmentResponse]
  implicit val ReplenishmentResponseDecoder: EntityDecoder[ReplenishmentResponse] = jsonOf[ReplenishmentResponse]
  implicit val ReplenishmentResponseEncoder: EntityEncoder[ReplenishmentResponse] = jsonEncoderOf[ReplenishmentResponse]
}
