package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import DataQuality._

case class DataQuality (
  activityLines: Integer,
activitySharePct: Double,
spendLines: Integer)

object DataQuality {
  import DateTimeCodecs._

  implicit val DataQualityCodecJson: CodecJson[DataQuality] = CodecJson.derive[DataQuality]
  implicit val DataQualityDecoder: EntityDecoder[DataQuality] = jsonOf[DataQuality]
  implicit val DataQualityEncoder: EntityEncoder[DataQuality] = jsonEncoderOf[DataQuality]
}
