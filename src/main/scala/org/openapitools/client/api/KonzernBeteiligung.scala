package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import KonzernBeteiligung._

case class KonzernBeteiligung (
  companyName: String,
/* Erfüllte Kontroll-Indikatoren (§ 290 Abs. 2 HGB) als deutsche Bezeichnungen. */
  controlBasis: List[String],
controlled: Boolean,
ownershipPct: String)

object KonzernBeteiligung {
  import DateTimeCodecs._

  implicit val KonzernBeteiligungCodecJson: CodecJson[KonzernBeteiligung] = CodecJson.derive[KonzernBeteiligung]
  implicit val KonzernBeteiligungDecoder: EntityDecoder[KonzernBeteiligung] = jsonOf[KonzernBeteiligung]
  implicit val KonzernBeteiligungEncoder: EntityEncoder[KonzernBeteiligung] = jsonEncoderOf[KonzernBeteiligung]
}
