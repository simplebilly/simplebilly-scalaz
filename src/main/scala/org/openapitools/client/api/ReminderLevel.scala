package org.openapitools.client.api

import argonaut._
import argonaut.EncodeJson._
import argonaut.DecodeJson._

import org.http4s.{EntityDecoder, EntityEncoder}
import org.http4s.argonaut._
import org.joda.time.DateTime


import ReminderLevel._

case class ReminderLevel (
  
object ReminderLevel {
  import DateTimeCodecs._

  implicit val ReminderLevelCodecJson: CodecJson[ReminderLevel] = CodecJson.derive[ReminderLevel]
  implicit val ReminderLevelDecoder: EntityDecoder[ReminderLevel] = jsonOf[ReminderLevel]
  implicit val ReminderLevelEncoder: EntityEncoder[ReminderLevel] = jsonEncoderOf[ReminderLevel]
}
