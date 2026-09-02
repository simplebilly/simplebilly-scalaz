package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ModelPackage._

case class ModelPackage (
  description: Option[String],
heightCm: Option[Double],
lengthCm: Option[Double],
reference: Option[String],
weightKg: Double,
widthCm: Option[Double])

object ModelPackage {
  import DateTimeCodecs._

  implicit val ModelPackageCodecJson: CodecJson[ModelPackage] = CodecJson.derive[ModelPackage]
  implicit val ModelPackageDecoder: EntityDecoder[ModelPackage] = jsonOf[ModelPackage]
  implicit val ModelPackageEncoder: EntityEncoder[ModelPackage] = jsonEncoderOf[ModelPackage]
}
