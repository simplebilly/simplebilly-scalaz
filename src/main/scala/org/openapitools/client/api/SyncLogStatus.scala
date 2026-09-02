package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SyncLogStatus._

case class SyncLogStatus (
  
object SyncLogStatus {
  import DateTimeCodecs._

  implicit val SyncLogStatusCodecJson: CodecJson[SyncLogStatus] = CodecJson.derive[SyncLogStatus]
  implicit val SyncLogStatusDecoder: EntityDecoder[SyncLogStatus] = jsonOf[SyncLogStatus]
  implicit val SyncLogStatusEncoder: EntityEncoder[SyncLogStatus] = jsonEncoderOf[SyncLogStatus]
}
