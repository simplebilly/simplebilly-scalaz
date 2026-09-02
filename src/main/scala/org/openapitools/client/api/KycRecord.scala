package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.LocalDate

import KycRecord._

case class KycRecord (
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

object KycRecord {
  import DateTimeCodecs._

  implicit val KycRecordCodecJson: CodecJson[KycRecord] = CodecJson.derive[KycRecord]
  implicit val KycRecordDecoder: EntityDecoder[KycRecord] = jsonOf[KycRecord]
  implicit val KycRecordEncoder: EntityEncoder[KycRecord] = jsonEncoderOf[KycRecord]
}
