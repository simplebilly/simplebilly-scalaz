package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import DeclarationUpdate._

case class DeclarationUpdate (
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

object DeclarationUpdate {
  import DateTimeCodecs._

  implicit val DeclarationUpdateCodecJson: CodecJson[DeclarationUpdate] = CodecJson.derive[DeclarationUpdate]
  implicit val DeclarationUpdateDecoder: EntityDecoder[DeclarationUpdate] = jsonOf[DeclarationUpdate]
  implicit val DeclarationUpdateEncoder: EntityEncoder[DeclarationUpdate] = jsonEncoderOf[DeclarationUpdate]
}
