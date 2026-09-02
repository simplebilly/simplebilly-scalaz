package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DeclarationType._

case class DeclarationType (
  
object DeclarationType {
  import DateTimeCodecs._

  implicit val DeclarationTypeCodecJson: CodecJson[DeclarationType] = CodecJson.derive[DeclarationType]
  implicit val DeclarationTypeDecoder: EntityDecoder[DeclarationType] = jsonOf[DeclarationType]
  implicit val DeclarationTypeEncoder: EntityEncoder[DeclarationType] = jsonEncoderOf[DeclarationType]
}
