package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import TenantUser._

case class TenantUser (
  email: String,
emailVerified: Boolean,
isActive: Boolean,
joinedAt: OffsetDateTime,
lastLogin: Option[OffsetDateTime],
name: String,
permissions: List[String],
role: String,
userId: UUID)

object TenantUser {
  import DateTimeCodecs._

  implicit val TenantUserCodecJson: CodecJson[TenantUser] = CodecJson.derive[TenantUser]
  implicit val TenantUserDecoder: EntityDecoder[TenantUser] = jsonOf[TenantUser]
  implicit val TenantUserEncoder: EntityEncoder[TenantUser] = jsonEncoderOf[TenantUser]
}
