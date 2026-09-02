package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import Coupon._

case class Coupon (
  code: String,
description: Option[String],
discountType: DiscountType,
discountValue: String,
expiresAt: Option[OffsetDateTime],
isActive: Option[Boolean],
isCombineable: Option[Boolean],
maxDiscountAmount: Option[String],
maxUses: Option[Integer],
maxUsesPerCustomer: Option[Integer],
minOrderAmount: Option[String],
productIds: Option[AnyType],
startsAt: Option[OffsetDateTime])

object Coupon {
  import DateTimeCodecs._

  implicit val CouponCodecJson: CodecJson[Coupon] = CodecJson.derive[Coupon]
  implicit val CouponDecoder: EntityDecoder[Coupon] = jsonOf[Coupon]
  implicit val CouponEncoder: EntityEncoder[Coupon] = jsonEncoderOf[Coupon]
}
