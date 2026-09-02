package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ShippingRule._

case class ShippingRule (
  /* Provider that auto-filled this rule (e.g. \"ups\"), if any. */
  carrier: Option[String],
/* None = applies to all countries. */
  country: Option[CountryCode],
/* Delivery time text, e.g. \"1-3\". */
  deliveryTime: Option[String],
isActive: Option[Boolean],
maxWeightKg: Option[Double],
minWeightKg: Option[Double],
/* Delivery-method label, e.g. \"Standardversand\". */
  name: String,
notes: Option[String],
/* Shipping cost in the shop's currency. */
  price: String,
/* Lower wins when multiple rules match. */
  priority: Option[Integer])

object ShippingRule {
  import DateTimeCodecs._

  implicit val ShippingRuleCodecJson: CodecJson[ShippingRule] = CodecJson.derive[ShippingRule]
  implicit val ShippingRuleDecoder: EntityDecoder[ShippingRule] = jsonOf[ShippingRule]
  implicit val ShippingRuleEncoder: EntityEncoder[ShippingRule] = jsonEncoderOf[ShippingRule]
}
