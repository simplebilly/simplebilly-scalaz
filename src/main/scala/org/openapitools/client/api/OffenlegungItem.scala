package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import OffenlegungItem._

case class OffenlegungItem (
  /* Ob die zugrunde liegenden Daten im System vorhanden sind. */
  exists: Boolean,
/* Bezeichnung des Offenlegungsbestandteils (§ 325 Abs. 1 HGB). */
  name: String,
/* Woher der Bestandteil stammt bzw. fehlt. */
  source: String)

object OffenlegungItem {
  import DateTimeCodecs._

  implicit val OffenlegungItemCodecJson: CodecJson[OffenlegungItem] = CodecJson.derive[OffenlegungItem]
  implicit val OffenlegungItemDecoder: EntityDecoder[OffenlegungItem] = jsonOf[OffenlegungItem]
  implicit val OffenlegungItemEncoder: EntityEncoder[OffenlegungItem] = jsonEncoderOf[OffenlegungItem]
}
