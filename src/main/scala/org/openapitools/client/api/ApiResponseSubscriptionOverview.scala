package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ApiResponseSubscriptionOverview._

case class ApiResponseSubscriptionOverview (
  data: Option[ApiResponseSubscriptionOverviewData],
error: Option[String],
message: Option[String],
success: Boolean)

object ApiResponseSubscriptionOverview {
  import DateTimeCodecs._

  implicit val ApiResponseSubscriptionOverviewCodecJson: CodecJson[ApiResponseSubscriptionOverview] = CodecJson.derive[ApiResponseSubscriptionOverview]
  implicit val ApiResponseSubscriptionOverviewDecoder: EntityDecoder[ApiResponseSubscriptionOverview] = jsonOf[ApiResponseSubscriptionOverview]
  implicit val ApiResponseSubscriptionOverviewEncoder: EntityEncoder[ApiResponseSubscriptionOverview] = jsonEncoderOf[ApiResponseSubscriptionOverview]
}
