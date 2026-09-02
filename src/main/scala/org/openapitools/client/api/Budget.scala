package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import Budget._

case class Budget (
  /* Posting category key (matches `category` on journal entries). */
  category: String,
/* Monthly goal amount (gross). 0 means \"no goal set\". */
  monthlyGoal: String,
updatedAt: Option[OffsetDateTime],
/* Budget year the goal applies to. */
  year: Integer)

object Budget {
  import DateTimeCodecs._

  implicit val BudgetCodecJson: CodecJson[Budget] = CodecJson.derive[Budget]
  implicit val BudgetDecoder: EntityDecoder[Budget] = jsonOf[Budget]
  implicit val BudgetEncoder: EntityEncoder[Budget] = jsonEncoderOf[Budget]
}
