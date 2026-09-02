package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PostingCategoryType._

case class PostingCategoryType (
  
object PostingCategoryType {
  import DateTimeCodecs._

  implicit val PostingCategoryTypeCodecJson: CodecJson[PostingCategoryType] = CodecJson.derive[PostingCategoryType]
  implicit val PostingCategoryTypeDecoder: EntityDecoder[PostingCategoryType] = jsonOf[PostingCategoryType]
  implicit val PostingCategoryTypeEncoder: EntityEncoder[PostingCategoryType] = jsonEncoderOf[PostingCategoryType]
}
