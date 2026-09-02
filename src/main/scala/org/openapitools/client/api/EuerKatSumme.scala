package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EuerKatSumme._

case class EuerKatSumme (
  betrag: String,
name: String)

object EuerKatSumme {
  import DateTimeCodecs._

  implicit val EuerKatSummeCodecJson: CodecJson[EuerKatSumme] = CodecJson.derive[EuerKatSumme]
  implicit val EuerKatSummeDecoder: EntityDecoder[EuerKatSumme] = jsonOf[EuerKatSumme]
  implicit val EuerKatSummeEncoder: EntityEncoder[EuerKatSumme] = jsonEncoderOf[EuerKatSumme]
}
