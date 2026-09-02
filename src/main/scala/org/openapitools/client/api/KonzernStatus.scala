package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import KonzernStatus._

case class KonzernStatus (
  groessenbefreit: Boolean,
kapitalmarktorientiert: Boolean,
konzernabschlusspflicht: Boolean,
/* Keine group_figures-Zeile für das Jahr vorhanden → keine Größenbefreiung. */
  missingGroupFigures: Boolean,
/* Mutterunternehmen: mindestens eine beherrschte Beteiligung (§ 290 Abs. 1 HGB). */
  mutterunternehmen: Boolean,
/* Mutterunternehmen für die Zwischenholding-Befreiung (§ 291 HGB). */
  parentName: Option[String],
parentSitus: Option[String],
participations: List[KonzernBeteiligung],
thresholds: KonzernThresholds,
year: Integer,
zwischenholdingBefreit: Boolean,
/* Hinweis zu den § 291-Voraussetzungen (EU/EWR-Sitz, geprüfter Konzernabschluss). */
  zwischenholdingHinweis: Option[String])

object KonzernStatus {
  import DateTimeCodecs._

  implicit val KonzernStatusCodecJson: CodecJson[KonzernStatus] = CodecJson.derive[KonzernStatus]
  implicit val KonzernStatusDecoder: EntityDecoder[KonzernStatus] = jsonOf[KonzernStatus]
  implicit val KonzernStatusEncoder: EntityEncoder[KonzernStatus] = jsonEncoderOf[KonzernStatus]
}
