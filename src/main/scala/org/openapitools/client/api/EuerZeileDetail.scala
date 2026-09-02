package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import EuerZeileDetail._

case class EuerZeileDetail (
  abschnitt: String,
betragGesamt: String,
bezeichnung: String,
kategorien: List[EuerKatSumme],
zeile: Integer)

object EuerZeileDetail {
  import DateTimeCodecs._

  implicit val EuerZeileDetailCodecJson: CodecJson[EuerZeileDetail] = CodecJson.derive[EuerZeileDetail]
  implicit val EuerZeileDetailDecoder: EntityDecoder[EuerZeileDetail] = jsonOf[EuerZeileDetail]
  implicit val EuerZeileDetailEncoder: EntityEncoder[EuerZeileDetail] = jsonEncoderOf[EuerZeileDetail]
}
