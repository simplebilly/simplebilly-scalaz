package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import BalanceSheet._

case class BalanceSheet (
  assets: List[BalanceItem],
balanced: Boolean,
equityLiabilities: List[BalanceItem],
totalAssets: String,
totalEquityLiabilities: String)

object BalanceSheet {
  import DateTimeCodecs._

  implicit val BalanceSheetCodecJson: CodecJson[BalanceSheet] = CodecJson.derive[BalanceSheet]
  implicit val BalanceSheetDecoder: EntityDecoder[BalanceSheet] = jsonOf[BalanceSheet]
  implicit val BalanceSheetEncoder: EntityEncoder[BalanceSheet] = jsonEncoderOf[BalanceSheet]
}
