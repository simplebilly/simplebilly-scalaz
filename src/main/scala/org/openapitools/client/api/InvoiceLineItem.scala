package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import InvoiceLineItem._

case class InvoiceLineItem (
  articleNumber: Option[String],
description: String,
discountAmount: Option[String],
discountPercentage: Option[String],
inputVatDeductible: Option[Boolean],
inputVatRate: Option[String],
isIntraCommunityAcquisition: Option[Boolean],
isMargin25a: Option[Boolean],
ledgerAccount: Option[String],
lineTotal: String,
lineTotalGross: Option[String],
margin25aPurchasePrice: Option[String],
meterPointId: Option[UUID],
position: Long,
priceComponents: Option[AnyType],
productId: Option[UUID],
productSku: Option[String],
quantity: String,
supplierArticleNumber: Option[String],
taxRate: Option[String],
unit: AnyType,
unitPrice: String,
usageDataId: Option[UUID],
vatRateNominal: Option[String],
vatSpecialCase: Option[String])

object InvoiceLineItem {
  import DateTimeCodecs._

  implicit val InvoiceLineItemCodecJson: CodecJson[InvoiceLineItem] = CodecJson.derive[InvoiceLineItem]
  implicit val InvoiceLineItemDecoder: EntityDecoder[InvoiceLineItem] = jsonOf[InvoiceLineItem]
  implicit val InvoiceLineItemEncoder: EntityEncoder[InvoiceLineItem] = jsonEncoderOf[InvoiceLineItem]
}
