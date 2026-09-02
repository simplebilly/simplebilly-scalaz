package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import Declaration._

case class Declaration (
  /* Art der Erklärung: \"dcgk\" (Entsprechenserklärung § 161 AktG) oder \"unternehmensfuehrung\" (Erklärung zur Unternehmensführung § 289f HGB). */
  declarationType: Option[DeclarationType],
/* Kennzeichnet die aktuell gültige Fassung (max. eine je Mandant). */
  isCurrent: Option[Boolean],
/* Inhalt der Erklärung als Markdown. */
  text: Option[String],
/* Datum, ab dem die Erklärung gilt. */
  validFrom: Option[LocalDate],
/* Versionsbezeichnung der Erklärung (z.B. \"2025-01\"). */
  version: Option[String])

object Declaration {
  import DateTimeCodecs._

  implicit val DeclarationCodecJson: CodecJson[Declaration] = CodecJson.derive[Declaration]
  implicit val DeclarationDecoder: EntityDecoder[Declaration] = jsonOf[Declaration]
  implicit val DeclarationEncoder: EntityEncoder[Declaration] = jsonEncoderOf[Declaration]
}
