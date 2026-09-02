package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import BWAExpenses._

case class BWAExpenses (
  expenseBreakdown: List[ExpenseItem],
totalExpenses: String)

object BWAExpenses {
  import DateTimeCodecs._

  implicit val BWAExpensesCodecJson: CodecJson[BWAExpenses] = CodecJson.derive[BWAExpenses]
  implicit val BWAExpensesDecoder: EntityDecoder[BWAExpenses] = jsonOf[BWAExpenses]
  implicit val BWAExpensesEncoder: EntityEncoder[BWAExpenses] = jsonEncoderOf[BWAExpenses]
}
