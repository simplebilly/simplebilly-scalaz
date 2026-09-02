package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import BudgetGoalRequest._

case class BudgetGoalRequest (
  /* Monthly goal amount (gross). 0 means \"no goal\" (fallback to default). */
  monthlyGoal: String,
/* Budget year the goal applies to. */
  year: Integer)

object BudgetGoalRequest {
  import DateTimeCodecs._

  implicit val BudgetGoalRequestCodecJson: CodecJson[BudgetGoalRequest] = CodecJson.derive[BudgetGoalRequest]
  implicit val BudgetGoalRequestDecoder: EntityDecoder[BudgetGoalRequest] = jsonOf[BudgetGoalRequest]
  implicit val BudgetGoalRequestEncoder: EntityEncoder[BudgetGoalRequest] = jsonEncoderOf[BudgetGoalRequest]
}
