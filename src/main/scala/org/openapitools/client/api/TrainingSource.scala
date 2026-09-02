package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import TrainingSource._

case class TrainingSource (
  
object TrainingSource {
  import DateTimeCodecs._

  implicit val TrainingSourceCodecJson: CodecJson[TrainingSource] = CodecJson.derive[TrainingSource]
  implicit val TrainingSourceDecoder: EntityDecoder[TrainingSource] = jsonOf[TrainingSource]
  implicit val TrainingSourceEncoder: EntityEncoder[TrainingSource] = jsonEncoderOf[TrainingSource]
}
