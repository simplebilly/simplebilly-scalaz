package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import KontoItem._

case class KontoItem (
  anfangsbestand: String,
habenUmsatz: String,
konto: String,
name: String,
saldo: String,
sollUmsatz: String)

object KontoItem {
  import DateTimeCodecs._

  implicit val KontoItemCodecJson: CodecJson[KontoItem] = CodecJson.derive[KontoItem]
  implicit val KontoItemDecoder: EntityDecoder[KontoItem] = jsonOf[KontoItem]
  implicit val KontoItemEncoder: EntityEncoder[KontoItem] = jsonEncoderOf[KontoItem]
}
