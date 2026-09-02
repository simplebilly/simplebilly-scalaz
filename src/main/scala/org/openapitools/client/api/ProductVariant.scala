package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ProductVariant._

case class ProductVariant (
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
  productId: UUID,
/* Variant-specific SKU (must be unique per tenant). */
  sku: String,
/* Variant-level stock (optional — may be tracked on the parent only). */
  stockQuantity: Option[Long])

object ProductVariant {
  import DateTimeCodecs._

  implicit val ProductVariantCodecJson: CodecJson[ProductVariant] = CodecJson.derive[ProductVariant]
  implicit val ProductVariantDecoder: EntityDecoder[ProductVariant] = jsonOf[ProductVariant]
  implicit val ProductVariantEncoder: EntityEncoder[ProductVariant] = jsonEncoderOf[ProductVariant]
}
