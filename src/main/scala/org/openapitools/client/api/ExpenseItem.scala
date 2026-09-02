package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ExpenseItem._

case class ExpenseItem (
  amount: String,
category: String,
percentage: Double)

object ExpenseItem {
  import DateTimeCodecs._

  implicit val ExpenseItemCodecJson: CodecJson[ExpenseItem] = CodecJson.derive[ExpenseItem]
  implicit val ExpenseItemDecoder: EntityDecoder[ExpenseItem] = jsonOf[ExpenseItem]
  implicit val ExpenseItemEncoder: EntityEncoder[ExpenseItem] = jsonEncoderOf[ExpenseItem]
}
