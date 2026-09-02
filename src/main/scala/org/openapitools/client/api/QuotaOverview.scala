package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import QuotaOverview._

case class QuotaOverview (
  features: PlanFeatures,
isTrialing: Boolean,
limits: PlanLimits,
metered: List[MeteredUsage],
plan: String,
planName: String,
trialEndsAt: Option[OffsetDateTime],
usage: UsageSnapshot)

object QuotaOverview {
  import DateTimeCodecs._

  implicit val QuotaOverviewCodecJson: CodecJson[QuotaOverview] = CodecJson.derive[QuotaOverview]
  implicit val QuotaOverviewDecoder: EntityDecoder[QuotaOverview] = jsonOf[QuotaOverview]
  implicit val QuotaOverviewEncoder: EntityEncoder[QuotaOverview] = jsonEncoderOf[QuotaOverview]
}
