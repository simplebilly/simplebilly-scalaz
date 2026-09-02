package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ApiResponseVecUserTenantInfo._

case class ApiResponseVecUserTenantInfo (
  data: Option[List[ApiResponseVecUserTenantInfoDataInner]],
error: Option[String],
message: Option[String],
success: Boolean)

object ApiResponseVecUserTenantInfo {
  import DateTimeCodecs._

  implicit val ApiResponseVecUserTenantInfoCodecJson: CodecJson[ApiResponseVecUserTenantInfo] = CodecJson.derive[ApiResponseVecUserTenantInfo]
  implicit val ApiResponseVecUserTenantInfoDecoder: EntityDecoder[ApiResponseVecUserTenantInfo] = jsonOf[ApiResponseVecUserTenantInfo]
  implicit val ApiResponseVecUserTenantInfoEncoder: EntityEncoder[ApiResponseVecUserTenantInfo] = jsonEncoderOf[ApiResponseVecUserTenantInfo]
}
