package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime
import java.util.UUID

import MarketplaceConnection._

case class MarketplaceConnection (
  config: AnyType,
connectionId: String,
connectorType: ConnectorType,
createdAt: OffsetDateTime,
isActive: Boolean,
label: String,
lastSyncAt: Option[OffsetDateTime],
platform: String,
platformUserId: Option[String],
scopes: Option[String],
shopDomain: Option[String],
shopName: Option[String],
syncStatus: Option[String],
tenantId: UUID,
updatedAt: Option[OffsetDateTime])

object MarketplaceConnection {
  import DateTimeCodecs._

  implicit val MarketplaceConnectionCodecJson: CodecJson[MarketplaceConnection] = CodecJson.derive[MarketplaceConnection]
  implicit val MarketplaceConnectionDecoder: EntityDecoder[MarketplaceConnection] = jsonOf[MarketplaceConnection]
  implicit val MarketplaceConnectionEncoder: EntityEncoder[MarketplaceConnection] = jsonEncoderOf[MarketplaceConnection]
}
