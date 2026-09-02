package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ProductVariantUpdate._

case class ProductVariantUpdate (
  barcode: Option[String],
imageLink: Option[String],
isActive: Option[Boolean],
/* Human-readable variant label, e.g. \"Red / M\". */
  name: Option[String],
/* Option name → value map, e.g. `{\"Color\": \"Red\", \"Size\": \"M\"}`. */
  optionValues: Option[AnyType],
/* Explicit override price for this variant (takes precedence over parent price + delta). */
  price: Option[String],
/* Price adjustment relative to the parent product's `default_price`. */
  priceDelta: Option[String],
/* The parent product this variant belongs to. References the product entity. */
  productId: Option[UUID],
/* Variant-specific SKU (must be unique per tenant). */
  sku: Option[String],
/* Variant-level stock (optional — may be tracked on the parent only). */
  stockQuantity: Option[Long])

object ProductVariantUpdate {
  import DateTimeCodecs._

  implicit val ProductVariantUpdateCodecJson: CodecJson[ProductVariantUpdate] = CodecJson.derive[ProductVariantUpdate]
  implicit val ProductVariantUpdateDecoder: EntityDecoder[ProductVariantUpdate] = jsonOf[ProductVariantUpdate]
  implicit val ProductVariantUpdateEncoder: EntityEncoder[ProductVariantUpdate] = jsonEncoderOf[ProductVariantUpdate]
}
