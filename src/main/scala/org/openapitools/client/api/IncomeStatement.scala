package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import IncomeStatement._

case class IncomeStatement (
  expenseItems: List[PnLItem],
netIncome: String,
revenueItems: List[PnLItem],
totalExpenses: String,
totalRevenue: String)

object IncomeStatement {
  import DateTimeCodecs._

  implicit val IncomeStatementCodecJson: CodecJson[IncomeStatement] = CodecJson.derive[IncomeStatement]
  implicit val IncomeStatementDecoder: EntityDecoder[IncomeStatement] = jsonOf[IncomeStatement]
  implicit val IncomeStatementEncoder: EntityEncoder[IncomeStatement] = jsonEncoderOf[IncomeStatement]
}
