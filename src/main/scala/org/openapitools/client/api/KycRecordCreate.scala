package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import KycRecordCreate._

case class KycRecordCreate (
  /* Referenz auf den Kunden/Kontakt. */
  customerId: Option[String],
/* Name des Kunden (für die Suche). */
  customerName: Option[String],
/* Datum der KYC-Prüfung (GwG § 8). */
  kycDate: Option[LocalDate],
/* Freitext-Notizen. */
  notes: Option[String],
/* Aufbewahrungsfrist (GwG § 8 Abs. 4: 5 Jahre). */
  retentionUntil: Option[LocalDate],
/* Risikoeinschätzung (z. B. Risikoklasse). */
  riskAssessment: Option[String])

object KycRecordCreate {
  import DateTimeCodecs._

  implicit val KycRecordCreateCodecJson: CodecJson[KycRecordCreate] = CodecJson.derive[KycRecordCreate]
  implicit val KycRecordCreateDecoder: EntityDecoder[KycRecordCreate] = jsonOf[KycRecordCreate]
  implicit val KycRecordCreateEncoder: EntityEncoder[KycRecordCreate] = jsonEncoderOf[KycRecordCreate]
}
