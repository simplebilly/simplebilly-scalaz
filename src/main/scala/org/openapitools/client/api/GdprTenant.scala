package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.util.UUID

import GdprTenant._

case class GdprTenant (
  name: String,
role: String,
tenantId: UUID)

object GdprTenant {
  import DateTimeCodecs._

  implicit val GdprTenantCodecJson: CodecJson[GdprTenant] = CodecJson.derive[GdprTenant]
  implicit val GdprTenantDecoder: EntityDecoder[GdprTenant] = jsonOf[GdprTenant]
  implicit val GdprTenantEncoder: EntityEncoder[GdprTenant] = jsonEncoderOf[GdprTenant]
}
