package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import AbsenceStatus._

case class AbsenceStatus (
  
object AbsenceStatus {
  import DateTimeCodecs._

  implicit val AbsenceStatusCodecJson: CodecJson[AbsenceStatus] = CodecJson.derive[AbsenceStatus]
  implicit val AbsenceStatusDecoder: EntityDecoder[AbsenceStatus] = jsonOf[AbsenceStatus]
  implicit val AbsenceStatusEncoder: EntityEncoder[AbsenceStatus] = jsonEncoderOf[AbsenceStatus]
}
