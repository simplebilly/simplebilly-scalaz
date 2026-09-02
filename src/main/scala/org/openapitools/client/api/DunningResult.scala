package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DunningResult._

case class DunningResult (
  invoicesProcessed: Integer,
message: String)

object DunningResult {
  import DateTimeCodecs._

  implicit val DunningResultCodecJson: CodecJson[DunningResult] = CodecJson.derive[DunningResult]
  implicit val DunningResultDecoder: EntityDecoder[DunningResult] = jsonOf[DunningResult]
  implicit val DunningResultEncoder: EntityEncoder[DunningResult] = jsonEncoderOf[DunningResult]
}
