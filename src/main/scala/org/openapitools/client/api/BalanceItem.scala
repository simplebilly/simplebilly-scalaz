package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import BalanceItem._

case class BalanceItem (
  account: String,
accountName: String,
amount: String)

object BalanceItem {
  import DateTimeCodecs._

  implicit val BalanceItemCodecJson: CodecJson[BalanceItem] = CodecJson.derive[BalanceItem]
  implicit val BalanceItemDecoder: EntityDecoder[BalanceItem] = jsonOf[BalanceItem]
  implicit val BalanceItemEncoder: EntityEncoder[BalanceItem] = jsonEncoderOf[BalanceItem]
}
