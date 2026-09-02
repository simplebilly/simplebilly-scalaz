package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import UpdateTenantSettings._

case class UpdateTenantSettings (
  companyType: CompanyType,
features: Option[PartialFeatureSettings])

object UpdateTenantSettings {
  import DateTimeCodecs._

  implicit val UpdateTenantSettingsCodecJson: CodecJson[UpdateTenantSettings] = CodecJson.derive[UpdateTenantSettings]
  implicit val UpdateTenantSettingsDecoder: EntityDecoder[UpdateTenantSettings] = jsonOf[UpdateTenantSettings]
  implicit val UpdateTenantSettingsEncoder: EntityEncoder[UpdateTenantSettings] = jsonEncoderOf[UpdateTenantSettings]
}
