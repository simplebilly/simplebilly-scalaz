package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MovementType._

case class MovementType (
  
object MovementType {
  import DateTimeCodecs._

  implicit val MovementTypeCodecJson: CodecJson[MovementType] = CodecJson.derive[MovementType]
  implicit val MovementTypeDecoder: EntityDecoder[MovementType] = jsonOf[MovementType]
  implicit val MovementTypeEncoder: EntityEncoder[MovementType] = jsonEncoderOf[MovementType]
}
