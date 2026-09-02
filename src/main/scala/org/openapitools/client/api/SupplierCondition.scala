package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SupplierCondition._

case class SupplierCondition (
  /* Currency for the minimum order value. */
  currency: String,
/* Incoterms, e.g. \"EXW\", \"DAP\". */
  deliveryTerms: Option[String],
/* Early-payment discount percentage (Skonto), e.g. 2.0. */
  earlyPaymentDiscountPercent: Option[String],
/* Is this the default condition for the supplier? */
  isDefault: Option[Boolean],
/* Minimum order value required for this supplier. */
  minimumOrderValue: Option[String],
notes: Option[String],
/* Number of days within which payment is due. */
  paymentDueDays: Option[Integer],
/* Payment terms, e.g. \"14 Tage, 2% Skonto\". */
  paymentTerms: Option[String],
/* The supplier this condition applies to (`contact_id`). References the supplier entity. */
  supplierContactId: String,
/* The name of the supplier, denormalized for easy listing. */
  supplierName: Option[String],
/* Tiered discounts: JSON array of `{min_quantity, discount_percent}`. */
  volumeDiscountTiers: Option[AnyType])

object SupplierCondition {
  import DateTimeCodecs._

  implicit val SupplierConditionCodecJson: CodecJson[SupplierCondition] = CodecJson.derive[SupplierCondition]
  implicit val SupplierConditionDecoder: EntityDecoder[SupplierCondition] = jsonOf[SupplierCondition]
  implicit val SupplierConditionEncoder: EntityEncoder[SupplierCondition] = jsonEncoderOf[SupplierCondition]
}
