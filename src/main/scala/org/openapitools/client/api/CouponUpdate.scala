package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import CouponUpdate._

case class CouponUpdate (
  code: Option[String],
description: Option[String],
discountType: Option[DiscountType],
discountValue: Option[String],
expiresAt: Option[OffsetDateTime],
isActive: Option[Boolean],
isCombineable: Option[Boolean],
maxDiscountAmount: Option[String],
maxUses: Option[Integer],
maxUsesPerCustomer: Option[Integer],
minOrderAmount: Option[String],
productIds: Option[AnyType],
startsAt: Option[OffsetDateTime])

object CouponUpdate {
  import DateTimeCodecs._

  implicit val CouponUpdateCodecJson: CodecJson[CouponUpdate] = CodecJson.derive[CouponUpdate]
  implicit val CouponUpdateDecoder: EntityDecoder[CouponUpdate] = jsonOf[CouponUpdate]
  implicit val CouponUpdateEncoder: EntityEncoder[CouponUpdate] = jsonEncoderOf[CouponUpdate]
}
