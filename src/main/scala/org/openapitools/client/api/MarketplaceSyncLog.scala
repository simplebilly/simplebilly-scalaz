package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import MarketplaceSyncLog._

case class MarketplaceSyncLog (
  completedAt: Option[OffsetDateTime],
/* References the marketplace connection entity. */
  connectionId: String,
errorMessage: Option[String],
itemsFailed: Integer,
itemsSynced: Integer,
platform: String,
startedAt: OffsetDateTime,
status: SyncLogStatus,
syncType: SyncType)

object MarketplaceSyncLog {
  import DateTimeCodecs._

  implicit val MarketplaceSyncLogCodecJson: CodecJson[MarketplaceSyncLog] = CodecJson.derive[MarketplaceSyncLog]
  implicit val MarketplaceSyncLogDecoder: EntityDecoder[MarketplaceSyncLog] = jsonOf[MarketplaceSyncLog]
  implicit val MarketplaceSyncLogEncoder: EntityEncoder[MarketplaceSyncLog] = jsonEncoderOf[MarketplaceSyncLog]
}
