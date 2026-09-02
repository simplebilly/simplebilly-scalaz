package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import PostingCategoryCreate._

case class PostingCategoryCreate (
  accountNumber: Option[String],
accountNumberSkr03: Option[String],
accountNumberSkr04: Option[String],
accountNumberSkr49: Option[String],
categoryType: PostingCategoryType,
createdAt: OffsetDateTime,
defaultVatRate: Integer,
description: Option[String],
eksCategory: Option[String],
euVatLine: Option[Integer],
inputVatPercentage: String,
isActive: Boolean,
isSystem: Boolean,
name: String,
skrVersion: String,
updatedAt: Option[OffsetDateTime],
userModifiedSkr03: Boolean,
userModifiedSkr04: Boolean)

object PostingCategoryCreate {
  import DateTimeCodecs._

  implicit val PostingCategoryCreateCodecJson: CodecJson[PostingCategoryCreate] = CodecJson.derive[PostingCategoryCreate]
  implicit val PostingCategoryCreateDecoder: EntityDecoder[PostingCategoryCreate] = jsonOf[PostingCategoryCreate]
  implicit val PostingCategoryCreateEncoder: EntityEncoder[PostingCategoryCreate] = jsonEncoderOf[PostingCategoryCreate]
}
