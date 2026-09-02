package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import ApiResponseVecUserTenantInfoDataInner._

case class ApiResponseVecUserTenantInfoDataInner (
  customDomain: Option[String],
role: String,
subdomain: Option[String],
tenantId: UUID,
tenantName: String)

object ApiResponseVecUserTenantInfoDataInner {
  import DateTimeCodecs._

  implicit val ApiResponseVecUserTenantInfoDataInnerCodecJson: CodecJson[ApiResponseVecUserTenantInfoDataInner] = CodecJson.derive[ApiResponseVecUserTenantInfoDataInner]
  implicit val ApiResponseVecUserTenantInfoDataInnerDecoder: EntityDecoder[ApiResponseVecUserTenantInfoDataInner] = jsonOf[ApiResponseVecUserTenantInfoDataInner]
  implicit val ApiResponseVecUserTenantInfoDataInnerEncoder: EntityEncoder[ApiResponseVecUserTenantInfoDataInner] = jsonEncoderOf[ApiResponseVecUserTenantInfoDataInner]
}
