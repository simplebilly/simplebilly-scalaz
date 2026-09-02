package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import PostingCategoryUpdate._

case class PostingCategoryUpdate (
  accountNumber: Option[String],
accountNumberSkr03: Option[String],
accountNumberSkr04: Option[String],
accountNumberSkr49: Option[String],
categoryType: Option[PostingCategoryType],
createdAt: Option[OffsetDateTime],
defaultVatRate: Option[Integer],
description: Option[String],
eksCategory: Option[String],
euVatLine: Option[Integer],
inputVatPercentage: Option[String],
isActive: Option[Boolean],
isSystem: Option[Boolean],
name: Option[String],
skrVersion: Option[String],
updatedAt: Option[OffsetDateTime],
userModifiedSkr03: Option[Boolean],
userModifiedSkr04: Option[Boolean])

object PostingCategoryUpdate {
  import DateTimeCodecs._

  implicit val PostingCategoryUpdateCodecJson: CodecJson[PostingCategoryUpdate] = CodecJson.derive[PostingCategoryUpdate]
  implicit val PostingCategoryUpdateDecoder: EntityDecoder[PostingCategoryUpdate] = jsonOf[PostingCategoryUpdate]
  implicit val PostingCategoryUpdateEncoder: EntityEncoder[PostingCategoryUpdate] = jsonEncoderOf[PostingCategoryUpdate]
}
