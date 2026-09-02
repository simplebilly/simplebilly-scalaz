package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import SyncType._

case class SyncType (
  
object SyncType {
  import DateTimeCodecs._

  implicit val SyncTypeCodecJson: CodecJson[SyncType] = CodecJson.derive[SyncType]
  implicit val SyncTypeDecoder: EntityDecoder[SyncType] = jsonOf[SyncType]
  implicit val SyncTypeEncoder: EntityEncoder[SyncType] = jsonEncoderOf[SyncType]
}
