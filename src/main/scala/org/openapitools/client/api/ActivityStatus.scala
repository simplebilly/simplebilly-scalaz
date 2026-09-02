package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ActivityStatus._

case class ActivityStatus (
  
object ActivityStatus {
  import DateTimeCodecs._

  implicit val ActivityStatusCodecJson: CodecJson[ActivityStatus] = CodecJson.derive[ActivityStatus]
  implicit val ActivityStatusDecoder: EntityDecoder[ActivityStatus] = jsonOf[ActivityStatus]
  implicit val ActivityStatusEncoder: EntityEncoder[ActivityStatus] = jsonEncoderOf[ActivityStatus]
}
