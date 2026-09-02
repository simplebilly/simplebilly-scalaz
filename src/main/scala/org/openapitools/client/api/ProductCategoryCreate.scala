package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ProductCategoryCreate._

case class ProductCategoryCreate (
  description: Option[String],
name: String,
/* References the category entity. */
  parentCategoryId: Option[String],
sortOrder: Integer)

object ProductCategoryCreate {
  import DateTimeCodecs._

  implicit val ProductCategoryCreateCodecJson: CodecJson[ProductCategoryCreate] = CodecJson.derive[ProductCategoryCreate]
  implicit val ProductCategoryCreateDecoder: EntityDecoder[ProductCategoryCreate] = jsonOf[ProductCategoryCreate]
  implicit val ProductCategoryCreateEncoder: EntityEncoder[ProductCategoryCreate] = jsonEncoderOf[ProductCategoryCreate]
}
