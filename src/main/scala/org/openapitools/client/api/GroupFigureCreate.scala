package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import GroupFigureCreate._

case class GroupFigureCreate (
  /* Bilanzsumme in EUR (§ 293 Abs. 1 Nr. 1 HGB). */
  bilanzsumme: Option[String],
/* § 291-Befreiung in Anspruch genommen. */
  exemptionClaimed: Option[Boolean],
/* Durchschnittliche Arbeitnehmerzahl (§ 293 Abs. 1 Nr. 3 HGB). */
  mitarbeiter: Option[Long],
/* Netto-Umsatzerlöse in EUR (§ 293 Abs. 1 Nr. 2 HGB). */
  nettoUmsatz: Option[String],
/* Name des Mutterunternehmens (§ 291 HGB, Zwischenholding). */
  parentName: Option[String],
/* Sitz des Mutterunternehmens, z. B. \"EU/EWR\" (§ 291 HGB). */
  parentSitus: Option[String])

object GroupFigureCreate {
  import DateTimeCodecs._

  implicit val GroupFigureCreateCodecJson: CodecJson[GroupFigureCreate] = CodecJson.derive[GroupFigureCreate]
  implicit val GroupFigureCreateDecoder: EntityDecoder[GroupFigureCreate] = jsonOf[GroupFigureCreate]
  implicit val GroupFigureCreateEncoder: EntityEncoder[GroupFigureCreate] = jsonEncoderOf[GroupFigureCreate]
}
