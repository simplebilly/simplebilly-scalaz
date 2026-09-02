package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PostingCategory._

case class PostingCategory (
  accountNumber: Option[String],
accountNumberSkr03: Option[String],
accountNumberSkr04: Option[String],
accountNumberSkr49: Option[String],
categoryId: String,
defaultVatRate: Integer,
description: Option[String],
eksCategory: Option[String],
isActive: Boolean,
isSystem: Boolean,
name: String,
skrVersion: String,
`type`: String)

object PostingCategory {
  import DateTimeCodecs._

  implicit val PostingCategoryCodecJson: CodecJson[PostingCategory] = CodecJson.derive[PostingCategory]
  implicit val PostingCategoryDecoder: EntityDecoder[PostingCategory] = jsonOf[PostingCategory]
  implicit val PostingCategoryEncoder: EntityEncoder[PostingCategory] = jsonEncoderOf[PostingCategory]
}
