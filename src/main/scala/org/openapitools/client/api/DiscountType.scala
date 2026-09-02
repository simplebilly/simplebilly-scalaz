package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DiscountType._

case class DiscountType (
  
object DiscountType {
  import DateTimeCodecs._

  implicit val DiscountTypeCodecJson: CodecJson[DiscountType] = CodecJson.derive[DiscountType]
  implicit val DiscountTypeDecoder: EntityDecoder[DiscountType] = jsonOf[DiscountType]
  implicit val DiscountTypeEncoder: EntityEncoder[DiscountType] = jsonEncoderOf[DiscountType]
}
