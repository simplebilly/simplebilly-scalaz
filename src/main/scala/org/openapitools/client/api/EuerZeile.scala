package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EuerZeile._

case class EuerZeile (
  abschnitt: String,
betrag: String,
bezeichnung: String,
zeile: Integer)

object EuerZeile {
  import DateTimeCodecs._

  implicit val EuerZeileCodecJson: CodecJson[EuerZeile] = CodecJson.derive[EuerZeile]
  implicit val EuerZeileDecoder: EntityDecoder[EuerZeile] = jsonOf[EuerZeile]
  implicit val EuerZeileEncoder: EntityEncoder[EuerZeile] = jsonEncoderOf[EuerZeile]
}
