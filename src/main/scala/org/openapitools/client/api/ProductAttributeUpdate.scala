package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ProductAttributeUpdate._

case class ProductAttributeUpdate (
  /* Whether this attribute participates in the shop's faceted filters. */
  isFilterable: Option[Boolean],
/* Attribute name, e.g. `Material`, `Farbe`, `Gewicht`. */
  name: Option[String],
/* Ordering position within the product's attribute list. */
  position: Option[Integer],
/* The product this attribute belongs to. References the product entity. */
  productId: Option[UUID],
/* Optional unit of measure for numeric attributes, e.g. `g`, `cm`. */
  unit: Option[String],
/* Attribute value, e.g. `Baumwolle`, `Rot`, `180g`. */
  value: Option[String])

object ProductAttributeUpdate {
  import DateTimeCodecs._

  implicit val ProductAttributeUpdateCodecJson: CodecJson[ProductAttributeUpdate] = CodecJson.derive[ProductAttributeUpdate]
  implicit val ProductAttributeUpdateDecoder: EntityDecoder[ProductAttributeUpdate] = jsonOf[ProductAttributeUpdate]
  implicit val ProductAttributeUpdateEncoder: EntityEncoder[ProductAttributeUpdate] = jsonEncoderOf[ProductAttributeUpdate]
}
