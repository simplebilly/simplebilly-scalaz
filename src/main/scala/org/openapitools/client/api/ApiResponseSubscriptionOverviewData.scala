package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import ApiResponseSubscriptionOverviewData._

case class ApiResponseSubscriptionOverviewData (
  currentPeriodEnd: Option[OffsetDateTime],
features: PlanFeatures,
isTrialing: Boolean,
limits: PlanLimits,
manageUrl: Option[String],
/* Resolved plan id (free/starter/business/enterprise, or a custom override id). */
  plan: String,
planName: String,
/* Monthly price in EUR; `-1.0` = custom pricing (enterprise). */
  priceEur: Double,
quantity: Option[Integer],
status: Option[String],
subscriptionId: Option[String],
trialEndsAt: Option[OffsetDateTime],
usage: UsageSnapshot)

object ApiResponseSubscriptionOverviewData {
  import DateTimeCodecs._

  implicit val ApiResponseSubscriptionOverviewDataCodecJson: CodecJson[ApiResponseSubscriptionOverviewData] = CodecJson.derive[ApiResponseSubscriptionOverviewData]
  implicit val ApiResponseSubscriptionOverviewDataDecoder: EntityDecoder[ApiResponseSubscriptionOverviewData] = jsonOf[ApiResponseSubscriptionOverviewData]
  implicit val ApiResponseSubscriptionOverviewDataEncoder: EntityEncoder[ApiResponseSubscriptionOverviewData] = jsonEncoderOf[ApiResponseSubscriptionOverviewData]
}
