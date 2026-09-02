package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ProductCategory._

case class ProductCategory (
  description: Option[String],
name: String,
/* References the category entity. */
  parentCategoryId: Option[String],
sortOrder: Integer)

object ProductCategory {
  import DateTimeCodecs._

  implicit val ProductCategoryCodecJson: CodecJson[ProductCategory] = CodecJson.derive[ProductCategory]
  implicit val ProductCategoryDecoder: EntityDecoder[ProductCategory] = jsonOf[ProductCategory]
  implicit val ProductCategoryEncoder: EntityEncoder[ProductCategory] = jsonEncoderOf[ProductCategory]
}
