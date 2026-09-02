package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import KonzernThresholds._

case class KonzernThresholds (
  bilanzsumme: String,
mitarbeiter: Long,
nettoUmsatz: String)

object KonzernThresholds {
  import DateTimeCodecs._

  implicit val KonzernThresholdsCodecJson: CodecJson[KonzernThresholds] = CodecJson.derive[KonzernThresholds]
  implicit val KonzernThresholdsDecoder: EntityDecoder[KonzernThresholds] = jsonOf[KonzernThresholds]
  implicit val KonzernThresholdsEncoder: EntityEncoder[KonzernThresholds] = jsonEncoderOf[KonzernThresholds]
}
