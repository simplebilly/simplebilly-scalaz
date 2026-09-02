package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import ParticipationUpdate._

case class ParticipationUpdate (
  /* Datum des Erwerbs der Beteiligung. */
  acquiredAt: Option[LocalDate],
/* Bestellungsrecht für Geschäftsführung/Aufsichtsrat (§ 290 Abs. 2 Nr. 2 HGB). */
  boardAppointment: Option[Boolean],
/* Name des Beteiligungsunternehmens (§ 271 HGB). */
  companyName: Option[String],
/* Beherrschungsvertrag (§ 290 Abs. 2 Nr. 3 HGB). */
  controlAgreement: Option[Boolean],
/* Rechtsform, z. B. \"GmbH\". */
  legalForm: Option[String],
/* Anteilsquote in Prozent (§ 271 HGB; > 20 % widerlegbare Vermutung). */
  ownershipPct: Option[String],
/* Zweckgesellschaft (§ 290 Abs. 2 Nr. 4 HGB). */
  purposeVehicle: Option[Boolean],
/* Stimmrechtsmehrheit (§ 290 Abs. 2 Nr. 1 HGB). */
  votingMajority: Option[Boolean])

object ParticipationUpdate {
  import DateTimeCodecs._

  implicit val ParticipationUpdateCodecJson: CodecJson[ParticipationUpdate] = CodecJson.derive[ParticipationUpdate]
  implicit val ParticipationUpdateDecoder: EntityDecoder[ParticipationUpdate] = jsonOf[ParticipationUpdate]
  implicit val ParticipationUpdateEncoder: EntityEncoder[ParticipationUpdate] = jsonEncoderOf[ParticipationUpdate]
}
