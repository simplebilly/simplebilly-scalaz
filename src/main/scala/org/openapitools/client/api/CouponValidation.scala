package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import CouponValidation._

case class CouponValidation (
  code: String,
discountType: String,
discountValue: String,
discountedAmount: String,
maxDiscountAmount: Option[String],
reason: Option[String],
valid: Boolean)

object CouponValidation {
  import DateTimeCodecs._

  implicit val CouponValidationCodecJson: CodecJson[CouponValidation] = CodecJson.derive[CouponValidation]
  implicit val CouponValidationDecoder: EntityDecoder[CouponValidation] = jsonOf[CouponValidation]
  implicit val CouponValidationEncoder: EntityEncoder[CouponValidation] = jsonEncoderOf[CouponValidation]
}
