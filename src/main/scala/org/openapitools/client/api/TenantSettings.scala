package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import TenantSettings._

case class TenantSettings (
  companyType: CompanyType,
dpaAcceptedAt: Option[OffsetDateTime],
dpaAcceptedBy: Option[String],
dpaVersion: Option[String],
/* Active feature toggles for the tenant. */
  features: AnyType)

object TenantSettings {
  import DateTimeCodecs._

  implicit val TenantSettingsCodecJson: CodecJson[TenantSettings] = CodecJson.derive[TenantSettings]
  implicit val TenantSettingsDecoder: EntityDecoder[TenantSettings] = jsonOf[TenantSettings]
  implicit val TenantSettingsEncoder: EntityEncoder[TenantSettings] = jsonEncoderOf[TenantSettings]
}
