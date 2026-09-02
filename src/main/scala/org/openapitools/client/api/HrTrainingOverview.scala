package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import HrTrainingOverview._

case class HrTrainingOverview (
  assignedCount: Long,
code: String,
completedCount: Long,
overdueCount: Long,
title: String,
trainingId: UUID)

object HrTrainingOverview {
  import DateTimeCodecs._

  implicit val HrTrainingOverviewCodecJson: CodecJson[HrTrainingOverview] = CodecJson.derive[HrTrainingOverview]
  implicit val HrTrainingOverviewDecoder: EntityDecoder[HrTrainingOverview] = jsonOf[HrTrainingOverview]
  implicit val HrTrainingOverviewEncoder: EntityEncoder[HrTrainingOverview] = jsonEncoderOf[HrTrainingOverview]
}
