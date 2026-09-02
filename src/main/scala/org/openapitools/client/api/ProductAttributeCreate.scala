package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ProductAttributeCreate._

case class ProductAttributeCreate (
  /* Whether this attribute participates in the shop's faceted filters. */
  isFilterable: Option[Boolean],
/* Attribute name, e.g. `Material`, `Farbe`, `Gewicht`. */
  name: String,
/* Ordering position within the product's attribute list. */
  position: Option[Integer],
/* The product this attribute belongs to. References the product entity. */
  productId: UUID,
/* Optional unit of measure for numeric attributes, e.g. `g`, `cm`. */
  unit: Option[String],
/* Attribute value, e.g. `Baumwolle`, `Rot`, `180g`. */
  value: String)

object ProductAttributeCreate {
  import DateTimeCodecs._

  implicit val ProductAttributeCreateCodecJson: CodecJson[ProductAttributeCreate] = CodecJson.derive[ProductAttributeCreate]
  implicit val ProductAttributeCreateDecoder: EntityDecoder[ProductAttributeCreate] = jsonOf[ProductAttributeCreate]
  implicit val ProductAttributeCreateEncoder: EntityEncoder[ProductAttributeCreate] = jsonEncoderOf[ProductAttributeCreate]
}
