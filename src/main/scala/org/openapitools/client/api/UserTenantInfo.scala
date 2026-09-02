package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import UserTenantInfo._

case class UserTenantInfo (
  customDomain: Option[String],
role: String,
subdomain: Option[String],
tenantId: UUID,
tenantName: String)

object UserTenantInfo {
  import DateTimeCodecs._

  implicit val UserTenantInfoCodecJson: CodecJson[UserTenantInfo] = CodecJson.derive[UserTenantInfo]
  implicit val UserTenantInfoDecoder: EntityDecoder[UserTenantInfo] = jsonOf[UserTenantInfo]
  implicit val UserTenantInfoEncoder: EntityEncoder[UserTenantInfo] = jsonEncoderOf[UserTenantInfo]
}
