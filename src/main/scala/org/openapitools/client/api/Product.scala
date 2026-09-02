package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import Product._

case class Product (
  availability: Option[String],
barcode: Option[String],
brand: Option[String],
categoryId: Option[String],
condition: Option[String],
defaultLedgerAccount: Option[String],
defaultPrice: Option[String],
/* References the price formula entity. */
  defaultPriceFormulaId: Option[UUID],
defaultTaxRate: Option[String],
description: Option[String],
gtin: Option[String],
height: Option[String],
imageLink: Option[String],
images: Option[AnyType],
isTaxable: Option[Boolean],
length: Option[String],
link: Option[String],
/* Target stock level used by reorder proposals. */
  maxStock: Option[Long],
/* Reorder point — when stock falls below this, a reorder is suggested. */
  minStock: Option[Long],
mpn: Option[String],
name: String,
packageHeight: Option[String],
packageLength: Option[String],
packageWeightUnit: Option[String],
packageWeightValue: Option[String],
packageWidth: Option[String],
productCode: String,
productType: Option[String],
purchasePrice: Option[String],
/* Suggested purchase quantity when a reorder proposal is created. */
  reorderQuantity: Option[Long],
salePrice: Option[String],
shippingPrice: Option[String],
shippingRequiresInsurance: Option[Boolean],
sku: String,
stockQuantity: Option[Long],
tags: Option[AnyType],
taxPrice: Option[String],
/* Whether this product requires batch (Chargennummer) tracking. */
  trackBatch: Option[Boolean],
/* Whether this product requires serial-number tracking. */
  trackSerial: Option[Boolean],
unit: Option[AnyType],
weightUnit: Option[String],
weightValue: Option[String],
width: Option[String])

object Product {
  import DateTimeCodecs._

  implicit val ProductCodecJson: CodecJson[Product] = CodecJson.derive[Product]
  implicit val ProductDecoder: EntityDecoder[Product] = jsonOf[Product]
  implicit val ProductEncoder: EntityEncoder[Product] = jsonEncoderOf[Product]
}
