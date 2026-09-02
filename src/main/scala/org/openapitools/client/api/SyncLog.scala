package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime

import java.time.OffsetDateTime

import SyncLog._

case class SyncLog (
  completedAt: Option[OffsetDateTime],
connectionId: String,
errorMessage: Option[String],
itemsFailed: Integer,
itemsSynced: Integer,
logId: String,
platform: String,
startedAt: OffsetDateTime,
status: String,
syncType: String)

object SyncLog {
  import DateTimeCodecs._

  implicit val SyncLogCodecJson: CodecJson[SyncLog] = CodecJson.derive[SyncLog]
  implicit val SyncLogDecoder: EntityDecoder[SyncLog] = jsonOf[SyncLog]
  implicit val SyncLogEncoder: EntityEncoder[SyncLog] = jsonEncoderOf[SyncLog]
}
