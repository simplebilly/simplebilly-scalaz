package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import EmissionEntry._

case class EmissionEntry (
  /* Activity amount in `unit` (kWh, l, km, t, tkm, EUR). */
  activityValue: String,
/* GHG-Protocol category key, e.g. \"purchased_goods\", \"business_travel\". */
  categoryId: String,
description: String,
/* Emission-factor source, e.g. \"UBA-2024\", \"DEFRA-2024\". */
  efSource: String,
efVersion: String,
/* \"activity\" | \"spend\" | \"supplier\". */
  method: EmissionMethod,
/* GHG scope: \"1\" | \"2\" | \"3\". */
  scope: GhgScope,
/* Computed server-side: activity * factor / 1000, rounded to 4 dp. */
  tco2e: String,
/* Unit of the activity value. */
  unit: String,
updatedAt: Option[OffsetDateTime],
/* Reporting year. */
  year: Integer)

object EmissionEntry {
  import DateTimeCodecs._

  implicit val EmissionEntryCodecJson: CodecJson[EmissionEntry] = CodecJson.derive[EmissionEntry]
  implicit val EmissionEntryDecoder: EntityDecoder[EmissionEntry] = jsonOf[EmissionEntry]
  implicit val EmissionEntryEncoder: EntityEncoder[EmissionEntry] = jsonEncoderOf[EmissionEntry]
}
