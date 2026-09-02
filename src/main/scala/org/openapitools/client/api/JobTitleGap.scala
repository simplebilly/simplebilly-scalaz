package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import JobTitleGap._

case class JobTitleGap (
  employeeCount: Integer,
femaleMeanHourly: String,
jobTitle: String,
maleMeanHourly: String,
meanGapPct: Double,
medianGapPct: Double)

object JobTitleGap {
  import DateTimeCodecs._

  implicit val JobTitleGapCodecJson: CodecJson[JobTitleGap] = CodecJson.derive[JobTitleGap]
  implicit val JobTitleGapDecoder: EntityDecoder[JobTitleGap] = jsonOf[JobTitleGap]
  implicit val JobTitleGapEncoder: EntityEncoder[JobTitleGap] = jsonEncoderOf[JobTitleGap]
}
