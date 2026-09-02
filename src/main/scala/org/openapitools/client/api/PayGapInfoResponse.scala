package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import PayGapInfoResponse._

case class PayGapInfoResponse (
  employeeId: UUID,
firstName: String,
gender: Option[String],
groupMedianHourly: Option[Double],
groupMedianMonthly: Option[Double],
groupSize: Integer,
jobTitle: String,
lastName: String,
overallMedianHourly: Option[Double],
ownHourlyGross: Option[Double],
ownMonthlyGross: Option[Double])

object PayGapInfoResponse {
  import DateTimeCodecs._

  implicit val PayGapInfoResponseCodecJson: CodecJson[PayGapInfoResponse] = CodecJson.derive[PayGapInfoResponse]
  implicit val PayGapInfoResponseDecoder: EntityDecoder[PayGapInfoResponse] = jsonOf[PayGapInfoResponse]
  implicit val PayGapInfoResponseEncoder: EntityEncoder[PayGapInfoResponse] = jsonEncoderOf[PayGapInfoResponse]
}
