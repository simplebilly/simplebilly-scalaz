package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ApiResponseVecPlanDataInner._

case class ApiResponseVecPlanDataInner (
  features: PlanFeatures,
id: String,
limits: PlanLimits,
name: String,
priceEur: Double)

object ApiResponseVecPlanDataInner {
  import DateTimeCodecs._

  implicit val ApiResponseVecPlanDataInnerCodecJson: CodecJson[ApiResponseVecPlanDataInner] = CodecJson.derive[ApiResponseVecPlanDataInner]
  implicit val ApiResponseVecPlanDataInnerDecoder: EntityDecoder[ApiResponseVecPlanDataInner] = jsonOf[ApiResponseVecPlanDataInner]
  implicit val ApiResponseVecPlanDataInnerEncoder: EntityEncoder[ApiResponseVecPlanDataInner] = jsonEncoderOf[ApiResponseVecPlanDataInner]
}
