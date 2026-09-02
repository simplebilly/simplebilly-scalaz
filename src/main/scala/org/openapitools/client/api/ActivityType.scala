package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ActivityType._

case class ActivityType (
  
object ActivityType {
  import DateTimeCodecs._

  implicit val ActivityTypeCodecJson: CodecJson[ActivityType] = CodecJson.derive[ActivityType]
  implicit val ActivityTypeDecoder: EntityDecoder[ActivityType] = jsonOf[ActivityType]
  implicit val ActivityTypeEncoder: EntityEncoder[ActivityType] = jsonEncoderOf[ActivityType]
}
