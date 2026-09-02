package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SepaSequenceType._

case class SepaSequenceType (
  
object SepaSequenceType {
  import DateTimeCodecs._

  implicit val SepaSequenceTypeCodecJson: CodecJson[SepaSequenceType] = CodecJson.derive[SepaSequenceType]
  implicit val SepaSequenceTypeDecoder: EntityDecoder[SepaSequenceType] = jsonOf[SepaSequenceType]
  implicit val SepaSequenceTypeEncoder: EntityEncoder[SepaSequenceType] = jsonEncoderOf[SepaSequenceType]
}
