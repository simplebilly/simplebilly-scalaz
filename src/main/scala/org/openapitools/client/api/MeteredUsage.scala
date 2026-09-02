package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import MeteredUsage._

case class MeteredUsage (
  limit: Long,
meter: String,
used: Long)

object MeteredUsage {
  import DateTimeCodecs._

  implicit val MeteredUsageCodecJson: CodecJson[MeteredUsage] = CodecJson.derive[MeteredUsage]
  implicit val MeteredUsageDecoder: EntityDecoder[MeteredUsage] = jsonOf[MeteredUsage]
  implicit val MeteredUsageEncoder: EntityEncoder[MeteredUsage] = jsonEncoderOf[MeteredUsage]
}
