package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import BudgetKategorie._

case class BudgetKategorie (
  budget: String,
differenz: String,
/* User-set monthly goal for the category, if any. */
  goal: Option[String],
ist: String,
kategorie: String)

object BudgetKategorie {
  import DateTimeCodecs._

  implicit val BudgetKategorieCodecJson: CodecJson[BudgetKategorie] = CodecJson.derive[BudgetKategorie]
  implicit val BudgetKategorieDecoder: EntityDecoder[BudgetKategorie] = jsonOf[BudgetKategorie]
  implicit val BudgetKategorieEncoder: EntityEncoder[BudgetKategorie] = jsonEncoderOf[BudgetKategorie]
}
