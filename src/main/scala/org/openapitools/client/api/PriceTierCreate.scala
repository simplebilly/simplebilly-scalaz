package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import PriceTierCreate._

case class PriceTierCreate (
  /* None = tier applies to all customers; otherwise a customer group id. */
  customerGroupId: Option[String],
/* Quantity from which this tier applies (inclusive). */
  minQuantity: Option[Long],
/* References the product entity. */
  productId: UUID,
/* Net unit price once `min_quantity` is reached. */
  unitPrice: String)

object PriceTierCreate {
  import DateTimeCodecs._

  implicit val PriceTierCreateCodecJson: CodecJson[PriceTierCreate] = CodecJson.derive[PriceTierCreate]
  implicit val PriceTierCreateDecoder: EntityDecoder[PriceTierCreate] = jsonOf[PriceTierCreate]
  implicit val PriceTierCreateEncoder: EntityEncoder[PriceTierCreate] = jsonEncoderOf[PriceTierCreate]
}
