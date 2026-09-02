package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import AbsenceType._

case class AbsenceType (
  
object AbsenceType {
  import DateTimeCodecs._

  implicit val AbsenceTypeCodecJson: CodecJson[AbsenceType] = CodecJson.derive[AbsenceType]
  implicit val AbsenceTypeDecoder: EntityDecoder[AbsenceType] = jsonOf[AbsenceType]
  implicit val AbsenceTypeEncoder: EntityEncoder[AbsenceType] = jsonEncoderOf[AbsenceType]
}
