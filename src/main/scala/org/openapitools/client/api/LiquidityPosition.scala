package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import LiquidityPosition._

case class LiquidityPosition (
  accountsPayable: Double,
accountsReceivable: Double,
cashAndEquivalents: Double,
currentRatio: Double,
quickRatio: Double,
workingCapital: Double)

object LiquidityPosition {
  import DateTimeCodecs._

  implicit val LiquidityPositionCodecJson: CodecJson[LiquidityPosition] = CodecJson.derive[LiquidityPosition]
  implicit val LiquidityPositionDecoder: EntityDecoder[LiquidityPosition] = jsonOf[LiquidityPosition]
  implicit val LiquidityPositionEncoder: EntityEncoder[LiquidityPosition] = jsonEncoderOf[LiquidityPosition]
}
