package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ProductCategoryUpdate._

case class ProductCategoryUpdate (
  description: Option[String],
name: Option[String],
/* References the category entity. */
  parentCategoryId: Option[String],
sortOrder: Option[Integer])

object ProductCategoryUpdate {
  import DateTimeCodecs._

  implicit val ProductCategoryUpdateCodecJson: CodecJson[ProductCategoryUpdate] = CodecJson.derive[ProductCategoryUpdate]
  implicit val ProductCategoryUpdateDecoder: EntityDecoder[ProductCategoryUpdate] = jsonOf[ProductCategoryUpdate]
  implicit val ProductCategoryUpdateEncoder: EntityEncoder[ProductCategoryUpdate] = jsonEncoderOf[ProductCategoryUpdate]
}
