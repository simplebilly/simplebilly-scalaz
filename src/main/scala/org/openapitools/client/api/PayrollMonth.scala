package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import PayrollMonth._

case class PayrollMonth (
  gross: String,
month: Integer,
net: String)

object PayrollMonth {
  import DateTimeCodecs._

  implicit val PayrollMonthCodecJson: CodecJson[PayrollMonth] = CodecJson.derive[PayrollMonth]
  implicit val PayrollMonthDecoder: EntityDecoder[PayrollMonth] = jsonOf[PayrollMonth]
  implicit val PayrollMonthEncoder: EntityEncoder[PayrollMonth] = jsonEncoderOf[PayrollMonth]
}
