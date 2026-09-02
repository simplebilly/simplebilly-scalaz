package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import SilentPartnerCreate._

case class SilentPartnerCreate (
  /* Datum des Vertragsabschlusses. */
  contractDate: Option[LocalDate],
/* Einlage (§ 230 HGB). */
  einlage: Option[String],
/* Gewinnbeteiligungsquote in Prozent (§ 231 HGB). */
  gewinnquotePct: Option[String],
/* Nicht erhobene Gewinne (§ 232 Abs. 3 HGB). */
  gewinnvortrag: Option[String],
/* Instrument: \"typisch\" | \"atypisch\" | \"partiarisches_darlehen\" | \"genussrecht\". */
  instrumentType: InstrumentType,
/* 25 % Kapitalertragsteuer einbehalten (§ 43 Abs. 1 Nr. 3 EStG; typisch + partiarisches Darlehen). */
  kestPflichtig: Option[Boolean],
/* Name des stillen Gesellschafters. */
  name: Option[String],
/* Freitext-Notizen. */
  notes: Option[String],
/* Kumulierte Verluste gegen die Einlage (§ 232 Abs. 2 HGB, ≤ Einlage). */
  verlustVerrechnungskonto: Option[String],
/* Verlustbeteiligung (§ 231 Abs. 2 HGB; kann ausgeschlossen werden). */
  verlustbeteiligung: Option[Boolean])

object SilentPartnerCreate {
  import DateTimeCodecs._

  implicit val SilentPartnerCreateCodecJson: CodecJson[SilentPartnerCreate] = CodecJson.derive[SilentPartnerCreate]
  implicit val SilentPartnerCreateDecoder: EntityDecoder[SilentPartnerCreate] = jsonOf[SilentPartnerCreate]
  implicit val SilentPartnerCreateEncoder: EntityEncoder[SilentPartnerCreate] = jsonEncoderOf[SilentPartnerCreate]
}
