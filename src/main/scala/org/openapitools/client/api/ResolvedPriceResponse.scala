package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ResolvedPriceResponse._

case class ResolvedPriceResponse (
  /* True when no tier matched and the product list price was used. */
  isListPrice: Boolean,
/* Applied tier, if any matched. */
  priceTierId: Option[String],
productId: UUID,
quantity: Long,
unitPrice: String)

object ResolvedPriceResponse {
  import DateTimeCodecs._

  implicit val ResolvedPriceResponseCodecJson: CodecJson[ResolvedPriceResponse] = CodecJson.derive[ResolvedPriceResponse]
  implicit val ResolvedPriceResponseDecoder: EntityDecoder[ResolvedPriceResponse] = jsonOf[ResolvedPriceResponse]
  implicit val ResolvedPriceResponseEncoder: EntityEncoder[ResolvedPriceResponse] = jsonEncoderOf[ResolvedPriceResponse]
}
