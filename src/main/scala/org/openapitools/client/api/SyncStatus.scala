package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SyncStatus._

case class SyncStatus (
  
object SyncStatus {
  import DateTimeCodecs._

  implicit val SyncStatusCodecJson: CodecJson[SyncStatus] = CodecJson.derive[SyncStatus]
  implicit val SyncStatusDecoder: EntityDecoder[SyncStatus] = jsonOf[SyncStatus]
  implicit val SyncStatusEncoder: EntityEncoder[SyncStatus] = jsonEncoderOf[SyncStatus]
}
