package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import Shareholder._

case class Shareholder (
  /* Anschrift des Aktionärs (§ 67 Abs. 1 AktG). */
  address: Option[String],
/* Geburtsdatum des Aktionärs (§ 67 Abs. 1 AktG). */
  birthDate: Option[LocalDate],
/* Elektronische Adresse (E-Mail) für die Kommunikation der Gesellschaft. */
  email: Option[String],
/* Vorname des Aktionärs (§ 67 Abs. 1 AktG). */
  firstName: Option[String],
/* Nachname des Aktionärs (§ 67 Abs. 1 AktG). */
  lastName: Option[String],
/* Aktiennummer bzw. Sammelurkunde (bei Nennbetragsaktien). */
  shareNumber: Option[String],
/* Stückzahl der gehaltenen Stückaktien (§ 67 Abs. 1 AktG). */
  shares: Option[String])

object Shareholder {
  import DateTimeCodecs._

  implicit val ShareholderCodecJson: CodecJson[Shareholder] = CodecJson.derive[Shareholder]
  implicit val ShareholderDecoder: EntityDecoder[Shareholder] = jsonOf[Shareholder]
  implicit val ShareholderEncoder: EntityEncoder[Shareholder] = jsonEncoderOf[Shareholder]
}
