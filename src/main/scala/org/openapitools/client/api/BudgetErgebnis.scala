package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import BudgetErgebnis._

case class BudgetErgebnis (
  jahr: Integer,
monat: Integer,
monatsBudget: List[BudgetKategorie],
prognoseRestjahr: List[BudgetKategorie])

object BudgetErgebnis {
  import DateTimeCodecs._

  implicit val BudgetErgebnisCodecJson: CodecJson[BudgetErgebnis] = CodecJson.derive[BudgetErgebnis]
  implicit val BudgetErgebnisDecoder: EntityDecoder[BudgetErgebnis] = jsonOf[BudgetErgebnis]
  implicit val BudgetErgebnisEncoder: EntityEncoder[BudgetErgebnis] = jsonEncoderOf[BudgetErgebnis]
}
